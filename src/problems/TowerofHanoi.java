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
		char extraAuxRod = 'D';
		char auxRod = 'C';
		char toRod = 'B';
		char fromRod = 'A';
		tower(disks, fromRod, toRod, auxRod);
	}

	private static void towerWithExtraAux(int disks, char fromRod, char toRod, char auxRod, char extraAuxRod) {
		if (disks == 1) {
			System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
			return;
		}
		towerWithExtraAux(disks - 1, fromRod, extraAuxRod, auxRod, toRod);
		System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod);
		towerWithExtraAux(disks - 1, extraAuxRod, auxRod, toRod, fromRod);

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
