package dynamicProgramming;

import java.util.Scanner;

public class Memoization {
	static int max = 1000;
	static int fibArr[] = new int[max];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		init();
		System.out.println("The fibonacci at index " + input + " is: " + fib(input-1));
	}

	private static void init() {
		fibArr[0] = fibArr[1] = 1;
	}

	private static int fib(int n) {
		if (fibArr[n] != 0) {
			return fibArr[n];
		}
		fibArr[n] = fib(n - 1) + fib(n - 2);
		return fibArr[n] ;
	}
}
