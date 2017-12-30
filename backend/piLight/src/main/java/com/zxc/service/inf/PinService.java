package com.zxc.service.inf;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;

public interface PinService {

	/**
	 * 获得pin
	 * @param num
	 * @return
	 */
	Pin getPinByNum(int num);
	
	/**
	 * 定义为GPIO口（数字参数）
	 * @param num
	 * @param name
	 * @param state
	 * @return
	 */
	GpioPinDigitalOutput provisionGpio(int num, String name, PinState state);
}
