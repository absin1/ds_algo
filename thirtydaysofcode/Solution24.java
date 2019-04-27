package thirtydaysofcode;

import java.util.Scanner;

class LinkedListNode {
	int data;
	LinkedListNode next;

	LinkedListNode(int d) {
		data = d;
		next = null;
	}

}

public class Solution24 {

	public static LinkedListNode removeDuplicates0(LinkedListNode head) {
		if (head == null)
			return head;
		if (head.next == null) {
			return head;
		}
		LinkedListNode temp1 = head;
		LinkedListNode temp2 = null;
		LinkedListNode temp3 = temp1;
		while (temp1 != null) {
			temp2 = temp1.next;
			temp3 = temp1;
			while (temp2 != null) {
				if (temp2.data == temp1.data) {
					temp3.next = temp2.next;
				}
				temp3 = temp2;
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
		}
		return head;
	}

	/**
	 * removeDuplicates() function which takes a list and deletes any duplicate
	 * nodes from the list. The list is not sorted.
	 * 
	 * @param head
	 * @return
	 */
	public static LinkedListNode removeDuplicates(LinkedListNode head) {
		LinkedListNode ptr1 = null, ptr2 = null, dup = null;
		ptr1 = head;

		/* Pick elements one by one */
		while (ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;

			/*
			 * Compare the picked element with rest of the elements
			 */
			while (ptr2.next != null) {

				/* If duplicate then delete it */
				if (ptr1.data == ptr2.next.data) {

					/* sequence of steps is important here */
					dup = ptr2.next;
					ptr2.next = ptr2.next.next;
					System.gc();
				} else /* This is tricky */ {
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}

		return head;
	}

	public static LinkedListNode insert(LinkedListNode head, int data) {
		LinkedListNode p = new LinkedListNode(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			LinkedListNode start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(LinkedListNode head) {
		LinkedListNode start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		LinkedListNode head = null;
		int T = sc.nextInt();
		while (T-- > 0) {
			int ele = sc.nextInt();
			head = insert(head, ele);
		}
		head = removeDuplicates(head);
		display(head);

	}
}
