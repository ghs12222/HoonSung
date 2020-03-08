package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11559_뿌요뿌요 {

	static char[][] map;
	static int[][] delete;
	static boolean[][] flag;
	static char tar;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean end;
	static int cnt;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		que = new LinkedList<Point>();

		map = new char[12][6];
		flag = new boolean[12][6];
		delete = new int[12][6];
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		cnt = 0;
		end = false;
		while (!end) {
			end = true;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						que.add(new Point(i, j));
						bfs(i, j);

					}
				}
			}
			
			if (!end) {
				cnt++;
				for (int i = 11; i >= 0; i--) {
					for (int j = 0; j < 6; j++) {
						if (map[i][j] != '.') {
							down(i, j);
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int y, int x) {
		flag = new boolean[12][6];
		flag[y][x] = true;
		int count = 1;
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int iy = p.y + dy[d];
				if (safe(iy, ix) && !flag[iy][ix] && map[iy][ix] == map[y][x]) {
					flag[iy][ix] = true;
					que.add(new Point(iy, ix));
					count++;
				}
			}
		}
		if (count >= 4) {
			end = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (flag[i][j]) {
						map[i][j] = '.';
					}
				}
			}
		}
	}
	
	private static void down(int y, int ix) {
		int iy = y + 1;
		if (safe(iy, ix) && map[iy][ix] == '.') {
			map[iy][ix] = map[y][ix];
			map[y][ix] = '.';
			down(iy, ix);
		}
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

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < 6 && y < 12)
			return true;
		else
			return false;
	}

}
