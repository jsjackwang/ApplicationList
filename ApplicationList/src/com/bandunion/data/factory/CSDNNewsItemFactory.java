package com.bandunion.data.factory;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bandunion.util.HttpUtil;
import com.bandunion.util.Util;
import com.bandunion.vo.CSDNNewsItem;

public class CSDNNewsItemFactory {
	private static String TAG = "CSDNNewsItemFactory";
	// type
	public static final int NEW_TYPE_YEJIE = 0;
	public static final int NEW_TYPE_YIDONG = 1;
	public static final int NEW_TYPE_YANFA = 2;
	public static final int NEW_TYPE_CHENGXUYUAN = 3;
	public static final int NEW_TYPE_YUNJISUAN = 4;
	
	// type url
	public static final String NEWS_LIST_URL_YEJIE = "http://news.csdn.net/news/";
	public static final String NEWS_LIST_URL_YIDONG = "http://mobile.csdn.net/mobile/";
	public static final String NEWS_LIST_URL_YANFA = "http://sd.csdn.net/sd/";
	public static final String NEWS_LIST_URL_CHENGXUYUAN = "http://programmer.csdn.net/programmer/";
	public static final String NEWS_LIST_URL_YUNJISUAN = "http://cloud.csdn.net/cloud/";
	
	private static String getNewsItemUrl(int newType, int currentPage){
		String dataUrl = null;
		currentPage = currentPage > 0 ? currentPage : 1;
		switch (newType) {
			case NEW_TYPE_YEJIE:
				dataUrl = NEWS_LIST_URL_YEJIE;
				break;	
			case NEW_TYPE_YIDONG:
				dataUrl = NEWS_LIST_URL_YIDONG;
				break;	
			case NEW_TYPE_YANFA:
				dataUrl = NEWS_LIST_URL_YANFA;
				break;	
			case NEW_TYPE_CHENGXUYUAN:
				dataUrl = NEWS_LIST_URL_CHENGXUYUAN;				
				break;	
			case NEW_TYPE_YUNJISUAN:
				dataUrl = NEWS_LIST_URL_YUNJISUAN;				
				break;
		}
		dataUrl = dataUrl + currentPage;
		return dataUrl;
	}
	
	/**
	 * 其实就是利用Jsoup解析网站（说白了就是HTMLParser）
	 * @param newType
	 * @param currentPage
	 * @return
	 */
	public static List<CSDNNewsItem> getNewsItemByType(int newType, int currentPage){
		List<CSDNNewsItem> list = null;
		String dataUrl = getNewsItemUrl(newType, currentPage);
		if(dataUrl == null){
			Util.log(TAG, "newType = " + newType + " currentPage = " + currentPage + " get dataUrl is null");
			return list;
		}
		String htmlData = HttpUtil.doGet(dataUrl);
		if(htmlData == null){
			Util.showToastShort("your network has problem");
			return list;
		}
		list = new ArrayList<CSDNNewsItem>();
		CSDNNewsItem item = null;
		Document document = Jsoup.parse(htmlData);
		Elements units = document.getElementsByClass("unit");
		for (int i =0; i< units.size(); i++) {
			item = new CSDNNewsItem();
			
			Element unit_ele = units.get(i);
			Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
			Element h1_a_ele = h1_ele.child(0);
			String title = h1_a_ele.text();
			String url = h1_a_ele.attr("href");
			item.setUrl(url);
			item.setTitle(title);

			Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
			Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
			String date = ago_ele.text();
			item.setDate(date);

			Element dl_ele = unit_ele.getElementsByTag("dl").get(0);
			Element dt_ele = dl_ele.child(0);
			try{
				Element img_ele = dt_ele.child(0);
				String imgUrl = img_ele.child(0).attr("src");
				item.setImgUrl(imgUrl);
			} catch (IndexOutOfBoundsException e){
				Util.log(TAG, "paser imageUrl exception -->" + e.getMessage());
			}
			
			Element content_ele = dl_ele.child(1);
			String content = content_ele.text();
			item.setContent(content);
			list.add(item);
		}
		return list;
	}
}
