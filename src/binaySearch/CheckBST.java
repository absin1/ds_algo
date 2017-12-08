package binaySearch;

import java.util.HashSet;

public class CheckBST {
	public static void main(String[] args) {
		Node l = CreateBST.createSngleBST(1, 2, 3);
		Node r = CreateBST.createSngleBST(5, 6, 7);
		Node root = CreateBST.createBiBST(l, 4, r);
		if (checkBST(root)) {
			System.out.println("Yes");
		} else {
			System.err.println("No");
		}
		/*System.out.println(minValue(root.right));
		System.out.println(minValue(root.left));
		System.out.println(maxValue(root.right));
		System.out.println(maxValue(root.left));*/
	}

	private static boolean checkBST(Node root) {
		HashSet<Integer> unique = new HashSet<>();
		if (!isBST(root) || !checkUnique(root, unique)) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkUnique(Node root, HashSet<Integer> unique) {
		if (root == null) {
			return true;
		}
		if (!unique.add(root.data)) {
			return false;
		}
		boolean result = checkUnique(root.left, unique);
		result = checkUnique(root.right, unique);
		return result;
	}

	private static boolean isBST(Node node) {
		if (node == null)
			return true;
		if (node.left != null && maxValue(node.left) > node.data)
			return false;
		if (node.right != null && minValue(node.right) < node.data)
			return false;
		if (!isBST(node.left) || !isBST(node.right))
			return false;
		return true;
	}

	private static int minValue(Node node) {
		if (node == null)
			return Integer.MAX_VALUE;
		int data = node.data;
		int lminValue = minValue(node.left);
		int rminValue = minValue(node.right);
		if (lminValue < data)
			data = lminValue;
		if (rminValue < data)
			data = rminValue;
		return data;
	}

	private static int maxValue(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int data = node.data;
		int rmaxValue = maxValue(node.right);
		int lmaxValue = maxValue(node.left);
		if (data < lmaxValue)
			data = lmaxValue;
		if (data < rmaxValue)
			data = rmaxValue;
		return data;
	}
}
