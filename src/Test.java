class IntObj {
	int val;

}

public class Test {
	public static void main(String ards[]) {
		IntObj x = new IntObj();
		IntObj y = new IntObj();
		x.val = 5;
		y = x;
		y.val = 8;
		System.out.println(x.val + ">>" + y.val);
	}
}
