/**
 * 
 */
package thirtydaysofcode;

import java.util.Scanner;

/**
 * @author absin
 *
 */
public class Solution25 {
	private static int checks = 0;

	/**
	 * 1 2147483647
	 * 1 1073741831
	 * 1 536870909
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int input[] = new int[N];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < input.length; i++) {
			if (new Solution25().checkPrimeBest(input[i]))
				System.out.println("Prime");
			else
				System.out.println("Not prime");
		}
		System.out.println(checks + " checks");
	}

	public boolean checkPrime(int i) {
		if (i < 2)
			return false;

		boolean isPrime = true;
		int ceil = (int) Math.floor(Math.sqrt((double) i));
		for (int j = 2; j <= ceil; j++) {
			checks++;
			if (i % j == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public boolean checkPrimeBest(int i) {
		if (i < 2)
			return false;
		if (i % 2 == 0)
			return false;
		boolean isPrime = true;
		int ceil = (int) Math.floor(Math.sqrt((double) i));
		for (int j = 3; j <= ceil; j += 2) {
			checks++;
			if (i % j == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
