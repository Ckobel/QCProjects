package myCAPTCHA;

import java.util.Random;

public class Captcha {
	private String captcha;
	private int len;

	public Captcha() {
		captcha = "";
		len = 8;
	}

	public String generateCaptchaString() {
		int[] asciivals = new int[36];
		int index = 0;

		String s = "";
		// Populate array with ascii values of
		// 0 - 9 {ASCII 48-57}
		// A - Z {ASCII 65-90}

		for (int i = 48; i <= 57; i++) {
			asciivals[index++] = i;
		}
		for (int i = 65; i <= 90; i++) {
			asciivals[index++] = i;
		}

		
		//generate String of randomly chosen alphanumber characters
	
		for (int i = 0; i < this.len; i++) {
			s += (char) getRandom(asciivals);
		}

		return s;
	}

	public static int getRandom(int[] arr) {
		int rand = new Random().nextInt(arr.length);
		return arr[rand];
	}

}
