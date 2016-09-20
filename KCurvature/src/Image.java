import java.io.FileNotFoundException;
import java.io.FileReader;
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

		inFile.nextInt();
		inFile.nextInt();

		int num = 1;
		while (inFile.hasNext()) {
			imgAry[inFile.nextInt()][inFile.nextInt()] = num++;
		}

		inFile.close();
	}

	void prettyPrint() {
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if (imgAry[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(" " + imgAry[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
