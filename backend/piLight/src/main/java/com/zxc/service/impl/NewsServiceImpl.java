package com.zxc.service.impl;

import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zxc.mapper.NewsMapper;
import com.zxc.model.News;
import com.zxc.service.inf.NewsService;
import com.zxc.service.inf.SpiderService;

@Service("newsService")
public class NewsServiceImpl implements NewsService{

	@Autowired
	private NewsMapper newsMapper;

	@Autowired
	private SpiderService spiderService;
	
	private static String url = "http://news.sina.com.cn/";
	@Override
	public Boolean insertNews() {
		//FIXME 还是不行
		Document doc = spiderService.getDoc(url);
		Elements elements = doc.getElementsByAttributeValue("class", "news-area");
		System.out.println(elements.size());
		for (Element element :elements) {
			String clazz = element.attr("class");
			String sudaclick = element.attr("data-sudaclick");
			System.out.println(clazz+" "+sudaclick);
			if (!StringUtils.isEmpty(clazz) && clazz.equals("news-area")
				&& !StringUtils.isEmpty(sudaclick) && sudaclick.equals("news_1")	) {
				Elements temps = element.getElementsByTag("a");
				for (Element temp:temps) {
					System.out.println();
					News aNews = new News();
					aNews.setDate(new Date());
					aNews.setTitle(temp.text());
					aNews.setContent(temp.attr("href"));
					newsMapper.insert(aNews);
				}
				break;
			}
		}
		
		return true;
	}

	@Override
	public List<News> todayNews() {
		return newsMapper.selectTodayNews();
	}
	


}
