package hackerrank;

public class staircase {

	public static void main(String[] args){
		int n = 6;
		staircase(n);
	}
	
	static void staircase(int n){
		//print n - 1 " "
		//print n - (n-1) #
		
		for(int i = 0; i < n; i++){
			int j;
			for(j = (n - i) - 1; j > 0; j--){
				System.out.print(" ");
			}
			for(int k = i; k >= 0; k--){
				System.out.print("#");
			}
			System.out.println();
				
		}
	}
}
