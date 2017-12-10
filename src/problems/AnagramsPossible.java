package problems;

import java.util.Scanner;

public class AnagramsPossible {
	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		backTrack(s.toCharArray(), 0, s.toCharArray().length - 1);
	}

	public static void backTrack(char[] s, int i, int n) {
		int j;
		if (i == n)
			System.out.println(s);
		else {
			for (j = i; j <= n; j++) {
				swap(s, i, j);
				backTrack(s, i + 1, n);
				swap(s, i, j);
			}
		}

	}

	private static void swap(char[] s, int i, int j) {
		char temp;
		temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
