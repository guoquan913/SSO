package com.gqsoft.framework.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
* @ClassName: UserController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author GQ Email:guoquan913@qq.com
* @date 2016年8月19日 下午3:28:31 
*
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

	@RequestMapping(value="/addUser",method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody  
	public String addUser() {
		return "/api/user/addUser";
	}
}
