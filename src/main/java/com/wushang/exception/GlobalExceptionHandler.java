package com.wushang.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 用于捕获全局异常
 * @Author wushang
 * @Date 2019-09-10 14:19
 */

@ControllerAdvice//控制器切面
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)//捕获运行时异常
	@ResponseBody
	public Map<String, Object> exceptionHandler() {
		Map<String, Object> map = new HashMap<>();
		map.put("errorCode", "101");
		map.put("errorMsg", "错误");
		return map;
	}

}
