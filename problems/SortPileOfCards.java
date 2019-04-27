package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortPileOfCards {
	// We have N cards with each card numbered from 1 to N. All cards are
	// randomly shuffled. We are allowed only operation moveCard(n) which moves
	// the card with value n to the top of the pile. You are required to find
	// out the minimum number of moveCard() operations required to sort the
	// cards in increasing order.
	// https://practice.geeksforgeeks.org/problems/sort-the-pile-of-cards/0
	public static void main(String[] args) {
		// failed();
		Scanner scanner = new Scanner(System.in);
		List<Integer> movess = new ArrayList<>();
		int T = scanner.nextInt();
		for (int x = 0; x < T; x++) {
			int N = scanner.nextInt();
			int[] cards = new int[N];
			for (int i = 0; i < N; i++) {
				cards[i] = scanner.nextInt();
			}
			int[] cardss = cards;
			int count = 0;
			while (biggestHasSmallerOnRight(cardss)) {
				cardss = takeBiggestRightToBiggestToTop(cardss);
				++count;
			}
			while (smallestHasElementsToLeft(cardss)) {
				cardss = takeSmallestToTop(cardss);
				++count;
			}
			movess.add(count);
		}
		scanner.close();
		for (int i : movess) {
			System.out.println(i);
		}
	}

	private static int[] takeSmallestToTop(int[] cardss) {
		int minIndex = 0;
		for (int i = 0; i < cardss.length; i++) {
			if (cardss[i] < cardss[minIndex]) {
				minIndex = i;
			}
		}
		cardss = takeToTop(cardss, minIndex);
		return cardss;
	}

	private static boolean smallestHasElementsToLeft(int[] cardss) {
		int minIndex = 0;
		for (int i = 0; i < cardss.length; i++) {
			if (cardss[i] < cardss[minIndex]) {
				minIndex = i;
			}
		}
		if (minIndex == 0) {
			return false;
		} else {
			return true;
		}
	}

	private static int[] takeBiggestRightToBiggestToTop(int[] cardss) {
		int maxIndex = 0;
		for (int i = 1; i < cardss.length; i++) {
			if (cardss[i] > cardss[maxIndex]) {
				maxIndex = i;
			}
		}
		int nextMaxIndex = maxIndex + 1;
		for (int i = nextMaxIndex; i < cardss.length; i++) {
			if (cardss[i] > cardss[nextMaxIndex]) {
				nextMaxIndex = i;
			}
		}
		cardss = takeToTop(cardss, nextMaxIndex);
		return cardss;
	}

	private static int[] takeToTop(int[] cardss, int nextMaxIndex) {
		int[] cards = new int[cardss.length];
		cards[0] = cardss[nextMaxIndex];
		int j = 1;
		for (int i = 0; i < cardss.length; i++) {
			if (i != nextMaxIndex) {
				cards[j++] = cardss[i];
			}
		}
		return cards;
	}

	private static boolean biggestHasSmallerOnRight(int[] cardss) {
		Boolean biggestHasSmallerOnRight = false;
		int maxIndex = 0;
		for (int i = 1; i < cardss.length; i++) {
			if (cardss[i] > cardss[maxIndex]) {
				maxIndex = i;
			}
		}
		if (maxIndex < (cardss.length-1))
			biggestHasSmallerOnRight = true;
		return biggestHasSmallerOnRight;
	}

}
