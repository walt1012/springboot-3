package com.wushang.mapper;

import com.wushang.model.User;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-10 22:27
 */
public interface UserMapper {

	public int save(String username,String password);

	public User findByUsername(String username);
}
