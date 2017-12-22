package linkedList;

public class PrintReverse {
	// Print reverse of a Linked List without extra space and modifications
	// Given a Linked List, display the linked list in reverse without using
	// recursion, stack or modifications to given list.
	public static void main(String[] args) {
		IntLinkedList root = new IntLinkedList(1);
		root.push(2);
		root.push(3);
		root.push(4);
		root.push(5);
		root.print();
	}
}
