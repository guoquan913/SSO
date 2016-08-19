/*
 * Copyright (c) 2015 MONKEYK Information Technology Co. Ltd
 * www.monkeyk.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * MONKEYK Information Technology Co. Ltd ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with MONKEYK Information Technology Co. Ltd.
 */
package com.gqsoft.framework.oauth2.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gqsoft.framework.oauth2.domain.Oauth2User;

public class UserRowMapper implements RowMapper<Oauth2User> {

	public UserRowMapper() {
	}

	@Override
	public Oauth2User mapRow(ResultSet rs, int i) throws SQLException {
		Oauth2User user = new Oauth2User();

		user.id(rs.getInt("id"));
		user.guid(rs.getString("guid"));

		user.archived(rs.getBoolean("archived"));
		user.createTime(rs.getTimestamp("create_time").toLocalDateTime());

		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));

		user.setPassword(rs.getString("password"));
		user.setUsername(rs.getString("username"));

		user.setLastLoginTime(rs.getTimestamp("last_login_time"));

		return user;
	}
}
