package linkedList;

import linkedList.IntLinkedList.Node;

public class ReverseLinkedList {
	public static void main(String[] args) {
		IntLinkedList list = new IntLinkedList(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		// IntLinkedList reversed = getReversedLinkedList(list.root);
		IntLinkedList reversed = getReversedLinkedListOptimized(list.root);
		while (reversed.root != null) {
			System.out.println(reversed.root.data);
			reversed.root = reversed.root.next;
		}
	}

	private static IntLinkedList getReversedLinkedListOptimized(Node root) {
		// https://www.geeksforgeeks.org/reverse-a-linked-list/
		Node previous = null;
		Node temp = root;
		Node next = null;
		while (temp != null) {
			next = temp.next;
			temp.next = previous;
			previous = temp;
			temp = next;
		}
		IntLinkedList intLinkedList = new IntLinkedList();
		intLinkedList.root = previous;
		return intLinkedList;
	}

	private static IntLinkedList getReversedLinkedList(Node root) {
		/*
		 * The algo: Measure the size of the lined list. Traverse the list as
		 * many times as the size starting from the end and keep adding nodes to
		 * the new linkedlist. Time: n{for measuring size} + n(n+1){for adding
		 * the nodes O(n2}
		 */
		IntLinkedList reversed = new IntLinkedList();
		int sizeofLinkedList = getSizeofLinkedList(root);
		for (int i = sizeofLinkedList; i > 0; i--) {
			Node temp = root;
			for (int j = 1; j < i; j++) {
				temp = temp.next;
			}
			reversed.push(temp.data);
		}
		return reversed;
	}

	private static int getSizeofLinkedList(Node root) {
		int size = 0;
		while (root != null) {
			size++;
			root = root.next;
		}
		return size;
	}
}
