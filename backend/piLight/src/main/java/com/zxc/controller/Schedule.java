package com.zxc.controller;


import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.zxc.service.inf.AlarmClockService;
import com.zxc.service.inf.SpiderService;
import com.zxc.service.inf.WorkDayService;

@Configuration
@EnableScheduling
public class Schedule {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AlarmClockService alarmClockService;
	
	@Autowired
	private WorkDayService workDayService;
	
	@Autowired
	private SpiderService spiderService;
	

    @Scheduled(cron = "0 45 7 * * ?") // 起床时间
    public void alarm() {
    	if (!workDayService.isWorkDay(new Date())) {
			return;
		}
    	logger.info("起床任务开始");
    	String sound = alarmClockService.findAllInfo();
    	alarmClockService.playSound(sound);
        logger.info("起床任务结束");
    }
    
    @Scheduled(cron = "0 20 11 * * ?") // 休假起床时间
    public void noalarm() {
    	if (workDayService.isWorkDay(new Date())) {
			return;
		}
    	logger.info("休假起床任务开始");
    	String sound = alarmClockService.findAllInfo();
    	alarmClockService.playSound(sound);
        logger.info("休假起床任务结束");
    }
    
    @Scheduled(cron = "0 0/5 * * * ?") // 下载韩综艺
    public void spider() {
    	logger.info("下载韩综艺任务开始");
    	String url = "http://www.hanfan.cc/tag/runningman/";
    	int cnt = spiderService.getHanfan(url);
    	if (cnt>0) {
    		alarmClockService.playSound("您有"+cnt+"集跑男更新了哦~~");
		}
    	url = "http://www.hanfan.cc/tag/challenge/";
    	cnt = spiderService.getHanfan(url);
    	if (cnt>0) {
    		alarmClockService.playSound("您有"+cnt+"集无限挑战更新了哦~~");
		}
    	logger.info("下载韩综艺任务结束");
    }
}
