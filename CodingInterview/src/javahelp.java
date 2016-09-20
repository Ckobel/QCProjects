import java.util.Scanner;

public class javahelp {

	public static void main(String[] args) {
		getUserInput();
	}

	public static void getUserInput() {

		Scanner in = new Scanner(System.in);
		String input;
		int num;

		while (true) {
			System.out.println("Enter an int");
			input = in.next();

			try {
				num = Integer.parseInt(input);
				System.out.println("You entered: " + num);
				break;
				
			} catch (NumberFormatException e) {
				System.out.println("That's not an int");
			}
			
		}
	}
}