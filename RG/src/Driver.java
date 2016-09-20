import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException {

		/*
		 * String[] queries = { "Automotive+Technician", "Helpdesk+Technician",
		 * "Security+Analyst", "Waiter", "Waitress", "Hostess", "Cameraman",
		 * "Java+Developer", "Backend+Developer", "Full+Stack+Developer",
		 * "Actuary", "Business+Analyst", "Lawyer", "Mechanical+Engineer",
		 * "Software+Engineer", "Python+Developer", "Fabric+Stylist", "Model",
		 * "Contractor", "Plumber", "Electrician", "Painter" };
		 * 
		 * for (String query : queries) { String start =
		 * "http://www.indeed.com/resumes?q=" + query + "&l=New+York%2C+NY";
		 * Crawler c = new Crawler(start,
		 * "C:\\Users\\ckobel\\workspace\\RG\\multiple_jobs_raw.txt");
		 * c.Crawl(); Thread.sleep(500); }
		 */
		/*
		 * Here are some spiders
		 * 
		 * Crawler[] crawlers = new Crawler[5]; crawlers[0] = new
		 * Crawler("http://www.indeed.com/resumes?q=Actuary&l=Stamford%2C+CT",
		 * "actuary_raw.txt"); crawlers[1] = new
		 * Crawler("http://www.indeed.com/resumes?q=Analyst&l=Stamford%2C+CT",
		 * "analyst_raw.txt"); crawlers[2] = new
		 * Crawler("http://www.indeed.com/resumes?q=Security&l=Stamford%2C+CT",
		 * "security_raw.txt"); crawlers[3] = new
		 * Crawler("http://www.indeed.com/resumes?q=Teacher&l=Stamford%2C+CT",
		 * "teacher_raw.txt"); crawlers[4] = new
		 * Crawler("http://www.indeed.com/resumes?q=Actor&l=Stamford%2C+CT",
		 * "actor_raw.txt");
		 * 
		 * for(Crawler crawler : crawlers){ crawler.Crawl(); }
		 * 
		 */

		
		String file = "C:\\users\\ckobel\\workspace\\RG\\RAW_CVE_TEXT.txt";
		FileReader fr = new FileReader(file);
		Scanner scanner = new Scanner(fr);
		String word;
		int count;
		HashMap<String, Integer> wordCountData = new HashMap<String, Integer>();

		while (scanner.hasNext()) {
			word = scanner.next();
			if (word.length() < 3) {
				continue;
			}
			word = word.toLowerCase();
			word = word.replaceAll("[^a-zA-Z0-9\\s\\t]", "");

			if (wordCountData.containsKey(word)) {
				count = wordCountData.get(word) + 1;
			} else {
				count = 1;
			}

			wordCountData.put(word, count);
		}

		HashMap<String, Integer> sortedHashMap = sortByValues(wordCountData);

		int counter = 0;
		System.out.println("-----------------------------------------------");
		System.out.println("    Occurrences    Word");

		for (String currWord : sortedHashMap.keySet()) {
			Thread.sleep(50);
			System.out.printf("%15d    %s\n", wordCountData.get(currWord), currWord);
		}

		System.out.println("-----------------------------------------------");

	}

	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator() {
			public int compare(Object o2, Object o1) {
				return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		// Here I am copying the sorted list in HashMap
		// using LinkedHashMap to preserve the insertion order
		HashMap sortedHashMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

}
