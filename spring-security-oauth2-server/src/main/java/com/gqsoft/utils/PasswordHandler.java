package com.gqsoft.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * @ClassName: PasswordHandler
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author GQ Email:guoquan913@qq.com
 * @date 2016年8月19日 下午3:30:12
 * 
 */
public abstract class PasswordHandler {

	private PasswordHandler() {
	}

	public static String md5(String password) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		return encoder.encodePassword(password, null);
	}
}
