package kr.pe.kangmin.voca.note;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String [] args) {
		parseDom();
	}

	public static void parseDom() {
		// Use DOM methods to navigate a document
		File input = new File("/home/kangmin/play/Project/vocabulary_note/segregate_daum.html");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8", "http://dic.daum.net");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element content = doc.getElementById("kakaoGnb");
		Elements links = content.getElementsByTag("a");
		for (Element link: links) {
			String linkHref = link.attr("href");
			String linkText = link.text();
			System.out.println("LINK HREF: " + linkHref);
			System.out.println("LINK TEXT: " + linkText);
		}
	}
	public static void fetchDetail() {
		try {
			Document doc = Jsoup.connect("http://example.com")
					.data("query", "java")
					.userAgent("Mozilla")
					.cookie("auth", "token")
					.timeout(3000)
					.post();
			System.out.println("WHAT IS THE DOCUMENT?: " + doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void fetchFromURL() {
		Document doc = null;
		try {
			doc = Jsoup.connect("http://dic.daum.net").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("PAGE TITLE: " + doc.title());
	}
	public static void parseBody() {
		String html = "<div><p>Lorem ipsum.</p>";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body();
		System.out.println("BODY PART: " + body);
	}
	
}
