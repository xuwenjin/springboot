package com.xwj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xwj.service.AsyncService;

/**
 * 异步调用
 * 
 * @author xwj
 */
@RestController
@RequestMapping("async")
public class AsyncController {
	
	@Autowired
	private AsyncService asyncService;

	@RequestMapping("/test")
	public String async() {
		System.out.println("####AsyncController####   1");
		asyncService.doAsync1();
//		asyncService.doAsync2();
		System.out.println("####AsyncController####   2");
		return "success";
	}
	
}
