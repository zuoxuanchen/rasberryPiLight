package com.zxc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxc.mapper.NickNameMapper;
import com.zxc.model.NickName;
import com.zxc.service.inf.NickNameService;

@Service("nickNameService")
public class NickNameServiceImpl implements NickNameService{

	@Autowired
	private NickNameMapper nickNameMapper;

	@Override
	public String getRandomNickName() {
		NickName name = nickNameMapper.selectRandomName();
		return name.getNickName();
	}
	


}
