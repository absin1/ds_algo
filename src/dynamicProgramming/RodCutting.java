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
}
