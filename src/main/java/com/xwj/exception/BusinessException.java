package com.xwj.exception;

/**
 * 业务异常，可以直接抛给终端用户
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}
}
