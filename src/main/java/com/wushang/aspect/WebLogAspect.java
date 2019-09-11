package com.wushang.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName WebLogAspect
 * @Description TODO
 * @Author wushang
 * @Date 2019-09-11 11:36
 */
@Aspect
@Component
public class WebLogAspect {

	private Logger logger = Logger.getLogger(getClass());

	@Pointcut("execution(public * com.wushang.web.controller..*.*(..))")
	public void webLog() {

	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		//接收到请求,记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		//记录下请求内容
		logger.info("----------------request----------------");
		logger.info("url:" + request.getRequestURL().toString());
		logger.info("HTTP_METHOD:" + request.getMethod());
		logger.info("IP:" + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = enu.nextElement();
			logger.info("name:" + name + "value:" + request.getParameter(name));
		}

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		logger.info("----------------response---------------");
		//处理完请求,返回内容
		logger.info("RESPONSE:" + ret);
	}
}
