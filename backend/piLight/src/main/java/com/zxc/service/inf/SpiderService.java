package com.zxc.service.inf;

import org.jsoup.nodes.Document;

public interface SpiderService {
	int getHanfan(String url);
	
	Document getDoc(String url);
}
