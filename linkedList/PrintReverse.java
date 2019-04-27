package linkedList;

import java.util.ArrayList;
import java.util.Stack;

import linkedList.IntLinkedList.Node;

public class PrintReverse {
	// https://www.geeksforgeeks.org/print-reverse-linked-list-without-extra-space-modifications/
	// Print reverse of a Linked List without extra space and modifications
	// Given a Linked List, display the linked list in reverse without using
	// recursion, stack or modifications to given list.

	// There are 3 method here which are not allowed as part of the solution:
	// 1. Recursive solution to print reverse a linked list. Requires extra
	// space.
	// 2. Reverse linked list and then print. This requires modifications to
	// original list.
	// 3. Stack based solution to print linked list reverse. Push all nodes one
	// by
	// one to a stack. Then one by one pop elements from stack and print. This
	// also requires extra space.

	// Algo of the solution:
	// Find the size of the linkedlist let it be 'N'
	// Run a loop with a counter n from N to 1
	// Keep traversing the linkedlist till you find the nth element and print it
	// Time Complexity of the solution: N(for finding the length of the
	// linkedlist) + N(N+1)/2 for printing the elements backwards which means
	// O(N2) in Big-O Notation
	public static void main(String[] args) {
		IntLinkedList list = new IntLinkedList(1);
		list.push(2);
		list.push(3);
		list.push(4);
		list.push(5);
		// list.print();
		// printReverseRecusion(list.root);
		// printReverseByReversing(list.root);
		printReverseUsingStack(list.root);
		// printReverse(list.root);
	}

	private static void printReverseUsingStack(Node root) {
		Stack<Integer> stack = new Stack<>();
		while (root != null) {
			stack.push(root.data);
			root = root.next;
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private static void printReverseByReversing(Node root) {
		IntLinkedList reversed = getReversedLinkedList(root);
		while (reversed.root != null) {
			System.out.println(reversed.root.data);
			reversed.root = reversed.root.next;
		}
	}

	private static IntLinkedList getReversedLinkedList(Node root) {
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

	private static void printReverseRecusion(Node root) {
		if (root == null)
			return;
		printReverseRecusion(root.next);
		System.out.println(root.data);
	}

	private static void printReverse(Node root) {
		int n = 1;
		Node temp = root;
		while (temp != null) {
			n++;
			temp = temp.next;
		}

		for (int i = n - 2; i >= 0; i--) {
			temp = root;
			for (int j = 0; j < i; j++) {
				temp = temp.next;
			}
			System.out.println(temp.data);
		}
	}
}
