package binaySearchTree;

public class CheckNodeSumofLeftRight {
	static int faultyNodeCount = 0;

	public static void main(String args[]) {
		Node l = CreateBST.createSngleBST(1, 3, 2);
		Node r = CreateBST.createSngleBST(1, 4, 3);
		Node root = CreateBST.createBiBST(l, 7, r);
		check(root);
		if (faultyNodeCount == 0) {
			System.out.println("All nodes are sum of left and right");
		} else
			System.err.println(faultyNodeCount + " nodes is/are not sum of left and right");
	}

	private static void check(Node node) {
		if (node == null || node.left == null)
			return;
		if (node.left.left != null) {
			check(node.left);
			check(node.right);
		}
		if (!((node.left.data + node.right.data) == node.data))
			faultyNodeCount += 1;
	}
}
