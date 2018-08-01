//package MuTesting;

//import test.java.*;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * before using the parseHTML
 * install and configure Jsoup
 * https://www.javatpoint.com/install-jsoup
 * @author wangsong
 *
 */
public class ParseHTML {
	//-DwithHistory
	public static double getMutationScore() {
		launchPitest.launch();
		//SampleTest.x = x;
	Document htmlFile = null;
	try { 
		htmlFile = Jsoup.parse(new File("C:\\Users\\wangsong\\workspace\\mutation-testing\\target\\pit-reports\\index.html"), "UTF-8"); 
	} catch (IOException e) { 
		// TODO Auto-generated catch block 
		e.printStackTrace();  // right title = htmlFile.title();
	}
	//File input = new File("C:\\Users\\wangsong\\workspace\\mutation-testing\\target\\pit-reports\\index.html");
	//Document doc = Jsoup.parse(input, null);
	//htmlFile = Jsoup.parse(input, null);
	//String title = htmlFile.title();
	Elements div = htmlFile.getElementsByClass("coverage_legend"); 
	//String cssClass = div.className(); // getting class form HTML element 
	//System.out.println("Jsoup can also parse HTML file directly"); 
	
	// 1 for mutationCoverage
	// 0 for lineCoverage
	String secondElement = div.get(1) + "";
	//System.out.println(secondElement); 
	//System.out.println("class of div tag : " + cssClass);
	// split the string
	String[] lines = secondElement.split("\\n");
	//System.out.println(lines[1]);
	String[] ratio = lines[1].split("/");
	//System.out.println(ratio[0].length());
	// convert string to number
	//https://www.mkyong.com/java/java-convert-string-to-int/
	int num = Integer.parseInt(ratio[0].substring(1));
	int denum = Integer.parseInt(ratio[1]);
	//mutationCoverage = num * 1.0 / denum;
	return num * 1.0 / denum;
	}
}
