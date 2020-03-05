package 문제;

import java.util.Scanner;

//실패: 원인 못찾음
public class Main_9205_맥주마시면서걸어가기 {

	static int T;
	static int sx, sy, ex, ey;
	static int st;
	static boolean[] flag;
	static int[] stx, sty;
	static int beer;
	static boolean arrival;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			st = sc.nextInt();
			stx = new int[st];
			sty = new int[st];
			flag = new boolean[st];

			sx = sc.nextInt();
			sy = sc.nextInt();

			for (int i = 0; i < st; i++) {
				stx[i] = sc.nextInt();
				sty[i] = sc.nextInt();
			}

			ex = sc.nextInt();
			ey = sc.nextInt();

			beer = 20;
			arrival = false;
			dfs(sy, sx);
			if (arrival)
				System.out.println("happy");
			else
				System.out.println("sad");

		}

	}

	private static void dfs(int y, int x) {
		if ((int) Math.abs(x - ex) + (int) Math.abs(y - ey) <= 1000) {
			arrival = true;
		}
		if (arrival)
			return;
		int step = Integer.MAX_VALUE;
		for (int i = 0; i < st; i++) {
			if (!flag[i]) {

				int ix = x + stx[i];
				int iy = y + sty[i];
				if ((int) Math.abs(x - stx[i]) + (int) Math.abs(y - sty[i]) > 1000)
					continue;

				flag[i] = true;
				dfs(iy, ix);
				flag[i] = false;

			}

		}

	}

}
