package com.gqsoft.framework.oauth2.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.gqsoft.framework.oauth2.domain.Oauth2User;

/**
 * @author GQ 获取当前
 */
public class SecurityUserUtil {

	public static boolean isSuperAdmin(String accountName) {
		if (accountName == null || accountName.trim().equals("")) {
			return false;
		} else if (accountName.trim().equals("admin")) {
			return true;
		}
		return false;
	}

	public static Oauth2User getCurrentUser() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null)
			return null;
		if (au.getPrincipal() == null)
			return null;
		if (au != null && au.getPrincipal() instanceof Oauth2User) {
			return (Oauth2User) au.getPrincipal();
		} else {
			Oauth2User user = new Oauth2User();
			user.setUsername(au.getPrincipal().toString());
			user.setPassword(au.getCredentials() == null ? null : au.getCredentials().toString());
			return user;
		}
	}

	public static String getCurrentUserName() {
		Oauth2User user = getCurrentUser();
		if (user == null)
			return "";
		return user.getUsername() != null ? user.getUsername() : "";
	}

	public static boolean isLogged() {
		Authentication au = SecurityContextHolder.getContext().getAuthentication();
		if (au == null)
			return false;
		if (au.getPrincipal() == null)
			return false;
		if (au.getPrincipal() instanceof UserDetails)
			return true;
		return false;
	}

}
