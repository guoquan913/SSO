package com.gqsoft.framework.oauth2.provider.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import com.gqsoft.framework.oauth2.domain.Oauth2User;

/***
 * 数据库用户信息认证服务类
 */
public class Oauth2UserDetailsService implements UserDetailsService {

	private final static Logger logger = Logger.getLogger(Oauth2UserDetailsService.class);
	private DataSource dataSource;
	private final JdbcTemplate jdbcTemplate;
	private final static String selectUserByUserNameSql = "SELECT username ,password,enabled ,role FROM users where username =? ";

	public Oauth2UserDetailsService(DataSource dataSource) {
		Assert.notNull(dataSource, "DataSource required");
		this.setDataSource(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/***
	 * 根据用户名获取授权后的用户信息
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("用户授权..... 用户名为: " + username);
		UserDetails userDetails;
		try {
			userDetails = jdbcTemplate.queryForObject(selectUserByUserNameSql, new UserDetailsRowMapper(), username);
		} catch (EmptyResultDataAccessException e) {
			throw new UsernameNotFoundException("UsernameNotFound :" + username);
		}

		logger.info("用户信息为: " + userDetails);
		return userDetails;
	}
	private static class UserDetailsRowMapper implements RowMapper<UserDetails> {
		public UserDetails mapRow(ResultSet rs, int indx) throws SQLException {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(rs.getString("role"));
			authorities.add(authority);
			Oauth2User appUser = new Oauth2User(rs.getString("username"), rs.getString("password"), rs.getBoolean("enabled"), true, true, true, authorities);
			return appUser;
		}
	}

	/**
	 * @return dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            要设置的 dataSource
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
