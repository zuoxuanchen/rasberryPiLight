package com.zxc.service.inf;


import com.zxc.model.Weather;

public interface WeatherService {
	boolean insertTodayWeather();
	
	Weather todayWeather();
}
