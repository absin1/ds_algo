package permutation;

import java.util.HashSet;
import java.util.Scanner;

public class JohnsonTrotter {
	static HashSet<String> permutations = new HashSet<>();

	public static void main(String args[]) {
		// Incorrect();
		System.out.println("Enter the count of integers whose all "
				+ "possible orders will be permuted using Johnson and Trotter");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		int arr[] = new int[N];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}
		boolean[] direction = new boolean[N];
		// I am using a boolean array of the same size as the number of
		// integers. A true indicates right, and false indicates left. Don't
		// judge me for choosing right as true, I am right handed :P. There is
		// another reason why I chose right as true, by default a new boolean
		// array in Java has all values as false which means all numbers point
		// to left by default which is how the algorithm starts so yeah ..
		Integer index;
		while ((index = findBiggestMobile(arr, direction)) != -1) {
			print(arr);
			swap(arr, index, direction);
		}
	}

	private static void swap(int[] arr, Integer index, boolean[] direction) {
		if (direction[index]) {
			swap(arr, index, index + 1);
			swap(direction, index, index + 1);
			index++;
		} else {
			swap(arr, index, index - 1);
			swap(direction, index, index - 1);
			index--;
		}
		reverseAllOtherBigger(arr, direction, index);
	}

	private static void reverseAllOtherBigger(int[] arr, boolean[] direction, Integer index) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > arr[index]) {
				direction[i] = !direction[i];
			}
		}

	}

	private static Integer findBiggestMobile(int[] arr, boolean[] direction) {
		Integer max = Integer.MIN_VALUE;
		Integer maxIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (direction[i]) {
				if (i < (arr.length - 1)) {
					if (arr[i] > arr[i + 1]) {
						if (arr[i] > max) {
							max = arr[i];
							maxIndex = i;
						}
					}
				}
			} else {
				if (i > 0) {
					if (arr[i] > arr[i - 1]) {
						if (arr[i] > max) {
							max = arr[i];
							maxIndex = i;
						}
					}
				}
			}
		}
		return maxIndex;
	}

	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	private static void swap(boolean[] arr, int first, int second) {
		boolean temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
