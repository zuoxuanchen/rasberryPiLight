package com.zxc.mapper;

import com.zxc.model.Hints;
import com.zxc.model.HintsExample;
import java.util.List;

public interface HintsMapper {
    int countByExample(HintsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hints record);

    int insertSelective(Hints record);

    List<Hints> selectByExample(HintsExample example);

    Hints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hints record);

    int updateByPrimaryKey(Hints record);

	/**
	 * @param hint
	 * @return
	 */
	List<Hints> findAllHints(Hints hint);
}