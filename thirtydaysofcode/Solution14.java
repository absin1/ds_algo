package thirtydaysofcode;

import java.util.Scanner;

public class Solution14 {

	// Sample Input
	// 3
	// 1 2 5
	// Sample Output
	// 4
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		Difference difference = new Difference(a);
		difference.computeDifference();
		System.out.print(difference.maximumDifference);
	}
}

class Difference {
	private int[] elements;
	public int maximumDifference;

	public Difference(int arr[]) {
		this.elements = arr;
	}

	public void computeDifference() {
		this.maximumDifference = Integer.MIN_VALUE;
		for (int i = 0; i < this.elements.length; i++) {
			for (int j = i; j < this.elements.length; j++) {
				if (Math.abs((double) this.elements[i] - this.elements[j]) > this.maximumDifference) {
					this.maximumDifference = (int) Math.abs((double) this.elements[i] - this.elements[j]);
				}
			}
		}
	}
}