package com.wushang.web.controller;

import com.wushang.test1.service.UserServiceImpl;
import com.wushang.test2.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Name;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 12:36
 */

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


	@RequestMapping("register")
	public String register(String username,String password){
		//把数据保存到test1数据库
		userService.register(username,password);

		return "success";
	}

}
