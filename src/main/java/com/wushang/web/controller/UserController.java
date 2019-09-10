package com.wushang.web.controller;

import com.wushang.model.User;
import com.wushang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 12:36
 */

@RestController
@RequestMapping("user")
public class UserController {

	//通过id查找用户信息
	@RequestMapping("{id}")
	@ResponseBody
	public User userInfo(@PathVariable() Integer id) {
		User user = new User("wushang", "123");
		user.setId(id);
		int i = 1 / 0;
		return user;

	}

	// public static void main(String[] args) {
	// 	SpringApplication.run(UserController.class, args);
	// }

	@Autowired
	private IUserService userService;

	@RequestMapping("register")
	public String register(String username,String password){
		userService.register(username,password);
		return "success";
	}
}
