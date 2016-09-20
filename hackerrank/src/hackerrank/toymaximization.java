package hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class toymaximization {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt(), k = stdin.nextInt();
		int prices[] = new int[n];
		for (int i = 0; i < n; i++)
			prices[i] = stdin.nextInt();

		Arrays.sort(prices);
		int answer = 0;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(k >= prices[j] && prices[j] != 0){
					answer++;
					k-=prices[j];
					prices[j] = 0;
				}
			}
		}
		// Compute the final answer from n,k,prices
		System.out.println(answer);
		
		
	}

}
