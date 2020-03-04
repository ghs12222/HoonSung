package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593_상범빌딩 {

	static int L, R, C;
	static char[][][] map;
	static boolean[][][] flag;
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { -1, 0, 1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int ex, ey, ez;
	static int time;
	static boolean end;
	static StringBuilder sb = new StringBuilder();
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			que = new LinkedList<Point>();
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (L == 0 && R == 0 && C == 0)
				break;
			map = new char[L][R][C];
			flag = new boolean[L][R][C];

			for (int l = 0; l < L; l++) {
				for (int i = 0; i < R; i++) {
					String s = br.readLine();
					for (int j = 0; j < C; j++) {
						map[l][i][j] = s.charAt(j);
						if (map[l][i][j] == 'S') {
							que.add(new Point(l, i, j));
							flag[l][i][j] = true;
						} else if (map[l][i][j] == 'E') {
							ex = j;
							ey = i;
							ez = l;
						}
					}
				}
				String ss = br.readLine();
			}

			time = 0;
			end = false;

			while (!que.isEmpty()) {
				int count = que.size();
				for (int k = 0; k < count; k++) {
					Point p = que.poll();
					if (p.x == ex && p.y == ey && p.z == ez) {
						end = true;
						que.clear();
						break;
					}
					for (int d = 0; d < 6; d++) {
						int ix = p.x + dx[d];
						int iy = p.y + dy[d];
						int iz = p.z + dz[d];
						if (safe(iz, iy, ix) && map[iz][iy][ix] != '#' && !flag[iz][iy][ix]) {
							flag[iz][iy][ix] = true;
							que.add(new Point(iz, iy, ix));
						}
					}
				}
				if (!end)
					time++;
			}

			if (end)
				System.out.println("Escaped in " + time + " minute(s).");
			else
				System.out.println("Trapped!");
		}
	}

	private static boolean safe(int z, int y, int x) {
		if (z >= 0 && y >= 0 && x >= 0 && z < L && y < R && x < C)
			return true;
		else
			return false;
	}

	private static class Point {
		int z;
		int y;
		int x;

		public Point(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}

	}

}
