package com.wushang.service.impl;

import com.wushang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 22:07
 */

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(String username, String password) {
		String sql = "INSERT User (username,password) value (?,?)";
		jdbcTemplate.update(sql,username,password);
	}
}
