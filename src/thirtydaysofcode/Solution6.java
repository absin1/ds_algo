package thirtydaysofcode;
import java.util.Scanner;

public class Solution6 {

	public static void main(String[] args) {

		int iters;
		Scanner scanner = new Scanner(System.in);
		iters = scanner.nextInt();
		scanner.nextLine();
		String input[] = new String[iters];
		for (int i = 0; i < iters; i++) {
			input[i] = scanner.nextLine();
		}
		scanner.close();
		for (String string : input) {
			char[] charArray = string.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if (i % 2 == 0) {
					System.out.print(charArray[i]);
				}
			}
			System.out.print(" ");
			for (int i = 0; i < charArray.length; i++) {
				if (i % 2 != 0) {
					System.out.print(charArray[i]);
				}
			}
			System.out.println();
		}
	}
}
