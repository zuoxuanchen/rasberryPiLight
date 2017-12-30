package com.zxc.util;

import com.pi4j.system.SystemInfo;
import com.pi4j.system.SystemInfo.BoardType;

public class CommonUtils {
	
	/**
	 * 树莓派板子类型设为3B
	 */
	public static final BoardType boardType = SystemInfo.BoardType.RaspberryPi_3B;
}
