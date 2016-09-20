import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {

	public static void main(String[] args) throws IOException{
		arcChordDistance acd = new arcChordDistance(args[0], args[1], args[2], args[4]);
		Image img = new Image(args[0]);
		
		for(int i = 0; i < acd.numPts;i++){
			img.imgAry[acd.boundaryPtAry[i].x][acd.boundaryPtAry[i].y] = acd.boundaryPtAry[i].corner;
		}
		img.prettyPrint(args[3]);
	}
}
