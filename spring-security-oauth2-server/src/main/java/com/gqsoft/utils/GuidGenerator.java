package com.gqsoft.utils;

import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;

import java.util.UUID;

/**
 * @ClassName: GuidGenerator
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author GQ Email:guoquan913@qq.com
 * @date 2016年8月19日 下午3:29:53
 * 
 */
public abstract class GuidGenerator {

	private static RandomValueStringGenerator defaultClientSecretGenerator = new RandomValueStringGenerator(32);

	/**
	 * private constructor
	 */
	private GuidGenerator() {
	}

	public static String generate() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String generateClientSecret() {
		return defaultClientSecretGenerator.generate();
	}
}