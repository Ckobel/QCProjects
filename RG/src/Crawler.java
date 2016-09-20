import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	private String bURL;
	private PrintWriter writer;

	public Crawler(String beginURL, String outputFile) throws IOException {
		File file = new File(outputFile);
		file.createNewFile();
		writer = new PrintWriter(outputFile, "UTF-8");
		bURL = beginURL;
	}

	public String getbURL() {
		return bURL;
	}

	public void Crawl() {
		// div id="resume" class="hresume"
		// This will extract the text relevant to the resume for a page on
		// indeed.com
		// Document doc =
		// Jsoup.connect("http://www.indeed.com/r/11efe6e69d8c7913").get();

		// String UA = "Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; SLCC2;
		// .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media
		// Center PC 6.0; .NET4.0C; .NET4.0E; InfoPath.3; rv:11.0) like Gecko";
		try {
			Document docWithLinks = Jsoup.connect(getbURL()).get();
			Elements links = docWithLinks.select("a[href]");
			Document currentPage;

			for (Element link : links) {

				// selects the url from the current link object
				Connection con = Jsoup.connect(link.attr("abs:href").toString()).timeout(10000).ignoreHttpErrors(true);
				Connection.Response resp = con.execute();

				if (true) {// only parse the page if the
							// connection
					currentPage = con.get(); // response returns a valid status
												// code
					System.out.println("Parsing text from: " + link.attr("abs:href"));

					// selects the text within the div id = "resume"
					// class="hresume"
					// which is where the raw resume text is stored
					// System.out.println(currentPage.select("div.hresume").text());
					writer.append(currentPage.select("div.hresume").text());

				}

			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
