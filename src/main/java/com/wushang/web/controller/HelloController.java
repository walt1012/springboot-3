package com.wushang.web.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

@RestController//声明rest风格控制器
public class HelloController {

	@RequestMapping("hello/{name}")
	@ResponseBody
	public String hello(@PathVariable("name") String name) {
		return name + ": Hello SpringBoot";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloController.class, args);
	}
}
