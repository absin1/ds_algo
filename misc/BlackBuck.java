import java.util.*;

public class BlackBuck {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long M = sc.nextLong();
		sc.nextLine();
		// SortedMap<Integer, Integer> idPrice = new TreeMap<>();
		int[] price = new int[N];
		int[] id = new int[N];
		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
			id[i] = sc.nextInt();
			sc.nextLine();
		}
		sc.close();
		sort(price, id);
		int maxTrucks[] = getMaxTrucks(price, id, M);
		sortSingle(maxTrucks);
		if (maxTrucks[maxTrucks.length - 1] == 0)
			System.out.println(-1);
		else {
			for (int i = 0; i < maxTrucks.length; i++) {
				if (maxTrucks[i] != 0) {
					System.out.println(maxTrucks[i]);
				}
			}
		}
	}

	private static void sortSingle(int[] input) {
		int min;
		int minIndex;
		int temp;
		for (int j = 0; j < input.length; j++) {
			min = input[j];
			minIndex = j;
			temp = input[j];
			for (int i = j; i < input.length; i++) {
				if (input[i] < min) {
					min = input[i];
					minIndex = i;
				}
			}
			input[j] = min;
			input[minIndex] = temp;
		}
	}

	private static void sort(int[] input, int[] id) {
		int min;
		int minIndex;
		int temp;
		int minID;
		int tempID;
		for (int j = 0; j < input.length; j++) {
			min = input[j];
			minID = id[j];
			minIndex = j;
			temp = input[j];
			tempID = id[j];
			for (int i = j; i < input.length; i++) {
				if (input[i] < min) {
					min = input[i];
					minIndex = i;
					minID = id[i];
				}
			}
			input[j] = min;
			id[j] = minID;
			input[minIndex] = temp;
			id[minIndex] = tempID;
		}
	}

	private static int[] getMaxTrucks(int[] price, int[] id, long coins) {
		int maxBuy[] = new int[id.length];
		int maxBuyIndex = 0;
		int index = 0;
		while (coins > 0) {
			if (index < price.length) {
				if (id[index] > 0) {
					if (coins > price[index]) {
						maxBuy[maxBuyIndex++] = id[index];
						coins -= price[index];
						id[index] = id[index] - 1;
					} else
						index++;
				} else
					index++;
			} else
				break;
		}
		return maxBuy;
	}

}
