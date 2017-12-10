package binaySearchTree;

import java.util.Collections;
import java.util.HashSet;

public class BSTMethods {

	public static void main(String[] args) {
		/*
		 * Node _2 = createSngleBST(2, 1, 3); Node _6 = createSngleBST(6, 5, 7);
		 * Node root = new Node(); root.left = _2; root.right = _6; root.data =
		 * 4;
		 */
		Node right = createSngleBST(20, 10, 30);
		Node root = createSngleBST(18, 8, 20);
		root.right = right;
		System.err.println(checkBST(root));

	}

	public static boolean checkBST(Node root) {
		Integer result = 0;
		result = comparatorzz(root, result);
		HashSet<Integer> unique = new HashSet<>();
		result = checkUnique(root, unique, result);
		unique = new HashSet<>();
		result = checkLeftLess(root, unique, result);
		unique = new HashSet<>();
		result = checkRightMore(root, unique, result);
		if (result == 0) {
			return true;
		} else {
			return false;
		}
	}

	private static Integer checkLeftLess(Node root, HashSet<Integer> unique, Integer result) {
		if (root == null) {
			return result;
		}
		unique.add(root.data);
		result = checkLeftLess(root.left, unique, result);
		if (Collections.max(unique) > root.data) {
			return ++result;
		}
		return result;
	}

	private static Integer checkRightMore(Node root, HashSet<Integer> unique, Integer result) {
		if (root == null) {
			return result;
		}
		unique.add(root.data);
		result = checkRightMore(root.right, unique, result);
		if (Collections.min(unique) < root.data) {
			return ++result;
		}
		return result;
	}

	private static Integer checkUnique(Node root, HashSet<Integer> unique, Integer result) {
		if (root == null) {
			return result;
		}
		if (!unique.add(root.data)) {
			return ++result;
		}
		result = checkUnique(root.left, unique, result);
		result = checkUnique(root.right, unique, result);
		return result;
	}

	private static int comparatorzz(Node root, Integer result) {
		if (root == null || root.right == null || root.left == null) {
			return result;
		}
		if ((root.right.data <= root.left.data) || (root.data <= root.left.data) || (root.data >= root.right.data)) {
			return ++result;
		}
		result += comparatorzz(root.left, result);
		result += comparatorzz(root.right, result);
		return result;
	}

	public static Node createLeftLinkBST(int root, Node left, int right) {
		Node node3 = new Node(); // right
		node3.data = right;
		node3.left = null;
		node3.right = null;
		Node node1 = new Node(); // root
		node1.data = root;
		node1.left = left;
		node1.right = node3;
		return node1;
	}

	public static Node createSngleBST(int root, int left, int right) {
		Node node2 = new Node(); // left
		node2.data = left;
		node2.left = null;
		node2.right = null;
		Node node3 = new Node(); // right
		node3.data = right;
		node3.left = null;
		node3.right = null;
		Node node1 = new Node(); // root
		node1.data = root;
		node1.left = node2;
		node1.right = node3;
		return node1;
	}

	public static Node createDoubleBST() {
		Node _2 = createSngleBST(2, 4, 5);
		Node _1 = createLeftLinkBST(1, _2, 3);
		return _1;
	}
	
	
	/*
private static Integer checkLeftLess(Node root, HashSet<Integer> unique, Integer result) {
		if (root == null) {
			return result;
		}
		result = checkUnique(root.left, unique, result);
		if (Collections.max(unique) > root.data) {
			return ++result;
		}
		return result;
	}

	private static Integer checkRightMore(Node root, HashSet<Integer> unique, Integer result) {
		if (root == null) {
			return result;
		}
		result = checkUnique(root.right, unique, result);
		if (Collections.min(unique) < root.data) {
			return ++result;
		}
		return result;
	}
	 

	 */

}
