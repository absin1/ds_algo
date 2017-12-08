package binaySearch;

public class CreateBST {
	public static Node createSngleBST(int left, int root, int right) {
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

	public static Node createBiBST(Node l, int root, Node r) {
		Node node = new Node(); // root
		node.data = root;
		node.left = l;
		node.right = r;
		return node;
	}
}
