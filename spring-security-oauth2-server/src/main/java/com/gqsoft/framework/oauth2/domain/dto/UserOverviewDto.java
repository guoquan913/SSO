package com.gqsoft.framework.oauth2.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserOverviewDto implements Serializable {
	private static final long serialVersionUID = 2023379587030489248L;

	private String username;

	private List<UserDto> userDtos = new ArrayList<>();

	public UserOverviewDto() {
	}

	public int getSize() {
		return userDtos.size();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDto> userDtos) {
		this.userDtos = userDtos;
	}
}
