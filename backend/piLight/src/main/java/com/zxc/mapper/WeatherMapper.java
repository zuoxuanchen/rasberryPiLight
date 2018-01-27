package com.zxc.mapper;

import com.zxc.model.Weather;
import com.zxc.model.WeatherExample;
import java.util.List;

public interface WeatherMapper {
    int countByExample(WeatherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Weather record);

    int insertSelective(Weather record);

    List<Weather> selectByExample(WeatherExample example);

    Weather selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Weather record);

    int updateByPrimaryKey(Weather record);
    
    /**
     * 查询今天的天气
     * @return
     */
    Weather selectTodayWeather();
}