package thirtydaysofcode;

import java.util.Random;

public class Solution27 {
	public static Random ran = new Random();

	public static void main(String[] args) {
		int T = ran.nextInt(5) + 1;
		System.out.println(T);
		for (int i = 1; i <= T; i++) {
			if (i % 2 == 0)
				createCancelledTestCase();
			else
				createUncancelledTestCase();

		}
	}

	private static void createCancelledTestCase() {
		int n = ran.nextInt(198) + 3;
		int k = ran.nextInt(n) + 1;
		System.out.print(n + " " + k);
		System.out.println();
		int arr[] = new int[n];
		int kCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (kCount <= k) {
				arr[i] = ran.nextInt(999) + 1;
				kCount++;
			} else {
				arr[i] = ran.nextInt(2001) - 1000;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static void createUncancelledTestCase() {
		int n = ran.nextInt(198) + 3;
		int k = ran.nextInt(n) + 1;
		System.out.print(n + " " + k);
		System.out.println();
		int arr[] = new int[n];
		int kCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (kCount <= k) {
				arr[i] = ran.nextInt(1000) - 1000;
				kCount++;
			} else {
				arr[i] = ran.nextInt(2001) - 1000;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
