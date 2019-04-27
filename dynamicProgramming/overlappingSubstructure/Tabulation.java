package dynamicProgramming.overlappingSubstructure;

import java.util.Scanner;

public class Tabulation {
	// In dynamic programming tabulation is a bottom up approach.
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		long nanoTime = System.nanoTime();
		System.out.println("The fibonacci at index " + input + " is: " + fib(input));
		System.err.println(
				"\nTime taken by tabulation dynamic programming = " + (System.nanoTime() - nanoTime) + " nano sec.");
		nanoTime = System.nanoTime();
		System.out.println("The fibonacci at index " + input + " using pure recursion is: " + fibRecur(input)
				+ ".\nTime taken by recursive = " + (System.nanoTime() - nanoTime) + " nano sec.");
	}

	private static int fibRecur(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibRecur(n - 1) + fibRecur(n - 2);
	}

	private static int fib(int n) {
		int fib[] = new int[n + 1];
		fib[1] = fib[2] = 1;
		int i = 3;
		while (i <= n) {
			fib[i] = fib[i - 2] + fib[i - 1];
			i++;
		}
		return fib[n];
	}
}
