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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int input[] = new int[N];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < input.length; i++) {
			if (new Solution25().checkPrime(input[i]))
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
}
