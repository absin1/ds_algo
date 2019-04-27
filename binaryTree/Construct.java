package binaryTree;

public class Construct {
	static int preIndex = 0;

	public static void main(String args[]) {
		char inorder[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' };
		char preorder[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' };
		Node root = constructTreeFromInPreOrder(inorder, preorder, 0, inorder.length - 1);
		Node.printInOrder(root);
	}

	public static Node constructTreeFromInPreOrder(char[] in, char[] pre, int start, int end) {
		if (start > end)
			return null;
		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		Node node = new Node(pre[preIndex++]);
		/* If this node has no children then return */
		if (start == end)
			return node;
		/* Else find the index of this node in Inorder traversal */
		int inIndex = find(in, start, end, node.data);
		node.left = constructTreeFromInPreOrder(in, pre, start, inIndex - 1);
		node.right = constructTreeFromInPreOrder(in, pre, inIndex + 1, end);
		return node;
	}

	private static int find(char[] in, int start, int end, char data) {
		int i;
		for (i = start; i <= end; i++) {
			if (in[i] == data)
				return i;
		}
		return i;
	}
}
