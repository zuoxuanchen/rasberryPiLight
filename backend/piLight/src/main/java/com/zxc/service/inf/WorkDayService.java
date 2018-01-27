package com.zxc.service.inf;

import java.util.Date;

public interface WorkDayService {
	/**
	 * 判断今天是不是工作日
	 * @param date
	 * @return
	 */
	boolean isWorkDay(Date date);
}
