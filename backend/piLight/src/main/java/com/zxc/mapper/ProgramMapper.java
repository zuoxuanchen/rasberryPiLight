package com.zxc.mapper;

import com.zxc.model.Program;
import com.zxc.model.ProgramExample;
import java.util.List;

public interface ProgramMapper {
    int countByExample(ProgramExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Program record);

    int insertSelective(Program record);

    List<Program> selectByExample(ProgramExample example);

    Program selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Program record);

    int updateByPrimaryKey(Program record);
}