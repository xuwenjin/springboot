package com.xwj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(basePackages = { "com.xwj.controller", "com.xwj.service", "com.xwj.tasks" })
@MapperScan(basePackages = "com.xwj.mapper")
//@EnableCaching //开启缓存
//@EnableScheduling //开启定时任务
@EnableAsync // 开启异步调用
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
