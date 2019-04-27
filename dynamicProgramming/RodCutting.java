package dynamicProgramming;

public class RodCutting {
	// Given a rod of length n inches and an array of prices that contains
	// prices of all pieces of size smaller than n. Determine the maximum value
	// obtainable by cutting up the rod and selling the pieces.
	/*
	 * A naive solution for this problem is to generate all configurations of
	 * different pieces and find the highest priced configuration. This solution
	 * is exponential in term of time complexity. Let us see how this problem
	 * possesses both important properties of a Dynamic Programming (DP) Problem
	 * and can efficiently solved using Dynamic Programming.
	 * 
	 * 1) Optimal Substructure: We can get the best price by making a cut at
	 * different positions and comparing the values obtained after a cut. We can
	 * recursively call the same function for a piece obtained after a cut.
	 * 
	 * Let cutRoad(n) be the required (best possible price) value for a rod of
	 * lenght n. cutRod(n) can be written as following.
	 * 
	 * cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
	 * 
	 * 2) Overlapping Subproblems Following is simple recursive implementation
	 * of the Rod Cutting problem. The implementation simply follows the
	 * recursive structure mentioned above.
	 */

	public static void main(String[] args) {
		int[] a = { 1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println("The max price possible is: " + cutRodInefficient(a, a.length));
		System.out.println("The max price possible is: " + cutRodEfficient(a, a.length));
	}

	public static int cutRodEfficient(int[] a, int length) {
		int[] val = new int[length + 1];
		val[0] = 0;
		int i, j;
		for (i = 1; i <= length; i++) {
			int maxValue = Integer.MIN_VALUE;
			for (j = 0; j < i; j++) {
				maxValue = max(maxValue, a[j] + val[i - j - 1]);
			}
			val[i] = maxValue;
		}
		return val[length];
	}

	public static int cutRodInefficient(int[] a, int length) {
		if (length <= 0)
			return 0;
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < length; i++) {
			maxValue = max(maxValue, a[i] + cutRodInefficient(a, length - i - 1));
		}
		return maxValue;
	}

	private static int max(int maxValue, int i) {
		if (maxValue > i)
			return maxValue;
		else
			return i;
	}
}
