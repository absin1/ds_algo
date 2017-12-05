import java.util.Scanner;

public class LeftArrayRotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		in.close();
		// The array a[n] has to be rotated d times
		for(int a_i = 0; a_i< d; a_i++){
			int temp = a[0];
			for(int i=0; i<n-1; i++){
				a[i] = a[i+1];
			}
			a[n-1] = temp;
		}
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
}
