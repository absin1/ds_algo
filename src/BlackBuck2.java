import java.util.Scanner;

public class BlackBuck2 {
	public static void main(String args[]) {
		Scanner scannner = new Scanner(System.in);
		int T = scannner.nextInt();
		scannner.nextLine();
		String[] lines = new String[T];
		for (int i = 0; i < lines.length; i++) {
			lines[i] = scannner.nextLine();
		}
		for (int i = 0; i < lines.length; i++) {
			int maxMove = 0;
			int clockCount = 0;
			int antiClockCount = 0;
			int noIdeaCount = 0;
			char[] charArray = lines[i].toCharArray();

			for (int j = 0; j < charArray.length; j++) {
				if (charArray[j] == '?') {
					int findMaxMove = findMaxMove(charArray, j);
					if (findMaxMove > maxMove) {
						maxMove = findMaxMove;
					}
				}
			}
			System.out.println(maxMove);
		}
	}

	private static int findMaxMove(char[] charArray, int j2) {
		int clockCount = 0;
		int antiClockCount = 0;
		int noIdeaCount = 0;
		
		for (int j = 0; j < j2; j++) {
			switch (charArray[j]) {
			case 'A':
				antiClockCount++;
				break;
			case 'C':
				clockCount++;
				break;
			case '?':
				noIdeaCount++;
				break;
			default:
				break;
			}
		}
		return Math.abs(antiClockCount - clockCount) + noIdeaCount;
	}

}
