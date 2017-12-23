package thirtydaysofcode;

import java.util.Scanner;

public class Solution15 {

	// Linked Lists
	/*
	 * Sample Input 4 2 3 4 1 Sample Output 2 3 4 1
	 */
	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();

		while (N-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		display(head);
		sc.close();
	}

	public static Node insert(Node head, int data) {
		// Complete this method
		if (head == null)
			return new Node(data);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data);
		return head;
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}