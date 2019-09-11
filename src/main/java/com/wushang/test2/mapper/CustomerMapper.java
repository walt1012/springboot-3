package com.wushang.test2.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName CustomerMapper
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-11 00:22
 */
public interface CustomerMapper {

	@Insert("insert customer (name,tel) values(#{name},#{tel})")
	public int save(@Param("name") String name, @Param("tel") String tel);


}
