package dynamicProgramming.overlappingSubstructure;

import java.util.Scanner;

public class Memoization {
	static int max = 1000;
	static int fibArr[] = new int[max];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		init();
		scanner.close();
		long nanoTime = System.nanoTime();
		System.out.println("The fibonacci at index " + input + " is: " + fib(input-	1));
		System.err.println(
				"\nTime taken by memoization dynamic programming = " + (System.nanoTime() - nanoTime) + " nano sec.");
		nanoTime = System.nanoTime();
		System.out.println("The fibonacci at index " + input + " using pure recursion is: " + fibRecur(input)
				+ ".\nTime taken by recursive = " + (System.nanoTime() - nanoTime) + " nano sec.");
	}

	private static int fibRecur(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibRecur(n - 1) + fibRecur(n - 2);
	}

	private static void init() {
		fibArr[0] = fibArr[1] = 1;
	}

	private static int fib(int n) {
		if (fibArr[n] != 0) {
			return fibArr[n];
		}
		fibArr[n] = fib(n - 1) + fib(n - 2);
		return fibArr[n];
	}
}
