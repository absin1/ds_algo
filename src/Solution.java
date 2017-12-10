import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double mealCost = scan.nextDouble(); // original meal price
		int tipPercent = scan.nextInt(); // tip percentage
		int taxPercent = scan.nextInt(); // tax percentage
		scan.close();
		double sellingPrice = mealCost * (1.0 + ((float) (tipPercent + taxPercent) / 100));
		// Write your calculation code here.

		// cast the result of the rounding operation to an int and save it as
		// totalCost
		int totalCost = (int) Math.round(sellingPrice);
		System.out.println("The total meal cost is " + totalCost + " dollars.");
		// Print your result
	}
}
