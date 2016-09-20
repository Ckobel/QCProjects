package hackerrank;

import java.util.Scanner;

public class amtopm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String time = in.next();
		System.out.println(AMtoPM(time));

	}

	static String AMtoPM(String time) {
		// For AM, just % 12 [12am - 11am]
		// For NOON, do nothing [12pm]
		// For PM, add 12 [1pm - 11pm]
		int hr = Integer.parseInt(time.substring(0,2));
		String ampm = time.substring(time.length()-2, time.length());
		
		//base case, its hiiiiiigh noon
		if((hr == 12) && (ampm.compareTo("PM") == 0)){
			return time.substring(0,time.length()-2);
		}
		//case 1: AM
		if((ampm.compareTo("AM") == 0)){
			hr %=12;
			String hour = "";
			if(hr < 10){hour = "0";}
			return (hour + hr) + time.substring(2,time.length()-2);
		}
		
		return (hr+12) + time.substring(2,time.length()-2);
	}
}
