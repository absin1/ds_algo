package problems;

import java.util.HashMap;

public class AnagramsTogether {
	/*
	 * Given an array of words, print all anagrams together. For example, if the
	 * given array is {"cat", "dog", "tac", "god", "act"}, then output may be
	 * "cat tac act dog god".
	 */
	public static void main(String[] args) {
		String[] words = { "cat", "dog", "tac", "god", "act" };
		printAnagramsTogether(words);
		System.exit(0);
	}

	public static void printAnagramsTogether(String[] words) {
		String arr[] = new String[words.length];
		// Insert the words into this but before doing that arrange their
		// characters in ascending
		for (int i = 0; i < words.length; i++) {
			arr[i] = arrangeCharactersAscending(words[i]);
		}
		HashMap<String, Integer> wordMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (wordMap.get(words[i]) != null)
				wordMap.put(words[i], wordMap.get(words[i]) + 1);
			else
				wordMap.put(words[i], 1);
		}
		for (String string : wordMap.keySet()) {
			for (int i = 0; i < wordMap.get(string); i++) {
				System.out.println(string);
			}
		}
	}

	private static String arrangeCharactersAscending(String string) {
		String ret = "";
		HashMap<Character, Integer> characters = getEmptyCharacterHash();
		for (char ch : string.toCharArray()) {
			characters.put(ch, characters.get(ch) + 1);
		}
		for (Character c : characters.keySet()) {
			for (int i = 0; i < characters.get(c); i++) {
				ret += c;
			}
		}
		return ret;
	}

	private static HashMap<Character, Integer> getEmptyCharacterHash() {
		HashMap<Character, Integer> charMap = new HashMap<>();
		for (char x = 'a'; x <= 'z'; x++) {
			charMap.put(x, 0);
		}
		return charMap;
	}
}
