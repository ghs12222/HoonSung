package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 별자리 {

	static int T;
	static int map[][];
	static boolean flag[][];
	static int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int dy[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int starcnt, res;
	static Queue<Point> que;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			que = new LinkedList<Point>();
			map = new int[10][10];
			flag = new boolean[10][10];
			starcnt = 0;

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (map[i][j] == 1 && !flag[i][j]) {
						flag[i][j] = true;
						starcnt++;
						que.add(new Point(i, j));
						bfs();
					}
				}
			}

			sb.append("#").append(t).append(" ").append(starcnt).append("\n");
		}
		System.out.println(sb);

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 8; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(!safe(iy,ix))
						continue;
					if(map[iy][ix] == 1 && !flag[iy][ix]) {
						flag[iy][ix] = true;
						que.add(new Point(iy,ix));
					}
				}
			}
		}
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < 10 && y < 10)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
