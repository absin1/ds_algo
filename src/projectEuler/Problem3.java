/**
 * 
 */
package projectEuler;

import java.util.Arrays;

/**
 * @author absin
 * 
 *         The prime factors of 13195 are 5, 7, 13 and 29. What is the largest
 *         prime factor of the number 600851475143?
 *
 */
public class Problem3 {
	public static void main(String args[]) {
		Double N = 600851475143.00;
		double sqrt = Math.floor(Math.sqrt(N));
		double arrayRowSize = Math.ceil((N / ((double) Integer.MAX_VALUE)));
		// System.out.println(arrayRowSize+"<"+Integer.MAX_VALUE);
		// System.out.println(arrayRowSize*(double) Integer.MAX_VALUE+">"+N);
		boolean[][] isPrime = new boolean[(int) arrayRowSize][Integer.MAX_VALUE];
		Arrays.fill(isPrime, Boolean.TRUE);
		isPrime[0][0] = false; // 1 is neither prime nor composite
		for (double i = 0; i < arrayRowSize; i++) {
			for (double j = 0; j < Integer.MAX_VALUE; j++) {
				double factor = (i * Integer.MAX_VALUE) + (j + 1);
				for (double k = i; k < arrayRowSize; k++) {
					for (double l = 0; l < Integer.MAX_VALUE; l++) {
						double num = (k * Integer.MAX_VALUE) + (l + 1);
						if ((num <= N) && isPrime[(int) k][(int) l] && (num % factor == 0)) {
							isPrime[(int) k][(int) l] = false;
						}
					}
				}
			}
		}
		double maxFactor = 1;
		for (double i = 0; i < arrayRowSize; i++) {
			for (double j = 0; j < Integer.MAX_VALUE; j++) {
				double num = (i * Integer.MAX_VALUE) + (j + 1);
				if (num < N) {
					if (N % num == 0) {
						if (num > maxFactor)
							maxFactor = num;
					}
				}
			}
		}
	}
}
