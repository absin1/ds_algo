package binaySearch;

public class TraverseBST {

	public static void main(String[] args) {
		// Node root = createSngleBST(1, 2, 3);
		Node l = CreateBST.createSngleBST(1, 2, 3);
		Node r = CreateBST.createSngleBST(5, 6, 7);
		Node root = CreateBST.createBiBST(l, 4, r);
		depthPostorder(root);
		breadthTraversal(root);
	}

	public static void breadthTraversal(Node root) {
		int height = getBinaryTreeHeight(root);
		for (int i = 0; i < height; i++) {
			printGivenLevel(root, i);
		}
	}

	public static int getBinaryTreeHeight(Node root) {
		if (root == null)
			return 0;
		else {
			int lheight = getBinaryTreeHeight(root.left);
			int rheight = getBinaryTreeHeight(root.right);
			if (lheight > rheight)
				return lheight + 1;
			else
				return rheight + 1;
		}
	}

	private static void printGivenLevel(Node root, int level) {
		if (root == null)
			return;
		if (level == 1) {
			System.out.println(root.data);
		} else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void depthInorder(Node root) {
		// Inorder depth first traversal goes left-root-right
		if (root == null)
			return;
		depthInorder(root.left);
		depthInorder(root.right);
		System.out.println(root.data);
	}

	public static void depthPreorder(Node root) {
		// Preorder depth first traversal goes root-left-right
		if (root == null)
			return;
		System.out.println(root.data);
		depthPreorder(root.left);
		depthPreorder(root.right);
	}

	public static void depthPostorder(Node root) {
		// Postorder depth first traversal goes from left-right-root
		if (root == null)
			return;
		depthPostorder(root.left);
		depthPostorder(root.right);
		System.out.println(root.data);
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
}
