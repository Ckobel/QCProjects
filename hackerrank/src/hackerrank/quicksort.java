package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class quicksort {

	static void partition(int[] ar) {
		int pivot = ar[0];
		List left = new ArrayList();
		List right = new ArrayList();
		List equal = new ArrayList();

		equal.add(pivot);
		for (int i = 1; i < ar.length; i++) {
			if (ar[i] > pivot) {
				right.add(ar[i]);
			} else if (ar[i] < pivot) {
				left.add(ar[i]);
			} else {
				equal.add(ar[i]);
			}
		}

		for (int i = 0; i < left.size(); i++) {
			System.out.print(left.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < right.size(); i++) {
			System.out.print(right.get(i) + " ");
		}

		System.out.println();
		http: // goo.gl/DcPPLf

		left.addAll(equal);
		left.addAll(right);

		for (

		int i = 0; i < left.size(); i++) {
			System.out.print(left.get(i) + " ");
		}
		System.out.println();

	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
	}

}
