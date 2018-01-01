package thirtydaysofcode;

import java.util.Scanner;

class BSTNode1 {
	BSTNode1 left, right;
	int data;

	BSTNode1(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Solution23 {

	static void levelOrder(BSTNode1 root) {
		int height = getHeight(root);
		for (int i = 0; i <= height; i++) {
			printGivenLevel(root, i);
		}
	}

	public static void printGivenLevel(BSTNode1 root, int height) {
		if (root == null) {
			return;
		} else {
			if (height == 0)
				System.out.print(root.data + " ");
			else {
				printGivenLevel(root.left, height - 1);
				printGivenLevel(root.right, height - 1);
			}
		}
	}

	public static int getHeight(BSTNode1 root) {
		if (root == null)
			return -1;
		else {
			int leftDepth = getHeight(root.left);
			int rightDepth = getHeight(root.right);
			if (leftDepth > rightDepth)
				return leftDepth + 1;
			else
				return rightDepth + 1;
		}
	}

	public static BSTNode1 insert(BSTNode1 root, int data) {
		if (root == null) {
			return new BSTNode1(data);
		} else {
			BSTNode1 cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		BSTNode1 root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		levelOrder(root);
	}
}
