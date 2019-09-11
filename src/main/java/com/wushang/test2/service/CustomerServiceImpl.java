package com.wushang.test2.service;

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
public class CustomerServiceImpl {

	@Autowired
	private CustomerMapper customerMapper;

	public void save(String name,String tel){
		customerMapper.save(name,tel);
	}
}
