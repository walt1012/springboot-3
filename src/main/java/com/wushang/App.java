package com.wushang;

import com.wushang.dbconfig.DBConfig1;
import com.wushang.dbconfig.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 */

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.wushang")
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
public class App {
	public static void main(String[] args) {

		//启动springboot项目
		SpringApplication.run(App.class, args);
	}
}
