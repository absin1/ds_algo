package problems;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		reverse(s.toCharArray());
	}

	private static void reverse(char[] charArray) {
		int start = 0;
		int end = charArray.length - 1;
		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		System.out.println(String.valueOf(charArray));
	}
}
