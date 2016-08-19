package com.gqsoft.framework.oauth2.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.gqsoft.framework.oauth2.domain.Privilege;
import com.gqsoft.framework.oauth2.domain.dto.UserFormDto;
import com.gqsoft.framework.oauth2.service.UserService;

/**
 * 
* @ClassName: UserFormDtoValidator 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GQ Email:guoquan913@qq.com
* @date 2016年8月19日 下午3:28:38 
*
 */
@Component
public class UserFormDtoValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserFormDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserFormDto formDto = (UserFormDto) target;

		validateUsername(errors, formDto);
		validatePassword(errors, formDto);
		validatePrivileges(errors, formDto);
	}

	private void validatePrivileges(Errors errors, UserFormDto formDto) {
		final List<Privilege> privileges = formDto.getPrivileges();
		if (privileges == null || privileges.isEmpty()) {
			errors.rejectValue("privileges", null, "Privileges is required");
		}
	}

	private void validatePassword(Errors errors, UserFormDto formDto) {
		final String password = formDto.getPassword();
		if (StringUtils.isEmpty(password)) {
			errors.rejectValue("password", null, "Password is required");
		}
	}

	private void validateUsername(Errors errors, UserFormDto formDto) {
		final String username = formDto.getUsername();
		if (StringUtils.isEmpty(username)) {
			errors.rejectValue("username", null, "Username is required");
			return;
		}

		boolean existed = userService.isExistedUsername(username);
		if (existed) {
			errors.rejectValue("username", null, "Username already existed");
		}

	}
}
