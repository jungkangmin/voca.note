package kr.pe.kangmin.voca.note;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String html = "<html><head><title>First parse</title></head>"
        		+ "<body><p>Parsed HTML into a doc.</body></html>";
        
        Document doc = Jsoup.parse(html);
        System.out.println("PARSED? " + doc);
    }
}
