package problems;

import java.util.Scanner;

public class PowerofTwo {
	public static void main(String[] args) {
		System.out.print("Enter the number to check if its a power of 2: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		if (checkPowerofTwo(input))
			System.out.println("The number " + input + " is a power of 2.");
		else
			System.err.println("The number " + input + " is not a power of 2.");
	}

	public static boolean checkPowerofTwo(int input) {
		while (input != 1) {
			if ((input % 2) == 0)
				input = input / 2;
			else
				return false;
		}
		return true;
	}
}
