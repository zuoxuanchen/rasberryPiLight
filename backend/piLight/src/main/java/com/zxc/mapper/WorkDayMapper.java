package com.zxc.mapper;

import com.zxc.model.WorkDay;
import com.zxc.model.WorkDayExample;

import java.util.Date;
import java.util.List;

public interface WorkDayMapper {
    int countByExample(WorkDayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkDay record);

    int insertSelective(WorkDay record);

    List<WorkDay> selectByExample(WorkDayExample example);

    WorkDay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WorkDay record);

    int updateByPrimaryKey(WorkDay record);

	/**
	 * 查询属于date范围的记录
	 * @param date
	 * @return
	 */
	List<WorkDay> selectRange(Date date);
}