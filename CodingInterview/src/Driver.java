import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new FileReader(new File(args[0])));
		
		myHashMap primes = new myHashMap();

		
		int n = 0;
		while(n < 1000){
			primes.put(n, ("" + getNthPrime(n)));
			n++;
		}
		System.out.println("Finished hashing primes");
		
		System.out.println(primes.get(4));
		Thread.sleep(1000);
		System.out.println(getNthPrime(4));
		
		
	
	}
	
	public static int getNthPrime(int n){
		int num, count, i;
	    num=1;
	    count=0;
	 
	    while (count < n){
	      num=num+1;
	      for (i = 2; i <= num; i++){
	        if (num % i == 0) {
	          break;
	        }
	      }
	      if ( i == num){
	        count = count+1;
	      }
	    }
	    return num;

	}

	public static boolean hasDuplicateChars(String input) {

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.indexOf(input.charAt(i)) != input.lastIndexOf(input.charAt(i)))
				return true;
		}
		return false;
	}

	public static String[] generateRandomWords(int numberOfWords) {
		String[] randomStrings = new String[numberOfWords];
		Random random = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[random.nextInt(3)]; // words of length 3
															// through 10. (1
															// and 2 letter
															// words are
															// boring.)
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + random.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}
}
