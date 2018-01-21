package com.zxc.service.inf;

import com.zxc.model.Program;

public interface ProgramTableService {

	void insertProgram(Program program);

	boolean exist(Program program);
}
