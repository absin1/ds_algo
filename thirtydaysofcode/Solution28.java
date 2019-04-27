package thirtydaysofcode;

import java.util.Scanner;

public class Solution28 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		String arr[][] = new String[N][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = scanner.next();
			arr[i][1] = scanner.next();
		}
		scanner.close();
		String gmails[] = new String[N];
		int count = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1].endsWith("@gmail.com")) {
				gmails[++count] = arr[i][0];
			}
		}
		sort(gmails, count + 1);
		for (int i = 0; i <= count; i++) {
			System.out.println(gmails[i]);
		}
	}

	private static void sort(String[] arr, int n) {
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (greater(arr[j], arr[j + 1])) {
					// swap temp and arr[i]
					String temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	private static boolean greater(String string1, String string2) {
		boolean isString1Greater = false;
		int length1 = string1.length();
		int length2 = string2.length();
		int max = Math.max(length1, length2);
		char[] charArray1 = string1.toCharArray();
		char[] charArray2 = string2.toCharArray();
		for (int i = 0; i < max; i++) {
			if (charArray1[i] > charArray2[i]) {
				isString1Greater = true;
				break;
			}
			if (charArray1[i] < charArray2[i]) {
				isString1Greater = false;
				break;
			}
		}
		return isString1Greater;
	}
}
