import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

public class myHT {

	public static void main(String[] args) throws IOException{
		Hashtable<String, String> ht = new Hashtable<>();
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ckobel\\desktop\\text.txt"));
		
			String line;
			String word;
			while((line = br.readLine()) != null){
				String[] letters = line.split("");
				
				for(String letter : letters){
					
				}
				ht.put(line,line);
			}
			
			System.out.println("\n\n unique keys " );
			
			for (String s: ht.keySet()){
				System.out.println(s);
			}
			
			
	}
		
}
