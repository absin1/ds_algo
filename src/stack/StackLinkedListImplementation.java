package stack;

public class StackLinkedListImplementation {

	int data;
	StackLinkedListImplementation next;

	StackLinkedListImplementation newNode(int data) {
		StackLinkedListImplementation node = new StackLinkedListImplementation();
		node.data = data;
		node.next = null;
		return node;
	}

	static boolean isEmpty(StackLinkedListImplementation node) {
		return (node == null);
	}

	static StackLinkedListImplementation push(StackLinkedListImplementation root, int data) {
		StackLinkedListImplementation newNode = (new StackLinkedListImplementation()).newNode(data);
		newNode.next = root;
		root = newNode;
		System.out.println(data + " Pushed into stack successfully.");
		return root;
	}

	static int pop(StackLinkedListImplementation root) {
		if (root == null) {
			System.err.println("Underflow error!");
			return Integer.MIN_VALUE;
		} else {
			int ret = root.data;
			root.data = root.next.data;
			root.next = root.next.next;
			return ret;
		}
	}

	static int peek(StackLinkedListImplementation root) {
		if (root != null)
			return root.data;
		else {
			System.err.println("Underflow error!");
			return 0;
		}
	}

	public static void main(String args[]) {
		StackLinkedListImplementation root = new StackLinkedListImplementation();
		root=push(root, 10);
		root=push(root, 20);
		root=push(root, 30);
		System.out.println(pop(root) + " popped from stack");
		System.out.println(pop(root) + " popped from stack");
		System.out.println(peek(root) + " peeked from stack");
		System.exit(0);
	}
}
