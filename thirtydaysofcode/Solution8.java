package thirtydaysofcode;

import java.util.HashMap;
import java.util.Scanner;

public class Solution8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		scanner.nextLine();
		HashMap<String, Integer> phoneBook = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String name = scanner.next();
			int phone = scanner.nextInt();
			scanner.nextLine();
			phoneBook.put(name, phone);
		}
		while (scanner.hasNext()) {
			String query = scanner.nextLine();
			if (phoneBook.containsKey(query))
				System.out.println(query + "=" + phoneBook.get(query));
			else
				System.out.println("Not found");
		}
		scanner.close();
	}
}
