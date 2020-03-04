package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_나이트의이동 {

	static int T, N;
	static int sx, sy, ex, ey;
	static boolean[][] flag;
	static int[] dx = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[] dy = { 2, 2, 1, -1, -2, -2, -1, 1 };
	static int time;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			que = new LinkedList<Point>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
//			que.add(Integer.parseInt(st.nextToken()));

			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			flag = new boolean[N][N];

			que.add(new Point(sy, sx));
			flag[sy][sx] = true;
			time = 0;
			go();
			System.out.println(time);

		}

	}

	private static void go() {
		while (true) {
			int count = que.size();
			for (int i = 0; i < count; i++) {
				Point p = que.poll();
				if (p.y == ey && p.x == ex) {
				
					return;
				}
				for (int d = 0; d < 8; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && !flag[iy][ix]) {
						flag[iy][ix] = true;
						que.add(new Point(iy, ix));

					}
				}
			}
			time++;
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
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

}
