import java.io.File;
import javax.swing.JFileChooser;

public class ListLargestFile {
	public static File largestFile = new File(""); //keep track of largest file
	
	public static void main(String[] args) {
        JFileChooser fd = new JFileChooser();
//        mode - the type of files to be displayed:
//            * JFileChooser.FILES_ONLY
//            * JFileChooser.DIRECTORIES_ONLY
//            * JFileChooser.FILES_AND_DIRECTORIES 
        fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //select directories only
        fd.showOpenDialog(null); //open file chooser dialog box
		File f = fd.getSelectedFile(); //get and save folder that was just selected from dialog box
		listFiles(f);
		
		System.out.println("Largest file: " + largestFile.getAbsolutePath()); //print out (absolute) path of largest file
		System.out.println("Largest file length (in MB): " + ((double)largestFile.length()) * .00000098);
	}
	
	/**
	 * Finds the largest file in the directories and sub-directories.
	 * @param dir directory to be searched
	 */
	public static void listFiles(File dir) {
		File files[] = dir.listFiles(); //get list of files in directory
		
		if (files != null) { //in case listfiles() returns null
			for (int i = 0; i<files.length; i++) {
				File currentFile = files[i]; //grab current file in directory
				
				if ( currentFile.isDirectory() ) //if it's a directory
					listFiles(currentFile); //search this directory recursively
				else if (currentFile.length() > largestFile.length()) { //otherwise if file has a larger length than current largest
					largestFile = currentFile; //update largestFile
				}
			}
		}
	}
}