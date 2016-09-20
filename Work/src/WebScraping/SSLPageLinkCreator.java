package WebScraping;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SSLPageLinkCreator {
	public String url;
	public String grade;

	SSLPageLinkCreator(String url, String grade) {
		this.url = url;
		this.grade = grade;
	}

	static void bubbleSort(SSLPageLinkCreator[] AOL, int length) {
		boolean swapped = true;
		int j = 0;
		SSLPageLinkCreator tmp;

		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i < length - j; i++) {
				char g1 = AOL[i].grade.charAt(0);
				char g2 = AOL[i + 1].grade.charAt(0);
				if (g1 > g2) {
					tmp = AOL[i];
					AOL[i] = AOL[i + 1];
					AOL[i + 1] = tmp;
					swapped = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		if (args.length != 2) {

			System.err.println("Program expects 2 arguments:");
			System.err.println("Args[0]:  Result file of SSL-Scan.exe");
			System.err.println("Args[1]:  yourFileNameHere.html ........ YES, HTML");
			System.exit(1);
		}

		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("******************************************************************");
		System.out.println("******************************************************************");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("0000000000000000000/ _\\0/ _\\0| | 000000000000000000000000000000000");
		System.out.println("0000000000000000000\\ \\ 0\\ \\00| | 000000000000000000000000000000000");
		System.out.println("0000000000000000000_\\ |0_\\ |0| |__00000000000000000000000000000000");
		System.out.println("0000000000000000000\\__|0\\__|0|____|0000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("00000000000000000/ _\\0/ __\\0/_\\00000000000000000000000000000000000");
		System.out.println("00000000000000000\\ \\0/ /000//0\\\\0| '_ \\000000000000000000000000000");
		System.out.println("00000000000000000_\\ | /000/  _  \\| |0| |00000000000000000000000000");
		System.out.println("00000000000000000\\__|____/\\_/0\\_/|_|0|_|00000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		System.out.println("******************************************************************");
		System.out.println("******************************************************************");
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000");
		Thread.sleep(1000);
		makePage(args[0], args[1]);

	}

	static void makePage(String readFrom, String saveTo) throws IOException {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		String currentDate = dateFormat.format(cal.getTime());

		BufferedReader br = new BufferedReader(new FileReader(readFrom));

		// for wrong extension
		if (saveTo.indexOf(".") == -1) {
			System.err.println("You didn't even specify an extension, Fixing that for you.");
			saveTo += ".html";
			System.out.println("1 " + saveTo);
		} else {
			// for no extension
			if (saveTo.indexOf(".html") == -1) {
				System.err.println("Wrong extension type, should be .html, Fixing that for you.");
				saveTo = saveTo.substring(0, saveTo.indexOf(".")) + ".html";
			}
		}

		saveTo = (saveTo.substring(0, (saveTo.indexOf(".html"))) + "-" + currentDate + ".html");
		FileWriter fwriter = new FileWriter(saveTo);
		BufferedWriter writer = new BufferedWriter(fwriter);

		SSLPageLinkCreator[] ArrayOfLinks = new SSLPageLinkCreator[100];

		int justify = 50;
		int index = 0;

		// Populate ArrayOfLinks with URLS and Grades
		String line = br.readLine();
		if (line == null) {
			System.out.println("Your input file is either empty or wrong");
			System.exit(1);
		}
		while (line != null) {
			// remove all Quotes(") and Spaces( )
			line = line.replaceAll("\"", "");
			line = line.replaceAll(" ", "");

			// split the String into url and grade
			// line is formatted as url.url.com : grade
			String[] parts = line.split(":");

			// should only have 2 parts
			if (parts.length == 2) {
				ArrayOfLinks[index] = new SSLPageLinkCreator(parts[0], parts[1]);
				index++;
			}

			line = br.readLine();
		}
		br.close();

		bubbleSort(ArrayOfLinks, index);
		
		String report = "<b>SSL SCAN REPORT " + (new SimpleDateFormat("MM-dd-yyyy HH:mm:ss")).format(cal.getTime())
				+ "  </b> </br></br>";
		writer.write(report);
		writer.write("<table>");
		for (int i = 0; i < index; i++) {

			String link = "<tr><td>" + "<b>" + (i+1) +"&nbsp;</b>"  + "<a href=" + "\"" + "https://ssllabs.com/ssltest/analyze.html?viaform=on&d="
					+ ArrayOfLinks[i].url + "+&hideResults=on&latest=yes" + "\">" + ArrayOfLinks[i].url + "</a></td>";

			for (int j = 0; j < justify - ArrayOfLinks[i].url.length(); j++) {
				//link += "&nbsp;";
			}
			
			link += "<td><font color=\"red\">" + " <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Grade: " + ArrayOfLinks[i].grade + "</b></font></td></tr>";
			//writer.write("<b>" + (i + 1) + "   </b>");
			//System.out.println(link);
			writer.write(link);
			writer.newLine();

		}
		writer.write("</table>");
		writer.close();

		try {

			if ((new File(saveTo)).exists()) {

				Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + saveTo);
				p.waitFor();

			} else {

				System.out.println("File does not exist");

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}