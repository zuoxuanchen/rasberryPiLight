package com.zxc.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.zxc.service.inf.PinService;
import com.zxc.util.CommonUtils;

@Service("pinService")
public class PinServiceImpl implements PinService{
	
	private static Pin[] pinList = null; 
	
	private static GpioPinDigitalOutput[] outputList = null; 

	@Override
	public Pin getPinByNum(int num) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		return pinList[num];
	}

	@Override
	public GpioPinDigitalOutput provisionGpio(int num, String string, PinState state) {
		if (num < 0 || num > 31) {
			return null;
		}
		if (pinList == null) {
			pinList = RaspiPin.allPins(CommonUtils.boardType);
		}
		if (outputList == null) {
			outputList = new GpioPinDigitalOutput[pinList.length];
		}
		if (outputList[num] == null) {
			GpioController gpio = GpioFactory.getInstance();
			outputList[num] = gpio.provisionDigitalOutputPin(getPinByNum(num), "PIN"+num, state);
		}
		return outputList[num];
	}
	
	

}
