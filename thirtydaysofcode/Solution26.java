package thirtydaysofcode;

import java.util.Scanner;

public class Solution26 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int day2 = scanner.nextInt();
		int month2 = scanner.nextInt();
		int year2 = scanner.nextInt();
		int day1 = scanner.nextInt();
		int month1 = scanner.nextInt();
		int year1 = scanner.nextInt();

		scanner.close();
		int fine;
		if (year2 <= year1) {
			if (year2 == year1) {
				if (month2 <= month1) {
					if (month2 == month1) {
						fine = 15 * (day2 - day1);
					} else {
						fine = 0;
					}
				} else {
					fine = 500 * (month2 - month1);
				}
			} else {
				fine = 0;
			}
		} else {
			fine = 10000;
		}
		System.out.println(fine);
	}
}
