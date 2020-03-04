package Study_0128;

import java.util.Scanner;

public class Solution_117_주사위던지기2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 주사위를 던진 횟수 2~ 7
		int m = sc.nextInt();
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] num = new int[n];
		Dice(0, arr, num, m);
	}

	static void Dice(int cnt, int[] arr, int[] dice, int m) {
		if (cnt == dice.length) {
			int total = 0;
			for (int i = 0; i < cnt; i++) {
				total += dice[i];
			}

			if (total == m) {
				for (int i = 0; i < cnt; i++) {
					System.out.print(dice[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			dice[cnt] = arr[i];
			Dice(cnt + 1, arr, dice, m);
		}
	}
}