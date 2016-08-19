package com.gqsoft.framework.oauth2.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gqsoft.framework.oauth2.domain.dto.UserFormDto;
import com.gqsoft.framework.oauth2.domain.dto.UserJsonDto;
import com.gqsoft.framework.oauth2.domain.dto.UserOverviewDto;

public interface UserService extends UserDetailsService {

	UserJsonDto loadCurrentUserJsonDto();

	UserOverviewDto loadUserOverviewDto(UserOverviewDto overviewDto);

	boolean isExistedUsername(String username);

	String saveUser(UserFormDto formDto);
}