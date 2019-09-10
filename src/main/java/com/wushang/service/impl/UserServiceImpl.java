package com.wushang.service.impl;

import com.wushang.mapper.UserMapper;
import com.wushang.model.User;
import com.wushang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 22:07
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void register(String username, String password) {

		userMapper.save(username, password);

		//int i = 1 / 0;
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
}
