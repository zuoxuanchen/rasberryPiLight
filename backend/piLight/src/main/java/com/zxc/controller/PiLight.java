package com.zxc.controller;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxc.service.inf.AlarmClockService;
import com.zxc.service.inf.GpioService;
import com.zxc.service.inf.NewsService;
import com.zxc.service.inf.SpiderService;
import com.zxc.service.inf.WeatherService;
import com.zxc.view.PortVo;

@SpringBootConfiguration
@RestController
@SpringBootApplication
@ComponentScan(basePackages = { "com.zxc"})
@MapperScan("com.zxc.mapper")
public class PiLight {
	
	@Autowired
	private GpioService gpioService;
	
	@Autowired
	private SpiderService spiderService;


	
	@Autowired
	private AlarmClockService alarmClockService;
	
	private static Logger logger = Logger.getLogger(PiLight.class);  
	
    @PostConstruct
    void started() {
      TimeZone.setDefault(TimeZone.getTimeZone("GMT+8:00"));
    }
    
    @RequestMapping("/spider")
    public String spider() {
    	String url = "http://www.hanfan.cc/tag/runningman/";
    	spiderService.getHanfan(url);
    	url = "http://www.hanfan.cc/tag/challenge/";
    	spiderService.getHanfan(url);
        return "1";
    }
    
    @RequestMapping("/alarm")
    public String alarm() {
    	String sound = alarmClockService.findAllInfo();
    	alarmClockService.playSound(sound);
        return sound;
    }
    
    @RequestMapping("/")
    public String greeting(String text) {
    	if (StringUtils.isEmpty(text)) {
			text = "您的树莓派工作正常哦";
		}
    	alarmClockService.playSound(text);
        return text;
    }
    
    //http://localhost:8080/changePort?portNum=3&portStatus=1
    @RequestMapping("/changePort")
    public String changePort(PortVo portVo){
    	logger.debug(portVo);
    	if (portVo.getPortNum() == null) {
			return "端口号不能为空";
		}
    	int portNum = Integer.parseInt(portVo.getPortNum());
		if (portNum < 0 || portNum > 31) {
			return "端口号不正确";
		}
    	if (portVo.getPortStatus() == null) {
			return gpioService.reversePort(portNum)+"";
		}
    	if (portVo.getSecond() == null) {
			return gpioService.dealPort(portNum, portVo.getPortStatus().equals("1"))+"";
		}
    	else {
			return gpioService.dealPortWithTime(portNum, portVo.getPortStatus().equals("1"),Long.parseLong(portVo.getSecond()))+"";
		}
    }

    public static void main(String[] args) {
        SpringApplication.run(PiLight.class, args);
    }
}