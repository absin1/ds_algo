package sorting;

public class Selection {
	// The selection sort algorithm sorts an array by repeatedly finding the
	// minimum element (considering ascending order) from unsorted part and
	// putting it at the beginning.
	public static void main(String[] args) {
		int[] input = { 64, 25, 12, 22, 11 };
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
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
}
