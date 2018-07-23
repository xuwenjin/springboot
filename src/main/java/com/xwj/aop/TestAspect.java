package com.xwj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

	/**
	 * 通配符：
	 * *  匹配任意数量的字符
	 * +  匹配指定类及其子类
	 * .. 一般用于匹配任意数的子包或参数
	 */
	@Pointcut("execution(public * com.xwj.service..*.insert*(..))")
	private void recordLog() {

	}

	/**
	 * 前置方法,在目标方法执行前执行
	 * 
	 * @param joinPoint
	 */
	@Before("recordLog()")
	public void before(JoinPoint joinPoint) {
		logger.info("保存前方法：beforeSave");
	}

	/**
	 * 后置方法,在目标方法执行后执行
	 * 
	 * @param joinPoint
	 */
	@After("recordLog()")
	public void after(JoinPoint joinPoint) {
		logger.info("保存后方法：afterSave()");
	}

	@Around("recordLog()")
	public Object around(ProceedingJoinPoint joinPoint) {
		Object obj = null;
		try {
			logger.info("around前");
			joinPoint.proceed();
			logger.info("around后");
		} catch (Throwable e) {
			logger.info("aop异常");
		}
		return obj;
	}

	@AfterReturning(returning = "retObj", pointcut = "recordLog()")
	public void doAfterReturning(Object retObj) throws Throwable {
		// 处理完请求，返回内容
		logger.info("返回值 : " + retObj);
	}

}
