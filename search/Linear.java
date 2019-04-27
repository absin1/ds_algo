package search;

import java.util.Scanner;

public class Linear {
	public static void main(String[] args) {
		int arr[] = { 32, 12, 249, 518, 84, 23, 651, 9, 7, 3 };
		Scanner scanner = new Scanner(System.in);
		int find = scanner.nextInt();
		scanner.close();
		System.out.println("The result of linear search is: " + linearSearch(arr, find));
	}

	public static int linearSearch(int[] arr, int find) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find)
				return i;
		}
		return -1;
	}
}
