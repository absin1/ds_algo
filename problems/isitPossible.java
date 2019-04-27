package problems;

import java.util.*;

import javafx.util.Pair;


public class isitPossible {
	public static void main(String[] args) {
		int a = 1;
		int b = 4;
		int c = 5;
		int d = 9;
		System.out.println(isPossible(a, b, c, d));
	}

	public static LinkedList<AbstractMap.SimpleEntry<Integer, Integer>> lePossibles = new LinkedList<AbstractMap.SimpleEntry<Integer, Integer>>();
	static String isPossible(Integer a, Integer b, Integer c, Integer d) {
		AbstractMap.SimpleEntry<Integer, Integer> entry 
		  = new AbstractMap.SimpleEntry<>(a, b);
		lePossibles.addLast(entry);
		while (!lePossibles.isEmpty()) {
			AbstractMap.SimpleEntry<Integer, Integer> pair = lePossibles.poll();
			Integer first = pair.getKey();
			Integer second = pair.getValue();
			if (first.equals(c) && second.equals(d)) {
				return "Yes";
			}
			int sum = first + second;
			if (sum <= d) {
				lePossibles.addLast(new AbstractMap.SimpleEntry<Integer, Integer>(first, sum));
			}
			if (sum <= c) {
				lePossibles.addLast(new AbstractMap.SimpleEntry<Integer, Integer>(sum, second));
			}
		}
		return "No";
	}
}
