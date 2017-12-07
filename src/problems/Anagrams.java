package problems;
import java.util.HashMap;
import java.util.HashSet;

public class Anagrams {
	public static int numberNeeded(String first, String second) {
		int result = 0;
		HashMap<Character, Integer> f = new HashMap<>();
		HashMap<Character, Integer> s = new HashMap<>();
		for (Character fchar : first.toCharArray()) {
			Integer integer = f.get(fchar);
			if (integer == null) {
				f.put(fchar, 1);
			} else {
				f.put(fchar, (integer + 1));
			}
		}
		for (Character schar : second.toCharArray()) {
			Integer integer = s.get(schar);
			if (integer == null) {
				s.put(schar, 1);
			} else {
				s.put(schar, (integer + 1));
			}
		}
		HashSet<Character> tobeRemoved = new HashSet<>();
		for (Character fKey : f.keySet()) {
			for (Character sKey : s.keySet()) {
				if (fKey.toString().equals(sKey.toString())) {
					Integer fInteger = f.get(fKey);
					Integer sInteger = s.get(fKey);
					result = result + Math.abs(fInteger - sInteger);
					tobeRemoved.add(fKey);
				}
			}
		}
		for (Character character : tobeRemoved) {
			f.remove(character);
			s.remove(character);
		}
		for (Character iterable_element : f.keySet()) {
			result = result + f.get(iterable_element);
		}
		for (Character iterable_element : s.keySet()) {
			result = result + s.get(iterable_element);
		}
		return result;
	}

	public static void main(String[] args) {
		String a = "cde";
		String b = "abc";
		System.out.println(numberNeeded(a, b));
	}
}
