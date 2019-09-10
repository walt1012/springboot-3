package com.wushang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.wushang")
public class App {
	public static void main(String[] args) {

		//启动springboot项目
		SpringApplication.run(App.class, args);
	}
}
