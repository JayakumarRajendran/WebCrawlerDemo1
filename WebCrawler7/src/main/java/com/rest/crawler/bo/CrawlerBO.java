package com.rest.crawler.bo;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* using this BO class we can read the links from given uri
 * using the JSOup tool*/ 
public class CrawlerBO {

	public ArrayList<String> CrowlerText(String url) {

		ArrayList<String> linkslist = new ArrayList<>();
		System.out.println("Welcome to JSOUP from BO class");
		// img
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// to get anchor tag links
		Elements  links = doc.select("a[href]");
		System.out.println("links.size(): "+links.size());
		for(Element link: links){
			String ancharlink = link.attr("abs:href");
			linkslist.add(ancharlink);
			/*		if(1==1){
				// to make recursive call to the same method to get all links in the same domain
					CrowlerText(ancharlink);
					}
			*/}
				
		return linkslist;
	}

	public ArrayList<String> CrowlerXML(String url) {
		return null;
	}

	public ArrayList<String> CrowlerJSON(String url) {
		return null;
	}

}
