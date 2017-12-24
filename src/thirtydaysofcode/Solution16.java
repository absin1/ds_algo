package thirtydaysofcode;

import java.util.Scanner;

public class Solution16 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		Integer i = null;
		try {
			i = Integer.parseInt(S);
			System.out.println(i);
		} catch (Exception e) {
			System.out.println("Bad String");
		}
	}
}
