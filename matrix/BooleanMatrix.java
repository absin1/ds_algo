package matrix;

import java.util.Scanner;

public class BooleanMatrix {
	// Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
	// matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row
	// and jth column as 1.
	public static void main(String args[]) {
		int[][] matrix = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		boolean[] colStatus = new boolean[matrix[0].length];
		boolean[] rowStatus = new boolean[matrix.length];
		makeMatrixBoolean(matrix, rowStatus, colStatus);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

	private static void makeMatrixBoolean(int[][] matrix, boolean[] rowStatus, boolean[] colStatus) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (!rowStatus[i]) {
					if (!colStatus[j]) {
						if (matrix[i][j] == 1) {
							makeRowUnity(matrix, rowStatus, i);
							makeColUnity(matrix, colStatus, j);
						}
					}
				}
			}
		}
	}

	private static void makeColUnity(int[][] matrix, boolean[] colStatus, int j) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][j] = 1;
		}
		colStatus[j] = true;
	}

	private static void makeRowUnity(int[][] matrix, boolean[] rowStatus, int i) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = 1;
		}
		rowStatus[i] = true;
	}
}
