package com.xwj.exception;

/**
 * 服务器内部异常，用于程序识别，不能显示给用户看
 */
public class InnerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public InnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public InnerException(Throwable cause) {
        super(cause);	
    }

    public InnerException(String message) {
        super(message);
    }
}
