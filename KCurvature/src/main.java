import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException {

		KCurvature kcurve = new KCurvature(args[0], args[1]);
		Image img = new Image(args[0]);

		for (int i = 0; i < kcurve.numPts; i++) {
			img.imgAry[kcurve.boundaryPtAry[i].x][kcurve.boundaryPtAry[i].y] = kcurve.boundaryPtAry[i].corner;
		}
		img.prettyPrint();

	}
}
