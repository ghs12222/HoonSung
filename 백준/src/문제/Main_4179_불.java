package 문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4179_불 {

	static int R, C;
	static char[][] map;
	static boolean[][] flag;
	static int jx, jy, fx, fy;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<Point> jque;
	static Queue<Point> fque;
	static int cnt;
	static boolean out;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		jque = new LinkedList<Point>();
		fque = new LinkedList<Point>();
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		flag = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					jy = i;
					jx = j;
					jque.add(new Point(i, j));
					flag[i][j] = true;
				}
				if (map[i][j] == 'F') {
					fy = i;
					fx = j;
					fque.add(new Point(i, j));
				}
			}
		}

		out = false;
		cnt = 0;
		while (!jque.isEmpty()) {
			cnt++;
			int fsize = fque.size();
			int jsize = jque.size();
			for (int k = 0; k < fsize; k++) {
				Point p = fque.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && map[iy][ix] == '.') {
						map[iy][ix] = 'F';
						fque.add(new Point(iy,ix));
					}
				}

			}
			for (int k = 0; k < jsize; k++) {
				Point p = jque.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && map[iy][ix] == '.' && !flag[iy][ix]) {
						flag[iy][ix] = true;
						jque.add(new Point(iy, ix));
					}
					if (!safe(iy, ix)) {
						out = true;
//						cnt++;
						break;
					}
				}
				if (out == true)
					break;
			}
			if (out == true)
				break;
		}

		if (out == true)
			System.out.println(cnt);
		else
			System.out.println("IMPOSSIBLE");

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < R && x < C)
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
