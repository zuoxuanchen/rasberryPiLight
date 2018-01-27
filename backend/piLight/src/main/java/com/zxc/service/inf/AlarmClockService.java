package com.zxc.service.inf;




public interface AlarmClockService {

	
	/**
	 * 拼接闹钟所需要的所有内容
	 * @return
	 */
	String findAllInfo();
	
	/**
	 * 发声
	 * @param text
	 */
	void playSound(String text);

	/**
	 * 播放文件
	 * @param fileName
	 */
	void play(String fileName);
}
