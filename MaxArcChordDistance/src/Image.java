import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Image {

	int numRows;
	int numCols;
	int minVal;
	int maxVal;
	int[][] imgAry;

	Image(String inputFile) throws FileNotFoundException {
		Scanner inFile = new Scanner(new FileReader(inputFile));
		numRows = inFile.nextInt();
		numCols = inFile.nextInt();
		minVal = inFile.nextInt();
		maxVal = inFile.nextInt();

		imgAry = new int[numRows][numCols];

		inFile.close();
	}

	void prettyPrint(String prettyFile) throws IOException {
		FileWriter prettyPrint = new FileWriter(new File(prettyFile));
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (imgAry[i][j] == 0) {
					prettyPrint.write("  ");
				} else {
					prettyPrint.write(" " + imgAry[i][j] + " ");
				}
			}
			prettyPrint.write("\n");
		}
		prettyPrint.close();
	}
}
