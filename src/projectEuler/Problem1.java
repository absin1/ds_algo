/**
 * 
 */
package projectEuler;

import java.util.Scanner;

/**
 * @author absin
 * 
 *         If we list all the natural numbers below 10 that are multiples of 3
 *         or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find
 *         the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
	public static void main(String argsp[]) {
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.close();
		for (int i = 1; i < N; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
