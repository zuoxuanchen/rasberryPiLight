package com.zxc.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxc.mapper.HintsMapper;
import com.zxc.model.Hints;
import com.zxc.service.inf.HintsService;

@Service("hintsService")
public class HintsServiceImpl implements HintsService{

	@Autowired
	private HintsMapper hintsMapper;

	@SuppressWarnings("deprecation")
	@Override
	public List<Hints> findAllHints(String oldDate) {
		Hints hint = new Hints();
		Date date = new Date();
		hint.setYear(date.getYear());
		hint.setMonth(date.getMonth()+1);
		hint.setDay(date.getDate());
		hint.setOldYear(Integer.parseInt(oldDate.substring(0,4)));
		hint.setOldMonth(Integer.parseInt(oldDate.substring(4,6)));
		hint.setOldDay(Integer.parseInt(oldDate.substring(6)));
		return hintsMapper.findAllHints(hint);
	}
	


}
