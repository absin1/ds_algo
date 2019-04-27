package thirtydaysofcode;

import java.util.Scanner;

public class Solution10 {
	//524283 >> 16
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int result = maxSimultaneousBinaryOnes(n);
		System.out.println(result);
	}

	private static int maxSimultaneousBinaryOnes(int n) {
		boolean[] binary = getBinary(n);
		int maxTempSimult = 0;
		int[] countContnuous = new int[binary.length];
		for (int i = 0; i < binary.length; i++) {
			if (binary[i]) {
				countContnuous[i] = ++maxTempSimult;
			} else {
				maxTempSimult = 0;
			}
		}
		int maxSimult = 0;
		for (int i = 0; i < countContnuous.length; i++) {
			if (countContnuous[i] > maxSimult) {
				maxSimult = countContnuous[i];
			}
		}
		return maxSimult;
	}

	private static boolean[] getBinary(int n) {
		double digits = 0;
		while (true) {
			if (Math.pow(2, ++digits) > (double) n)
				break;
		}
		boolean[] binary = new boolean[(int) digits];
		for (int i = 0; i < binary.length; i++) {
			if (Math.pow(2, (double) (binary.length - i - 1)) <= n) {
				n = n - (int) Math.pow(2, (double) (binary.length - i - 1));
				binary[i] = true;
			}
		}
		return binary;
	}
}
