package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class circular_array_rotation {

	public int[] arr;

	public circular_array_rotation(int n) {
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * 100);
		}
	}

	public void rotate(int k) {
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			arr[(i + k) % (arr.length)] = temp[i];
		}

	}

	public int query(int q) {
		return arr[q];
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += (arr[i] + " ");
		}
		return str;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// input is n, k, q
		int n, k, q;

		n = in.nextInt();
		k = in.nextInt();
		q = in.nextInt();

		circular_array_rotation car = new circular_array_rotation(n);

		for (int i = 0; i < n; i++) {
			car.arr[i] = in.nextInt();
		}

		car.rotate(k);

		int queries[] = new int[q];
		for (int i = 0; i < q; i++) {
			queries[i] = in.nextInt();
		}
		for (int i = 0; i < q; i++) {
			System.out.println(car.query(queries[i]));
		}

	}

}
