package com.zfw.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 定向爬虫，用于爬特定网页数据
 * @author zhang
 *
 */
public class CrawlerTest {
	public static void main(String[] args) throws MalformedURLException, IOException {
		Document a = Jsoup.parse(new URL("http://fanyi.baidu.com/v2transapi?from=zh&to=en&query=微软"),2000);
		System.out.println(a);
	}
}
