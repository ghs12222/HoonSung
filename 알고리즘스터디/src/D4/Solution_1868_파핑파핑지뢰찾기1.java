package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기1 {

	static int T, N;
	static char[][] cmap;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int cnt;
	static int res;
	static Queue<Point> que;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cmap = new char[N][N];
			map = new int[N][N];
			flag = new boolean[N][N];
			res = 0;
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				cmap[i] = s.toCharArray();
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cmap[i][j] == '*') {
						map[i][j] = -1;
						continue;
					}
					cnt = 0;
					for (int d = 0; d < 8; d++) {
						int ix = j + dx[d];
						int iy = i + dy[d];
						if (safe(iy, ix) && cmap[iy][ix] == '*') {
							cnt++;
						}
					}
					map[i][j] = cnt;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == -1) 
						flag[i][j] = true;
					else if (map[i][j] == 0 && !flag[i][j]) {
						res++;
						flag[i][j] = true;
						que.add(new Point(i, j));
						while (!que.isEmpty()) {
							Point p = que.poll();
							for (int d = 0; d < 8; d++) {
								int ix = p.x + dx[d];
								int iy = p.y + dy[d];
								if (safe(iy, ix) && map[iy][ix] != -1 && !flag[iy][ix]) {
									flag[iy][ix] = true;
									if(map[iy][ix] == 0)
										que.add(new Point(iy,ix));
								}
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!flag[i][j])
						res++;
				}
			}

			System.out.println("#" + t + " " + res);

		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < N && x < N) {
			return true;
		}
		else
			return false;
	}

	private static class Point {
		int x;
		int y;

		public Point(int y, int x) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
