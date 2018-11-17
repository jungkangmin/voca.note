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
		extract();
	}

	public static void extract() {
		String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
		Document doc = Jsoup.parse(html);
		Element link = doc.select("a").first();
		
		String text = doc.body().text(); // "An example link"
		String linkHref = link.attr("href"); // "http://example.com/"
		String linkText = link.text();  // "example"
		
		String linkOuterH = link.outerHtml(); // "<a href="http://example.com"><b>example</b></a>"
		String linkInnerH = link.html(); // "<b>example</b>
		
		System.out.println("TEXT: " + text);
		System.out.println("HREF LINK : " + linkHref);
		System.out.println("TEXT LINK: " + linkText);
		System.out.println("OUTER LINK: " + linkOuterH);
		System.out.println("INNER LINK: " + linkInnerH);
	}
	public static void selector() {
		// Use selector-syntax to find elements
		File input = new File("/home/kangmin/play/Project/vocabulary_note/segregate_daum.html");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements links = doc.select("a[href]"); // a with href
		Elements pngs = doc.select("img[src$=.png]"); // img with src ending .png
		
		Element masthead = doc.select("div.layer_body").first(); // div with class=masthead
		
		Elements resultLinks = doc.select("h3.r > a"); // direct a after h3
		
		System.out.println("LINKS <a> tag with href: " + links.size());
		System.out.println("IMAGE <img> tag with png file: " + pngs.size());
		System.out.println("RESULT LINKS <h3> tags with <a> tag: " + resultLinks.size());
		System.out.println("FIRST ELEMENT <div> tag with class \"layer_body\": " + masthead);
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
