package com.zxc.service.impl;


import java.util.Date;


import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.zxc.mapper.WeatherMapper;
import com.zxc.model.Weather;
import com.zxc.service.inf.SpiderService;
import com.zxc.service.inf.WeatherService;


@Service("weatherService")
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	private WeatherMapper weatherMapper;
	
	@Autowired
	private SpiderService spiderService;
	
	private static String tempUrl = "https://tianqi.moji.com/weather/china/sichuan/chengdu";
	private static String pmUrl = "https://tianqi.moji.com/aqi/china/sichuan/chengdu";

	@Override
	public boolean insertTodayWeather() {
		Weather weather = new Weather();
		weather.setDate(new Date());
		Document doc = spiderService.getDoc(tempUrl);
		Elements elements = doc.getElementsByTag("div");
		for (Element element :elements) {
			String clazz = element.attr("class");
			if (!StringUtils.isEmpty(clazz) && clazz.equals("wea_weather clearfix")) {
				String temp = element.getElementsByTag("em").first().text();
				String wea = element.getElementsByTag("b").first().text();
				weather.setWeather(wea);
				weather.setTemp(Integer.parseInt(temp));
			}
			if (!StringUtils.isEmpty(clazz) && clazz.equals("wea_tips clearfix")) {
				String hint = element.getElementsByTag("em").first().text();
				weather.setComment(hint);
				break;
			}
		}
		
		//获取PM值
		doc = spiderService.getDoc(pmUrl);
		elements = doc.getElementsByTag("em");
		for (Element element :elements) {
			String id = element.attr("id");		
			String value = element.text();

			if (!StringUtils.isEmpty(id) &&  id.equals("aqi_value")) {
				weather.setPm(Integer.parseInt(value));
			}
		}
		weatherMapper.insert(weather);
		return true;
	}

	@Override
	public Weather todayWeather() {
		return weatherMapper.selectTodayWeather();
	}
	


}
