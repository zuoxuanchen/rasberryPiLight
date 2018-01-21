package com.zxc.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxc.mapper.ProgramMapper;
import com.zxc.model.Program;
import com.zxc.model.ProgramExample;
import com.zxc.service.inf.ProgramTableService;

@Service("programTableServiceImpl")
public class ProgramTableServiceImpl implements ProgramTableService{

	@Autowired
	private ProgramMapper programMapper;
	
	@Override
	public void insertProgram(Program program) {
		program.setCrtTime(new Date());
		programMapper.insert(program);
	}
	
	@Override
	public boolean exist(Program program) {
		ProgramExample pExample = new ProgramExample();
		pExample.createCriteria().andPlayTimeEqualTo(program.getPlayTime())
		.andENumEqualTo(program.geteNum());
		int answer = programMapper.countByExample(pExample);
		return answer > 0;
	}

}
