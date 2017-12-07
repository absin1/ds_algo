import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicketSeller {
	public static void main(String[] args) {
		// verboseSingleIteration();
		// timeInefficient();
		timeEfficientMemoryHeavy();
	}

	private static void timeEfficientMemoryHeavy() {
		List<Integer> maxEarnings = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int iterations = scanner.nextInt();
		for (int j = 0; j < iterations; j++) {
			int maxEarning = 0;
			int maxTickets = 0;
			int[] auxArray = new int[100001];
			int N = scanner.nextInt();
			int T = scanner.nextInt();
			for (int i = 0; i < N; i++) {
				int numberofTickets = scanner.nextInt();
				auxArray[numberofTickets - 1] = auxArray[numberofTickets - 1] + 1;
				if ((numberofTickets - 1) > maxTickets) {
					maxTickets = numberofTickets - 1;
				}
			}
			for (int i = 0; i < T; i++) {
				maxEarning = maxEarning + maxTickets + 1;
				auxArray[maxTickets] = auxArray[maxTickets] - 1;
				if (maxTickets > 0)
					auxArray[maxTickets - 1] = auxArray[maxTickets - 1] + 1;
				if (auxArray[maxTickets] == 0) {
					int tempMaxTickets = 0;
					for (int k = 0; k < maxTickets; k++) {
						if (auxArray[k] > 0) {
							tempMaxTickets = k;
						}
					}
					maxTickets = tempMaxTickets;
				}
			}
			maxEarnings.add(maxEarning);
		}
		scanner.close();
		for (Integer integer : maxEarnings) {
			System.out.println(integer);
		}
	}

	private static void timeInefficient() {
		List<Integer> maxEarnings = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int iterations = scanner.nextInt();
		for (int j = 0; j < iterations; j++) {
			int maxEarning = 0;
			int N = scanner.nextInt();
			int T = scanner.nextInt();
			List<Integer> distAsList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				distAsList.add(scanner.nextInt());
			}
			for (int i = 0; i < T; i++) {
				Integer max = Collections.max(distAsList);
				distAsList.remove(max);
				distAsList.add(max - 1);
				maxEarning = maxEarning + max;
			}
			maxEarnings.add(maxEarning);
		}
		scanner.close();
		for (Integer integer : maxEarnings) {
			System.out.println(integer);
		}
	}

	private static void verboseSingleIteration() {
		int maxEarning = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of ticket sellers: ");
		int N = scanner.nextInt();
		System.out.print("Enter the number of tickets to be sold in total: ");
		int T = scanner.nextInt();
		System.out.println("Thank you! You have said that there are " + N
				+ " ticket sellers and they want to sell a total of " + T + " tickets.");
		int[] dist = new int[N];
		for (int i = 0; i < N; i++) {
			System.out.print("Now enter the number of tickets with ticket vendor " + (i + 1) + ": ");
			dist[i] = scanner.nextInt();
		}
		scanner.close();
		List<Integer> distAsList = new ArrayList<>();
		for (int index = 0; index < dist.length; index++) {
			distAsList.add(dist[index]);
		}
		for (int i = 0; i < T; i++) {
			Integer max = Collections.max(distAsList);
			distAsList.remove(max);
			distAsList.add(max - 1);
			maxEarning = maxEarning + max;
		}
		System.err.println(maxEarning);
	}
}
