package problems;

import java.util.Scanner;

public class ReverseWOSpecial {
	// Input string: a!!!b.c.d,e'f,ghi
	// Output string: i!!!h.g.f,e'd,cba

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
			if (isSpecial(charArray[start])) {
				start++;
			} else if (isSpecial(charArray[end])) {
				end--;
			} else {
				char temp = charArray[start];
				charArray[start] = charArray[end];
				charArray[end] = temp;
				start++;
				end--;
			}
		}
		System.out.println(String.valueOf(charArray));
	}

	private static boolean isSpecial(char c) {
		boolean isSpecial = true;
		if (c >= 'a')
			if (c <= 'z')
				isSpecial = false;
		if (c >= 'A')
			if (c <= 'Z')
				isSpecial = false;
		return isSpecial;
	}
}
