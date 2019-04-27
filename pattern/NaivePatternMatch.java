package pattern;

public class NaivePatternMatch {
	public static void main(String args[]) {
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";
		naiveSearch(text, pattern);
		System.exit(0);
	}

	// The time complexity of this approach is quote high
	// In best case it can be O(n)
	// But in worst cases it can be O(m*(n-m+1))
	public static void naiveSearch(String text, String pattern) {
		int j;
		for (int i = 0; i <= (text.length() - pattern.length()); i++) {
			for (j = 0; j < pattern.length(); j++) {
				if (text.charAt(i + j) != pattern.charAt(j))
					break;
			}
			if (j == pattern.length())
				System.out.println("Matched at index: " + i);
		}
	}
}
