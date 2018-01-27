package com.zxc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxc.mapper.WorkDayMapper;
import com.zxc.model.WorkDay;
import com.zxc.service.inf.WorkDayService;

@Service("workDayService")
public class WorkDayServiceImpl implements WorkDayService{

	@Autowired
	private WorkDayMapper workDayMapper;

	@SuppressWarnings("deprecation")
	@Override
	public boolean isWorkDay(Date date) {
		List<WorkDay> days = workDayMapper.selectRange(date);
		if (days ==null || days.size() == 0) {
			//表中无今日数据 根据星期判断
			if(date.getDay()%6==0){
				return false;
			}
			return true;
		}

		for (WorkDay day: days) {
			if (day.getIsWorkDay() == 1) {
				return true;
			}
		}
		return false;
	}
	


}
