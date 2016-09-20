import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class arcChordDistance {
	int Kchord;
	int numPts;
	boundaryPt[] boundaryPtAry;
	double[] chordAry;
	int P1;
	int P2;

	arcChordDistance(String inputFile, String k, String outputFile, String debugFile) throws IOException {
		Kchord = Integer.parseInt(k);
		chordAry = new double[Kchord];
		P1 = Kchord;
		P2 = 0;
		
		Scanner inFile = new Scanner(new FileReader(inputFile));
		for (int i = 0; i < 6; i++) {
			numPts = inFile.nextInt();
		}
		boundaryPtAry = new boundaryPt[numPts];
		loadData(inputFile);
		FileWriter debugr = new FileWriter(new File(debugFile));
		BufferedWriter debug = new BufferedWriter(debugr);
		FileWriter outputr = new FileWriter(new File(outputFile));
		BufferedWriter output = new BufferedWriter(outputr);
		
		

		
		
		debug.write("CHORD ARRAY");
		debug.newLine();
		debug.newLine();
		while(!(P1 == Kchord / 2)){
			
			int index = 0;
			int currPt = P2 + 1 ;
			double distance;
		
		
		
		while(index < Kchord){
			
			distance = computeDistance(P1, P2, (currPt % numPts));
			chordAry[index] = distance;
			index++;
			currPt++;
		}//step 6 repeat
		
		
		//print  chordAry to debugging file (argv[5])
		
		for(int i = 0; i < Kchord; i++){
			String s = "";
			s+= chordAry[i];
			debug.write(s + "  ");
		}
		
		debug.newLine();
		
		
		int maxIndex = findMaxDistance();
		int whichIndex = P1 + maxIndex;
		boundaryPtAry[whichIndex].maxCount++;
		
		if(boundaryPtAry[whichIndex].maxDistance < chordAry[maxIndex]){
			boundaryPtAry[whichIndex].maxDistance = chordAry[maxIndex];
		}
		
		P1 = (P1 + 1) % numPts;
		P2 = (P2 + 1) % numPts;
		
	}//end 5-11
		
		//step 12
		debug.newLine();
		debug.newLine();
		debug.write(" x  y  maxCount maxDist");
		debug.newLine();
				
		for(int i = 0; i < boundaryPtAry.length; i++){
			debug.write(boundaryPtAry[i].x + "  " + boundaryPtAry[i].y + "  " + boundaryPtAry[i].maxCount + "  " + boundaryPtAry[i].maxDistance);
			debug.newLine();
		}
		
		for (int i = 0; i < numPts; i++) {
			boundaryPtAry[i].maxDistance = computeLocalMaxima(i);
			// System.out.println(boundaryPtAry[i].x + "," + boundaryPtAry[i].y
			// + " local max = " + boundaryPtAry[i].localMax);
		}
			output.write("x  y  corner");
			output.newLine();
		for (int i = 0; i < numPts; i++) {
			boundaryPtAry[i].corner = isCorner(i);
			output.write(boundaryPtAry[i].x + " " + boundaryPtAry[i].y + " " + boundaryPtAry[i].corner);
			output.newLine();
			// System.out.println(boundaryPtAry[i].x + "," + boundaryPtAry[i].y
			// + " corner = " + boundaryPtAry[i].corner);
		}
		
		inFile.close();
		debug.close();
		output.close();
	}
	
	int findMaxDistance(){
		int max = 0;
		for(int i = 0; i < chordAry.length; i++){
			if(chordAry[i] > chordAry[max]){
				max = i;
			}
		}
		return max;
	}
	double computeDistance(int a, int b, int p) {
		
		boundaryPt A = boundaryPtAry[a];
		boundaryPt B = boundaryPtAry[b];
		boundaryPt P = boundaryPtAry[p];
	
	    double normalLength = Math.sqrt((B.x-A.x)*(B.x-A.x)+(B.y-A.y)*(B.y-A.y));
	    return Math.abs((P.x-A.x)*(B.y-A.y)-(P.y-A.y)*(B.x-A.x))/normalLength;
	  }

	void loadData(String inputFile) throws FileNotFoundException {
		Scanner inFile = new Scanner(new FileReader(inputFile));

		// go past header, label, and numPts
		for (int i = 0; i < 6; i++) {
			inFile.nextInt();
		}
		// actual data load
		int index = 0;
		while (inFile.hasNext()) { 						// x                 y
			boundaryPtAry[index++] = new boundaryPt(inFile.nextInt(), inFile.nextInt());
			
		}

		inFile.close();
	}

	double computeLocalMaxima(int index) {
		for (int i = -2; i < 3; i++) {
			if (boundaryPtAry[index].maxCount < boundaryPtAry[(index + i + (numPts)) % numPts].maxCount) {
				return 0;
			}
		}
		return 1;
	}

	// p(i) is a corner (returns 8) if p(i) is a local maxima AND for all
	// p(i-2), p(i-1), p(i+1), p(i+2)
	// only p(i-1) or p(i+1) can be a local maxima, otherwise, p(i) is not a
	// corner (return 1).

	int isCorner(int index) {

		if (boundaryPtAry[index].maxDistance == 1.0) {
			if ((boundaryPtAry[(index - 2 + numPts) % numPts].maxDistance == 1.0)
					|| (boundaryPtAry[(index + 2 + numPts) % numPts].maxDistance == 1.0)) {
				return 1;
			}
			return 9;
		}
		return 1;
	}

}
