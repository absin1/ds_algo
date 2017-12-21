package permutation;

import java.util.Scanner;

public class JohnsonTrotter {
	public static void main(String args[]) {
		System.out.println("Enter the count of integers whose all "
				+ "possible orders will be permuted using Johnson and Trotter");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		int arr[] = new int[N];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}
		int permutationCount = factorial(N);
		int first = N - 2;
		int second = N - 1;
		String direction = "backward";
		boolean isTerminalHandled = false;
		print(arr);
		for (int j = 1; j < permutationCount; j++) {
			swap(arr, first, second);
			print(arr);
			if (direction.equalsIgnoreCase("backward")) {
				if (second == N - 1) {
					if (isTerminalHandled) {
						first = 0;
						second = 1;
						isTerminalHandled = false;
						direction = "forward";
					} else {
						first--;
						second--;
					}
				} else if (first == 0) {
					first = N - 2;
					second = N - 1;
					isTerminalHandled = true;
				} else {
					first--;
					second--;
				}
			} else {
				if (second == N - 1) {
					first = 0;
					second = 1;
					isTerminalHandled = true;
				} else if (first == 0) {
					if (isTerminalHandled) {
						first = N - 2;
						second = N - 1;
						isTerminalHandled = false;
						direction = "backward";
					} else {
						first++;
						second++;
					}
				} else {
					first++;
					second++;
				}
			}
		}
	}

	private static void swap(int[] arr, int first, int second) {
		int temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	private static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}
}
