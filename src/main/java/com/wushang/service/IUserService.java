package com.wushang.service;

import com.wushang.model.User;

/**
 * @ClassName IUserService
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 22:06
 */
public interface IUserService {
	public void register(String username,String password);
	public User findByUsername(String username);
}
