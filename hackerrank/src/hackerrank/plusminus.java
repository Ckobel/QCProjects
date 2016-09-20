package hackerrank;

import java.util.Scanner;

public class plusminus {
	static double pos = 0;
	static double neg = 0;
	static double zero = 0;
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        getDistribution(arr);
        System.out.println(pos/(double)n);
        System.out.println(neg/(double)n);
        System.out.println(zero/(double)n);
    }
	
	static void getDistribution(int[] arr){
		for(int i : arr){
			if( i > 0){
				pos++;
			}
			else if(i < 0){
				neg++;
			}
			else{
				zero++;
			}
		}
	}
	
	
}
