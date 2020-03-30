package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ing {

	static int K, W, H;
	static int[][] map;
	static boolean[][][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] hdx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hdy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int res;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<Point>();
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		flag = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		pq.add(new Point(0, 0, K, 0));

		Arrays.fill(flag[0][0], true);
		gameStart();
		System.out.println(res);

	}

	private static void gameStart() {

		while (!pq.isEmpty()) {
			Point p = pq.poll();

			if (p.x == W - 1 && p.y == H - 1) {
				res = p.depth;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int iy = p.y + dy[d];
				if (!safe(iy, ix) || flag[iy][ix][p.cnt])
					continue;
				if (map[iy][ix] == 0) {
					pq.add(new Point(iy, ix, p.cnt, p.depth + 1));
					flag[iy][ix][p.cnt] = true;
				}
			}

			if (p.cnt == 0)
				continue;
			for (int d = 0; d < 8; d++) {
				int ix = p.x + hdx[d];
				int iy = p.y + hdy[d];
				if (!safe(iy, ix) || flag[iy][ix][p.cnt])
					continue;
				if (map[iy][ix] == 0) {
					pq.add(new Point(iy, ix, p.cnt - 1, p.depth + 1));
					flag[iy][ix][p.cnt] = true;
				}
			}

		}
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && x < W && y >= 0 && y < H)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;
		int cnt;
		int depth;

		public Point(int y, int x, int cnt, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.depth = depth;
		}
	}

}