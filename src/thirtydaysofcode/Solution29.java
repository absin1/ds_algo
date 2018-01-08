package thirtydaysofcode;

import java.util.Scanner;

public class Solution29 {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int arr[][] = new int[T][2];
		for (int i = 1; i <= T; i++) {
			arr[i - 1][0] = scanner.nextInt();
			arr[i - 1][1] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < T; i++) {
			int max = Integer.MIN_VALUE;
			for (Integer j = 1; j < arr[i][0]; j++) {
				for (Integer k = j + 1; k <= arr[i][0]; k++) {
					int tmp = j & k;
					//System.out.println(j + "&" + k + "=" + tmp);
					if (tmp < arr[i][1] && tmp > max) {
						max = tmp;
					}
				}
			}
			System.out.println(max);
		}
	}
}
