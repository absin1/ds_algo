package thirtydaysofcode;

import java.util.Scanner;

public class Solution11 {
	/*
	 * -1 -1 0 -9 -2 -2 -2 -1 -6 -8 -2 -5 -1 -1 -1 -2 -3 -4 -1 -9 -2 -4 -4 -5 -7
	 * -3 -3 -2 -9 -9 -1 -3 -1 -2 -4 -5
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		in.close();
		System.out.println(getMaximumHourglassSum(arr));
	}

	private static int getMaximumHourglassSum(int[][] arr) {
		int maxHourglassSum = Integer.MIN_VALUE;
		int[][] hourglassIdentifier = { { 0, 0 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				int hourGlassSum = 0;
				for (int j2 = 0; j2 < hourglassIdentifier.length; j2++) {
					hourGlassSum += arr[i + hourglassIdentifier[j2][0]][j + hourglassIdentifier[j2][1]];
				}
				if (hourGlassSum > maxHourglassSum)
					maxHourglassSum = hourGlassSum;
			}
		}
		return maxHourglassSum;
	}
}
