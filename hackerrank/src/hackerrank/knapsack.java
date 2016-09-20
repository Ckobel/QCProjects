package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class knapsack {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		int n, k;
		int a[];
		while (cases-- > 0) {
			n = in.nextInt();
			a = new int[n];
			k = in.nextInt();

			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}

			int maxSum = 0;
			int counter = n;
			
			while(counter > 0 && maxSum <= k){
				for(int i = 0; i < n; i++){
					if(maxSum + a[i] <= k){
						maxSum+= a[i];
						counter = n;
					}
					else{
						counter--;
					}
				}
			}
			
			System.out.println(maxSum);
		}

		String string = "moron";
	}

	static int max(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}

}