//package hackerrank;

import java.util.Scanner;

public class matrix_difference {

	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int a[][] = new int[n][n];
	        for(int a_i=0; a_i < n; a_i++){
	            for(int a_j=0; a_j < n; a_j++){
	                a[a_i][a_j] = in.nextInt();
	            }
	        }
	        
	        System.out.println(diagonal_diff(a));
	    }
	    
	    static int diagonal_diff(int[][] matrix){
	        int primary_diagonal = 0;;
	        int secondary_diagonal = 0;;
	        for(int i = 0; i < matrix.length; i++){
	            primary_diagonal += matrix[i][i];
	            secondary_diagonal += matrix[(matrix.length - 1) - i][i];
	        }
	        return Math.abs(primary_diagonal - secondary_diagonal);
	    }
}
