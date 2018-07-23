//package com.xwj.aop;
//
//import java.lang.reflect.Modifier;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class WebLogAspect {
//
//	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
//
//	@Pointcut("execution(public * com.xwj.service..*.insert*(..))")
//	private void beforeSave() {
//	}
//
//	@Pointcut("execution(public * com.xwj.service..*.insert*(..))")
//	private void afterSave() {
//	}
//
//	@Pointcut("execution(public * com.xwj.service..*.insert*(..))")
//	private void aroundSave() {
//	}
//
//	@Pointcut("execution(public * com.xwj.service..*.insert*(..))")
//	private void afterReturn() {
//	}
//
//	/**
//	 * 前置方法,在目标方法执行前执行
//	 * 
//	 * @param joinPoint
//	 */
//	@Before("beforeSave()")
//	public void before(JoinPoint joinPoint) {
//		logger.info("目标方法名为:" + joinPoint.getSignature().getName());
//		logger.info("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//		logger.info("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
//		logger.info("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
//
//		// 获取传入目标方法的参数
//		Object[] args = joinPoint.getArgs();
//		for (int i = 0; i < args.length; i++) {
//			logger.info("第" + (i + 1) + "个参数为:" + args[i]);
//		}
//	}
//
//	/**
//	 * 后置方法,在目标方法执行后执行
//	 * 
//	 * @param joinPoint
//	 */
//	@After("afterSave()")
//	public void after(JoinPoint joinPoint) {
//		logger.info("后置方法：afterSave()");
//	}
//
//	/**
//	 * 后置方法,在目标方法执行后执行
//	 * 
//	 * @param joinPoint
//	 */
//	@Around("aroundSave()")
//	public Object around(ProceedingJoinPoint joinPoint) {
//		Object obj = null;
//		try {
//			obj = joinPoint.proceed();
//			logger.info(obj.toString());
//		} catch (Throwable e) {
//			logger.info("aop异常");
//		}
//		return obj;
//	}
//
//	@AfterReturning(returning = "retObj", pointcut = "afterReturn()")
//	public void doAfterReturning(Object retObj) throws Throwable {
//		// 处理完请求，返回内容
//		logger.info("返回值 : " + retObj);
//	}
//
//}
