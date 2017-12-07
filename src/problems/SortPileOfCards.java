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
		Scanner scanner = new Scanner(System.in);
		List<Integer> movess = new ArrayList<>();
		int T = scanner.nextInt();
		for (int x = 0; x < T; x++) {
			int N = scanner.nextInt();
			int[] cards = new int[N];
			for (int i = 0; i < N; i++) {
				cards[i] = scanner.nextInt();
			}
			movess.add(findNumberofMoves(cards, N, 0));
		}
		scanner.close();
		for (int i : movess) {
			System.out.println(i);
		}
	}

	private static int findNumberofMoves(int[] cards, int n, int count) {
		int maxIndex = 0;
		for (int i = 0; i < n; i++) {
			if (cards[i] > cards[maxIndex]) {
				maxIndex = i;
			}
		}
		if (maxIndex == 0) {
			return count + n - 1;
		} else {
			count = count + n - maxIndex - 1;
			return findNumberofMoves(cards, maxIndex, count);
		}
	}

}
