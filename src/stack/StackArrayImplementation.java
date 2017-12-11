package stack;

public class StackArrayImplementation {
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX];

	public StackArrayImplementation() {
		top = -1;
	}

	boolean isEmpty() {
		return (top < 0);
	}

	boolean push(int data) {
		if (top >= 1000) {
			System.out.println("Stack Overflow");
			return false;
		} else {
			a[++top] = data;
			return true;
		}
	}

	int pop() {
		if (top < 0) {
			System.err.println("Stack Underflow");
			return 0;
		} else {
			return (a[top--]);
		}
	}

	public static void main(String args[]) {
		StackArrayImplementation s = new StackArrayImplementation();
		System.out.println(s.pop());
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
	}
}
