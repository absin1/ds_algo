/**
 * 
 */
package projectEuler;

import java.util.Arrays;
import java.util.HashSet;

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
		squareRootandPrimeStatusCapitalization(N);
		// squareRootPrincipleCapitalization(N);
		// bruteForcing(N);
	}

	private static void squareRootandPrimeStatusCapitalization(Double N) {
		/*
		 * Even with square root capitalization we observe that we are having to
		 * check the primability again and again. This can be ghastly
		 * time-taking. Let's use a collection to manage the prime status.
		 */
		HashSet<Double> primes = new HashSet<>();
		double maxPrimeDivisor = 1;
		for (double i = 2; i <= Math.floor((Math.sqrt(N))); i++) {
			if (N % i == 0) // it is a divisor
			{
				double firstFactor = i;
				double secondFactor = N / i;
				if (primes.contains(firstFactor)) {
					if (firstFactor > maxPrimeDivisor) {
						maxPrimeDivisor = firstFactor;
					}
				} else {
					if (isPrime(firstFactor)) { // The first factor
						primes.add(firstFactor);
						if (firstFactor > maxPrimeDivisor) {
							maxPrimeDivisor = firstFactor;
						}
					}
				}
				if (primes.contains(secondFactor)) {
					if (secondFactor > maxPrimeDivisor) {
						maxPrimeDivisor = secondFactor;
					}
				} else {

					if (isPrime(secondFactor)) { // The associated pair
						if (secondFactor > maxPrimeDivisor) {
							maxPrimeDivisor = secondFactor;
						}
					}
				}
			}
		}
		System.out.println(maxPrimeDivisor);
	}

	private static void squareRootPrincipleCapitalization(Double N) {
		/*
		 * Lets take 20, now the factors are 2, 5 and 10. So if we go till say 4
		 * (which is the floor of the square root of 20, we can find all the
		 * pairs. Let's capitalize on this pattern.
		 */
		double maxPrimeDivisor = 1;
		for (double i = 2; i <= Math.floor((Math.sqrt(N))); i++) {
			if (N % i == 0) // it is a divisor
			{
				double firstFactor = i;
				double secondFactor = N / i;
				if (isPrime(firstFactor)) { // The first factor
					if (firstFactor > maxPrimeDivisor) {
						maxPrimeDivisor = firstFactor;
					}
				}
				if (isPrime(secondFactor)) { // The associated pair
					if (secondFactor > maxPrimeDivisor) {
						maxPrimeDivisor = secondFactor;
					}
				}
			}
		}
		System.out.println(maxPrimeDivisor);
	}

	private static void bruteForcing(Double N) {
		/*
		 * This may take forever depending on your system, I don't have that
		 * long!!
		 */
		double maxPrimeDivisor = 1;
		for (double i = 2; i < N; i++) {
			if (N % i == 0) // it is a divisor
			{
				if (isPrime(i)) {
					if (i > maxPrimeDivisor) {
						maxPrimeDivisor = i;
					}
				}
			}
		}
	}

	private static boolean isPrime(double N) {
		boolean boo = true;
		for (double i = 2; i < N; i++) {
			if (N % i == 0) {
				boo = false;
				break;
			}
		}
		return boo;
	}

}
