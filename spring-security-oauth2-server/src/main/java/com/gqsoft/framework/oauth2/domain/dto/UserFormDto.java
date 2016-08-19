package com.gqsoft.framework.oauth2.domain.dto;

import com.gqsoft.framework.oauth2.domain.Oauth2User;
import com.gqsoft.framework.oauth2.domain.Privilege;
import com.gqsoft.utils.PasswordHandler;

/**
 * 2016/3/25
 *
 * @author Shengzhao Li
 */
public class UserFormDto extends UserDto {
    private static final long serialVersionUID = 7959857016962260738L;


    private String password;

    public UserFormDto() {
    }


    public Privilege[] getAllPrivileges() {
        return new Privilege[]{Privilege.MOBILE, Privilege.UNITY};
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Oauth2User newUser() {
        final Oauth2User user = new Oauth2User();
        user.setUsername(getUsername());
        user.setPhone(getPhone());
        user.setEmail(getEmail());
        user.setPassword(PasswordHandler.md5(getPassword()));
        user.privileges().addAll(getPrivileges());
        return user;
    }
}
