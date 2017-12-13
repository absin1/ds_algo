package dynamicProgramming;

import java.util.Scanner;

public class Tabulation {
	// In dynamic programming tabulation is a bottom up approach.
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		System.out.println("The fibonacci at index " + input + " is: " + fib(input));
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
