package sorting;

public class Bubble {
	public static void main(String[] args) {
		// withoutSwapCheck();
		withoutSwapCheck();
	}

	private static void withoutSwapCheck() {
		int[] input = { 64, 25, 12, 22, 11 };
		int length = input.length;
		for (int j = 0; j < length; j++) {
			for (int i = 0; i < length - j - 1; i++) {
				if (input[i] > input[i + 1]) {
					int temp = input[i + 1];
					input[i + 1] = input[i];
					input[i] = temp;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.println(input[i]);
		}
	}

	private static void withSwapCheck() {
		int[] input = { 64, 25, 12, 22, 11 };
		int length = input.length;
		for (int j = 0; j < length; j++) {
			boolean swap = false;
			for (int i = 0; i < length - j - 1; i++) {
				if (input[i] > input[i + 1]) {
					int temp = input[i + 1];
					input[i + 1] = input[i];
					input[i] = temp;
					swap = true;
				}
			}
			if (!swap)
				break;
		}
		for (int i = 0; i < length; i++) {
			System.out.println(input[i]);
		}
	}
}
