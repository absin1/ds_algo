public class Solution {

	public static void main(String[] args) {

		for (int input = 0; input < 8; input++) {

			boolean[] bits = new boolean[3];
			for (int i = 2; i >= 0; i--) {
				bits[i] = (input & (1 << i)) != 0;
			}

			System.out.print(input + " = ");
			for (boolean b : bits) {
				if (b)
					System.out.print("1 ");
				else
					System.out.print("0 ");

			}
			System.out.println();

		}
	}
}
