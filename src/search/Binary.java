package search;

import java.util.Scanner;

public class Binary {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		Scanner scanner = new Scanner(System.in);
		int find = scanner.nextInt();
		scanner.close();
		System.out.println("The result of binary search is: " + binarySearch(arr, find));
		System.out.println(
				"The result of recursive binary search is: " + binarySearchRecursive(arr, 0, arr.length - 1, find));
	}

	public static int binarySearch(int[] arr, int find) {
		int from = 0;
		int to = arr.length - 1;
		while (from <= to) {
			int middle = (from + to) / 2;
			if (arr[middle] == find)
				return middle;
			if (arr[middle] < find)
				from = middle + 1;
			else
				to = middle - 1;
		}
		return -1;
	}

	public static int binarySearchRecursive(int arr[], int from, int to, int find) {
		if (to >= from) {
			int middle = (from + to) / 2;
			if (arr[middle] == find)
				return middle;
			if (arr[middle] > find)
				return binarySearchRecursive(arr, from, middle - 1, find);
			if (arr[middle] < find)
				return binarySearchRecursive(arr, middle + 1, to, find);
		}
		return -1;
	}

}
