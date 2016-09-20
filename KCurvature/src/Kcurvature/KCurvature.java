import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class KCurvature{
	int K;
	int numPts;
	boundaryPt[] boundaryPtAry;
	int beginIndex;
	int Q;
	int P;
	int R;
	int index;
	
	KCurvature(String inputFile, String k) throws FileNotFoundException{
		K = Integer.parseInt(k);
		beginIndex = 0;
		Q = 0;
		P = K;
		R = 2*K;
		
		
		Scanner inFile = new Scanner(new FileReader(inputFile)); 
		for(int i = 0; i < 6; i++){
			numPts = inFile.nextInt();
		}		
			boundaryPtAry = new boundaryPt[numPts];
			loadData(inputFile);
			
			while(!(P == K-1)){
				index = P;
				boundaryPtAry[index].curvature = computeCurvature(P,Q,R);
				P = (P+1) % numPts;
				Q = (Q+1) % numPts;
				R = (R+1) % numPts;
			}
			
			
			for(int i = 0; i < numPts; i++){
				boundaryPtAry[i].localMax = computeLocalMaxima(i);
				//System.out.println(boundaryPtAry[i].x + "," + boundaryPtAry[i].y + " local max = " + boundaryPtAry[i].localMax);
			}
			
			for(int i = 0; i < numPts; i++){
				boundaryPtAry[i].corner = isCorner(i);
				//System.out.println(boundaryPtAry[i].x + "," + boundaryPtAry[i].y + " corner = " + boundaryPtAry[i].corner);
			}
			
			inFile.close();
	}
	
	void loadData(String inputFile) throws FileNotFoundException{
		Scanner inFile = new Scanner(new FileReader(inputFile)); 
	
		    //go past header, label, and numPts
			for(int i = 0; i < 6; i++){
				inFile.nextInt();
			}
			//actual data load
			int index = 0;
			while(inFile.hasNext()) {      // x                // y
				boundaryPtAry[index++] = new boundaryPt(inFile.nextInt(),inFile.nextInt());
			}
		
		inFile.close();
	}
	
	int computeLocalMaxima(int index){
		for(int i = -2; i < 3; i++){
			if(boundaryPtAry[index].curvature < boundaryPtAry[(index + i + (numPts)) % numPts].curvature){
				return 0;
			}
		}
		return 1;
	}
	
	// p(i) is a corner (returns 8) if p(i) is a local maxima AND for all p(i-2), p(i-1), p(i+1), p(i+2)
	// only p(i-1) or p(i+1) can be a local maxima, otherwise, p(i) is not a corner (return 1).
	
	int isCorner(int index){
		
	
		if(boundaryPtAry[index].localMax == 1){
			if( 
				(boundaryPtAry[(index - 2 + numPts) % numPts].localMax == 1)
			|| (boundaryPtAry[(index + 2 + numPts) % numPts].localMax == 1) ){
				return 1;
			}
			return 8;
		}
		return 1;
		}
	
	double computeCurvature(int p, int q, int r){
		double r1 = boundaryPtAry[r].x;
		double r2 = boundaryPtAry[r].y;
		
		double c1 = boundaryPtAry[q].x;
		double c2 = boundaryPtAry[q].y;
		
		double r3 = boundaryPtAry[p].x;
		double c3 = boundaryPtAry[p].y;
		
		return  ((r1 - r2)/((c1 - c2)+.00001)) - ((r2 - r3)/((c2 - c3)+.00001));
		
	}
	}


