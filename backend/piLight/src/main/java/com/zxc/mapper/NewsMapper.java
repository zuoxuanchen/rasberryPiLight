package com.zxc.mapper;

import com.zxc.model.News;
import com.zxc.model.NewsExample;
import java.util.List;

public interface NewsMapper {
    int countByExample(NewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    int insertSelective(News record);

    List<News> selectByExample(NewsExample example);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

	/**
	 * @return
	 */
	List<News> selectTodayNews();
}