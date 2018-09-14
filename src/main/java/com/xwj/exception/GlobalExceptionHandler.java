package com.xwj.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常捕获处理
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	private static final String ERR_INNER_MSG = "内部异常";

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionResult> exceptionHandler(HttpServletRequest request, Exception e) {
		log.error("操作失败：{}", e);
		HttpStatus status = this.getStatus(request);
		String exceptionName = this.getExceptionName(e);
		if (e instanceof BusinessException) { // 业务异常
			ExceptionResult result = ExceptionResult.error(e.getMessage(), exceptionName);
			return new ResponseEntity<>(result, status);
		} else if (e instanceof InnerException || e instanceof NullPointerException) { // 内部异常
			ExceptionResult result = ExceptionResult.error(ERR_INNER_MSG, exceptionName);
			return new ResponseEntity<>(result, status);
		} else { // 其它异常
			ExceptionResult result = ExceptionResult.error(e.getMessage(), exceptionName);
			return new ResponseEntity<>(result, status);
		}
	}

	/**
	 * 获取错误编码
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	/**
	 * 获取异常名称
	 */
	private String getExceptionName(Exception e) {
		return e.getClass().getName();
	}

}
