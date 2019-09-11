package com.wushang.test1.service;

import com.wushang.test1.mapper.UserMapper;
import com.wushang.test2.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-11 00:19
 */

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private CustomerMapper customerMapper;

	public void register(String username, String password) {
		userMapper.save(username, password);

		int i = 1 / 0;

		customerMapper.save(username, "131");
	}
}
