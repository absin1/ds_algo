package problems;

public class Islands {
	private static int ROW = 5;
	private static int COL = 5;

	public static void main(String args[]) {
		int arr[][] = new int[][] { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 0, 1 } };
		System.out.println("The number of islands in this 2D array are: " + countIslands(arr));
		System.exit(0);
	}

	public static int countIslands(int arr[][]) {
		int count = 0;
		boolean isVisited[][] = new boolean[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if ((arr[i][j] == 1) && !isVisited[i][j]) {
					count++;
					visitIslandCells(arr, i, j, isVisited);
				}
			}
		}
		return count;
	}

	private static void visitIslandCells(int arr[][], int i, int j, boolean isVisited[][]) {
		// in-order to traverse prepare a difference matrix
		int[] rowAdd = { 1, 1, 0, -1, -1, -1, 0, 1 };
		int[] colAdd = { 0, 1, 1, 1, 0, -1, -1, -1 };
		isVisited[i][j] = true;
		for (int k = 0; k < 8; k++) {
			if (isSafeToVisit(arr, i + rowAdd[k], j + colAdd[k], isVisited)) {
				visitIslandCells(arr, i + rowAdd[k], j + colAdd[k], isVisited);
			}
		}
	}

	private static boolean isSafeToVisit(int arr[][], int row, int col, boolean isVisited[][]) {
		if (row >= 0)
			if (row < ROW)
				if (col >= 0)
					if (col < COL)
						if (!isVisited[row][col])
							if (arr[row][col] == 1)
								return true;
		return false;
	}
}
