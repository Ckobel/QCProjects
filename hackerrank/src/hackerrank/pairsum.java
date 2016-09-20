package hackerrank;

import java.util.Arrays;

public class pairsum {

	public static void main(String[] args) {
		int a[] = new int[100];
		for(int i = 0; i < 100; i++){
			a[i] = i*3 % 10;
		}
		pairSums(a, 6);
	}

	// for an array, find all pairs of ints in the array that sum to the value k
	// shitty O(n^2) way is to double for loop and check every possible pair in
	// the array
	// better way is to sort the array and then compare lefts and rights
	static void pairSums(int[] arr, int k) {

		// cant find a pair of sums in arr of size 1..
		if (arr.length < 2) {
			return;
		}

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;

		int currentSum = 0;
		while (left < right) {
			currentSum = arr[left] + arr[right];

			if (currentSum == k) {
				System.out.println(arr[left] + "," + arr[right]);
				left++;
			} else if (currentSum < k) {
				left++;
			} else {
				right--;
			}
		}

	}
}
