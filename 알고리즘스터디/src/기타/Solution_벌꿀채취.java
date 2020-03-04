package ±‚≈∏;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_π˙≤‹√§√Î {

	static int T, N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int step, stepcnt;
	static boolean flag;
	static Queue<Point> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();

		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];

			int start = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					if (start <= map[i][j])
						start = map[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (start == map[i][j])
						que.add(new Point(i, j));
				}
			}

			step = Integer.MIN_VALUE;
			while (!que.isEmpty()) {
				Point p = que.poll();
				flag = false;
				visited = new boolean[N][N];
				visited[p.y][p.x] = true;
				stepcnt = 1;
				dfs(p.y, p.x);
			}

			System.out.println("#"+t+" "+step);
		}
	}

	private static void dfs(int y, int x) {
		if (step < stepcnt) {
			step = stepcnt;
		}

		for (int d = 0; d < 4; d++) {
			int ix = x + dx[d];
			int iy = y + dy[d];

			if (safe(iy, ix) && map[iy][ix] < map[y][x] && !visited[iy][ix]) {
				visited[iy][ix] = true;
				stepcnt++;
				dfs(iy, ix);
				stepcnt--;
				visited[iy][ix] = false;
			}

			else if (safe(iy, ix) && map[iy][ix] >= map[y][x] && !visited[iy][ix] && !flag) {
				for (int i = 1; i <= K; i++) {
					map[iy][ix] -= i;
					flag = true;
					dfs(y, x);
					map[iy][ix] += i;
					flag = false;
				}
			}

		}
	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}
