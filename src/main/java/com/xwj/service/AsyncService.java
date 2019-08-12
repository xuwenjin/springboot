package com.xwj.service;

import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public void doAsync1() {
		System.out.println("####doAsync1####   3");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("####doAsync1####   4");
	}

	@Async
	public void doAsync2() {
		System.out.println("####doAsync2####   5");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		doAsync3();
		System.out.println("####doAsync2####   6");
	}

	/**
	 * 在同一个类中，一个方法调用另外一个有注解（比如@Async，@Transational）的方法，注解是不会生效的
	 */
	@Async
	public void doAsync3() {
		System.out.println("####doAsync3####   7");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("####doAsync3####   8");
	}

}
