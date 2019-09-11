package com.wushang.dbconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName DBConfig1
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-11 10:01
 */

@ConfigurationProperties("mysql.datasource.test1")
public class DBConfig1 {
	private String url;
	private String username;
	private String password;


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
