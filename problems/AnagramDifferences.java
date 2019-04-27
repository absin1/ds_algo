package problems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AnagramDifferences {
	static int[] getMinimumDifference(String[] a, String[] b) {
		int[] op = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			HashMap<Character, Integer> f = new HashMap<>();
			HashMap<Character, Integer> s = new HashMap<>();
			for (Character fchar : a[i].toCharArray()) {
				Integer integer = f.get(fchar);
				if (integer == null) {
					f.put(fchar, 1);
				} else {
					f.put(fchar, (integer + 1));
				}
			}
			for (Character schar : b[i].toCharArray()) {
				Integer integer = s.get(schar);
				if (integer == null) {
					s.put(schar, 1);
				} else {
					s.put(schar, (integer + 1));
				}
			}
			// first we remove repeated characters
			Set<Character> keySet = new HashSet<>();
			for (Character character : f.keySet()) {
				keySet.add(character);
			}
			for (Character fch : keySet) {
				Integer integer = f.get(fch);
				Integer integer2 = s.get(fch);
				if (integer != null) {
					if (integer2 != null) {
						if (integer == integer2) {
							// same character same count > remove the key
							f.remove(fch);
							s.remove(fch);
						} else if (integer > integer2) {
							int value = integer - integer2;
							f.remove(fch);
							f.put(fch, value);
							s.remove(fch);
						} else if (integer < integer2) {
							int value = integer2 - integer;
							s.remove(fch);
							s.put(fch, value);
							f.remove(fch);
						}
					}
				}

			}
			int fnetcount = 0;
			int snetcount = 0;
			for (Character fchar : f.keySet()) {
				fnetcount = fnetcount + f.get(fchar);
			}
			for (Character schar : s.keySet()) {
				snetcount = snetcount + s.get(schar);
			}
			if (fnetcount == snetcount) {
				op[i] = fnetcount;
			} else {
				op[i] = -1;
			}
			if (f.keySet().size() == 0) {
				if (s.keySet().size() == 0) {
					op[i] = 0;
				}
			}
			// if what is to be replaced has one counterpart in both and their
			// values of repetitions are same
		}
		return op;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int[] res;
		int a_size = 0;
		a_size = Integer.parseInt(in.nextLine().trim());

		String[] a = new String[a_size];
		for (int i = 0; i < a_size; i++) {
			String a_item;
			try {
				a_item = in.nextLine();
			} catch (Exception e) {
				a_item = null;
			}
			a[i] = a_item;
		}

		int b_size = 0;
		b_size = Integer.parseInt(in.nextLine().trim());

		String[] b = new String[b_size];
		for (int i = 0; i < b_size; i++) {
			String b_item;
			try {
				b_item = in.nextLine();
			} catch (Exception e) {
				b_item = null;
			}
			b[i] = b_item;
		}

		res = getMinimumDifference(a, b);
		for (int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
	}
}
