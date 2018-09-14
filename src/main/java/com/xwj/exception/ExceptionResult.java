package com.xwj.exception;

import lombok.Getter;

/**
 * 异常处理类
 * 
 * @author xuwenjin 2018年9月13日
 */
@Getter
public class ExceptionResult {

	/**
	 * 异常信息
	 */
	private String message;

	/**
	 * 异常详情
	 */
	private Object detail;

	/**
	 * 失败
	 */
	public static ExceptionResult error(String message) {
		return new ExceptionResult(message);
	}

	/**
	 * 失败
	 */
	public static ExceptionResult error(String message, Object detail) {
		return new ExceptionResult(message, detail);
	}

	private ExceptionResult(String message) {
		this.message = message;
	}

	private ExceptionResult(String message, Object detail) {
		this.message = message;
		this.detail = detail;
	}

}
