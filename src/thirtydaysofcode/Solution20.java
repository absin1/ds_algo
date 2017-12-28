package thirtydaysofcode;

import java.util.Scanner;

public class Solution20 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		int numSwap = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					numSwap++;
					swap(a, j, j + 1);
				}
			}
			if (numSwap == 0)
				break;
		}
		System.out.println("Array is sorted in " + numSwap + " swaps.");
		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[a.length - 1]);
	}

	private static void swap(int[] a, int i, int j) {
		a[j] = a[j] + a[i];
		a[i] = a[j] - a[i];
		a[j] = a[j] - a[i];
	}
}
