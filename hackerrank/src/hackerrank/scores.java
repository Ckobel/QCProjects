//package hackerrank;

import java.util.Scanner;

public class scores {
	   	static int b_score = 0;
	    static int a_score = 0;
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int a0 = in.nextInt();
	        int a1 = in.nextInt();
	        int a2 = in.nextInt();
	        int alice[] = {a0,a1,a2};
	       
	        int b0 = in.nextInt();
	        int b1 = in.nextInt();
	        int b2 = in.nextInt();
	        int bob[] = {b0,b1,b2};
	        
	        getScore(alice,bob);
	        System.out.println(a_score + " " + b_score);
	    }
	    
	    static void getScore(int[] a, int[] b){
	    	for(int i = 0; i < a.length; i++){
	    		if(a[i] >= b[i]){
	    			if(!(a[i] == b[i])){
	    				a_score++;
	    			}
	    		}
	    		else{
	    			b_score++;
	    		}
	    	}
	    }
}
