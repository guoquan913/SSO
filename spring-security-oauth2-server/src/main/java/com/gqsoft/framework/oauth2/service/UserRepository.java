package com.gqsoft.framework.oauth2.service;

import java.util.List;

import com.gqsoft.framework.oauth2.domain.Oauth2User;

public interface UserRepository extends Repository {

	Oauth2User findByGuid(String guid);

	void saveUser(Oauth2User user);

	void updateUser(Oauth2User user);

	Oauth2User findByUsername(String username);

	List<Oauth2User> findUsersByUsername(String username);
}