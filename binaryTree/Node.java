package binaryTree;

public class Node {
	char data;
	Node left;
	Node right;

	Node(char item) {
		data = item;
		left = right = null;
	}

	
	public static void printPreOrder(Node root) {
		// Preorder depth first traversal goes root-left-right
		if (root == null)
			return;
		System.out.println(root.data);
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public static void printInOrder(Node root) {
		// Inorder depth first traversal goes left-root-right
		if (root == null)
			return;
		printInOrder(root.left);
		System.out.print(root.data+" ");
		printInOrder(root.right);
	}
}
