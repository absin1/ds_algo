package problems;

import java.util.Scanner;

public class ReverseUsingRecursion {
	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		reverse(s.toCharArray(), 0);
	}

	private static void reverse(char[] charArray, int i) {
		if (i < charArray.length) {
			reverse(charArray, i + 1);
			System.out.print(charArray[i]);
		}

	}
}
