package linkedList;

public class intLinkedList {
	int data;
	intLinkedList next;

	public void push(int val, intLinkedList root) {
		intLinkedList last;
		last = root;
		while (last != null) {
			last = last.next;
		}
		intLinkedList node = new intLinkedList();
		node.data = val;
		last = node;
	}
}
