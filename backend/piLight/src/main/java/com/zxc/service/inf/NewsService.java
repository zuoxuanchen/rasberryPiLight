package com.zxc.service.inf;


import java.util.List;

import com.zxc.model.News;


public interface NewsService {

	/**
	 * 查询今天的新闻
	 * @return
	 */
	List<News> todayNews();

	/**
	 * 爬取今天的新闻放到数据库中
	 * @return
	 */
	Boolean insertNews();
}
