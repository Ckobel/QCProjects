package hackerrank;

	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;

	
public class main{
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int arr[][] = new int[6][6];
	        for(int arr_i=0; arr_i < 6; arr_i++){
	            for(int arr_j=0; arr_j < 6; arr_j++){
	                arr[arr_i][arr_j] = in.nextInt();
	            }
	        }
	        
	        System.out.println(max_hourglass(arr));
	    }
	    
	    static int max_hourglass(int[][] arr){
	        int maxhg = 0;
	        for(int i = 1; i < arr.length - 2; i++){
	            for(int j = 1; j < arr.length - 2; j++){
	                maxhg = Math.max(maxhg,hourglass(i,j,arr));
	            }
	        }
	        return maxhg;
	        
	    }
	    
	    static int hourglass(int i, int j, int[][] arr){
	        int hg = 0;
	        int m,k;
	        
	        for(m = i - 1; m <= i + 1; m++){
	            for(k = j - 1; k <= j + 1; k++){
	                hg += (arr[m][k]);
	            }
	        }
	        hg -= arr[i][j-1];
	        hg -= arr[i][j+1];
	        return hg;
	    }
	}

	
