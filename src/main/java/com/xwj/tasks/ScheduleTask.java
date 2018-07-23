package com.xwj.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
	
//	@Scheduled(fixedRate = 1000)
	@Scheduled(cron = "0 23-25 18 * * ?")
	public void testSchedule(){
		System.out.println("定时任务：" + System.currentTimeMillis());
	}

}
