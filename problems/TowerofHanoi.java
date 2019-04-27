package problems;

import java.util.Scanner;

public class TowerofHanoi {
	static int move = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of disks: ");
		int disks = scanner.nextInt();
		// System.out.print("Enter the number of rods: ");
		// int rods = scanner.nextInt();
		scanner.close();
		char auxRod = 'B';
		char toRod = 'C';
		char fromRod = 'A';
		//tower(disks, fromRod, toRod, auxRod);
		towerWithExtraAux(disks, 'A', 'D', 'B', 'C');
	}

	private static void towerWithExtraAux(int disks, char fromRod, char toRod, char auxRod, char extraAuxRod) {
		if (disks == 0)
			return;
		if (disks == 1) {
			System.out.println(++move + ": Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
			return;
		}
		towerWithExtraAux(disks - 2, fromRod, auxRod, extraAuxRod, toRod);
		System.out.println(++move + ": Move disk " + (disks - 1) + " from rod " + fromRod + " to rod " + extraAuxRod);
		System.out.println(++move + ": Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
		System.out.println(++move + ": Move disk " + (disks - 1) + " from rod " + extraAuxRod + " to rod " + toRod);
		towerWithExtraAux(disks - 2, auxRod, toRod, fromRod, extraAuxRod);

	}

	private static void tower(int disks, char fromRod, char toRod, char auxRod) {
		if (disks == 1) {
			System.out.println(++move + ": Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
			return;
		}
		tower(disks - 1, fromRod, auxRod, toRod);
		System.out.println(++move + ": Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
		tower(disks - 1, auxRod, toRod, fromRod);
	}

}
