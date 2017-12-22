package linkedList;

public class IntLinkedList {
	Node root;

	public IntLinkedList(int data) {
		Node node = new Node(data);
		this.root = node;
	}

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(int val) {
		Node node = new Node(val);
		Node r = root;
		while (r.next != null)
			r = r.next;
		r.next = node;
	}

	public void print() {
		Node temp = this.root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
