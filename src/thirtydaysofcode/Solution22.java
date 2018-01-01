package thirtydaysofcode;

import java.util.Scanner;

class BSTNode {
	BSTNode left, right;
	int data;

	BSTNode(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Solution22 {

	public static int getHeight(BSTNode root) {
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

	public static BSTNode insert(BSTNode root, int data) {
		if (root == null) {
			return new BSTNode(data);
		} else {
			BSTNode cur;
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
		BSTNode root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}
}
