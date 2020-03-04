package 기타;

import java.util.Scanner;

public class Solution_소금쟁이 {

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();
			int num = scann.nextInt();
			int count = num;
			boolean[][] map = new boolean[N][N];

			for (int i = 0; i < num; i++) {
				int x = scann.nextInt();
				int y = scann.nextInt();
				int d = scann.nextInt();
				boolean live = true;

				for (int j = 3; j > 0; j--) {
					x += dx[d] * j;
					y += dy[d] * j;
					// || map[x][y] == true) {
					if (x >= N || y >= N || x < 0 || y < 0) {
						live = false;
						count--;
						break;
					}
					if (map[x][y] == true) {
						live = false;
						count--;
						break;
					}


				}
				if (live == true)
					map[x][y] = true;

			}

			System.out.println("#" + t + " " + count);
		}
	}

}
