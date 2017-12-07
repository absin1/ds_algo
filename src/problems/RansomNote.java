package problems;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RansomNote {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
		}
		// memoryHeavy(n, magazine, ransom);
		HashMap<String, Integer> ran = new HashMap<>();
		for (String string : ransom) {
			if (ran.containsKey(string)) {
				Integer integer = ran.get(string);
				ran.put(string, (integer + 1));
			} else {
				ran.put(string, 1);
			}
		}
		List<String> magazineAsList = Arrays.asList(magazine);

	}

	private static void memoryHeavy(int n, String[] magazine, String[] ransom) {
		HashMap<String, Integer> ran = new HashMap<>();
		HashMap<String, Integer> mag = new HashMap<>();
		for (String string : ransom) {
			if (ran.containsKey(string)) {
				Integer integer = ran.get(string);
				ran.put(string, (integer + 1));
			} else {
				ran.put(string, 1);
			}
		}
		for (String string : magazine) {
			if (mag.containsKey(string)) {
				Integer integer = mag.get(string);
				mag.put(string, (integer + 1));
			} else {
				mag.put(string, 1);
			}
		}
		int size = 0;
		for (String string : ran.keySet()) {
			for (String string1 : mag.keySet()) {
				if (string.equals(string1)) {
					if (mag.get(string) >= ran.get(string)) {
						size = size + ran.get(string);
					}
				}
			}
		}
		if (size == n) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}
