import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException{
		
		KCurvature kcurve = new KCurvature(args[0],args[1]);
		Image img = new Image(args[0]);
		img.prettyPrint();
		
		
		for(int i = 0; i < kcurve.numPts; i++){
			img.imgAry[kcurve.boundaryPtAry[i].x][kcurve.boundaryPtAry[i].y] = kcurve.boundaryPtAry[i].corner;
		}
		for(int i = 0; i < img.numRows; i++){
			for(int j = 0; j < img.numCols; j++){
				if(img.imgAry[i][j] == 0){
					System.out.print("  ");
				}
				else{
					System.out.print(" " + img.imgAry[i][j] + " ");
				}
			}
			System.out.println();
		}
			
		
	}
}


