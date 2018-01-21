package com.zxc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zxc.model.Program;
import com.zxc.service.inf.ProgramTableService;
import com.zxc.service.inf.SpiderService;

@Service("spiderService")
public class SpiderServiceImpl implements SpiderService{

	@Autowired
	private ProgramTableService programTableService;
	
	@Override
	public void getHanfan(String url) {
		Document doc = getDoc(url);
		Elements elements = doc.getElementsByTag("a");
		for (Element element :elements) {
			//得到<a>...</a>里面的网址
			String linkHref = element.attr("href");
			//得到<a>...</a>里面的汉字
			String linkText = element.text();
			Program program = new Program();
			if (!StringUtils.isEmpty(linkText)) {
				String[] texts = linkText.split(" ");
				List<String> textsWithContent = new ArrayList<>();
				for (String text : texts) {
					if (!StringUtils.isEmpty(text)) {
						textsWithContent.add(text);
					}
				}
				if (textsWithContent.size()>4 && textsWithContent.get(3).toLowerCase().startsWith("e") ) {
					program.setPlayTime(textsWithContent.get(0));
					program.setName(textsWithContent.get(1)+" "+textsWithContent.get(2));
					program.seteNum(textsWithContent.get(3));
					program.setHanfanUrl(linkHref);
					if (programTableService.exist(program)) {
						return;
					}
					getBaiduUrlThenInsert(program);
				}
			}
		}
	}
	
	private void getBaiduUrlThenInsert(Program program) {	
		Document doc = getDoc(program.getHanfanUrl());
		Elements elements = doc.getElementsByTag("iframe");
		for (Element element :elements) {
			String playUrl = element.attr("src");
			program.setPlayUrl(playUrl);
			break;
		}
		elements = doc.getElementsByTag("a");
		for (Element element :elements) {
			String text = element.text().trim();
			if (!StringUtils.isEmpty(text) && text.equals("百度网盘")) {
				program.setBaiduUrl(element.attr("href"));
				String pwd = element.parent().text();
				int index = pwd.indexOf("密码");
				pwd = pwd.substring(index+3, index+7).trim();
				program.setBaiduPwd(pwd);
				break;
			}
		}
		programTableService.insertProgram(program);
	}

	private Document getDoc(String url){
		Document document = null;
		try {
			document = Jsoup.connect(url).header("Accept", "*/*")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.header("Referer", "https://www.baidu.com/")
					.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
					.timeout(5000)
					.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

}
