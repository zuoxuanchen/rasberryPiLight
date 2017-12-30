package com.zxc.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zxc.service.inf.GpioService;
import com.zxc.view.PortVo;

@SpringBootConfiguration
@RestController
@SpringBootApplication
@ComponentScan(basePackages = { "com.zxc"})
public class PiLight {
	
	@Autowired
	private GpioService gpioService;

	private static Logger logger = Logger.getLogger(PiLight.class);  
	
    @RequestMapping("/")
    public String greeting() {
        return "Hello World!";
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