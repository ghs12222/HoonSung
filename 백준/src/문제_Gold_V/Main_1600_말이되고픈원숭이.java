package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {

	static int K, N, M;
	static int[][] map;
	static boolean[][][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] hdx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hdy = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int step;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M][K+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(flag[0][0], true);
		que.add(new Point(0, 0, K, 0));

		step = -1;
		gameStart();
		System.out.println(step);

	}

	private static void gameStart() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();

				if (p.y == N - 1 && p.x == M - 1) {
					step = p.depth;
					que.clear();
					break;
				}

				if (p.count != 0) {
					for (int d = 0; d < 8; d++) {
						int ix = p.x + hdx[d];
						int iy = p.y + hdy[d];
						if (!safe(iy, ix))
							continue;
						if (map[iy][ix] == 0 && !flag[iy][ix][p.count-1]) {
							flag[iy][ix][p.count-1] = true;
							que.add(new Point(iy, ix, p.count - 1, p.depth + 1));
						}
					}
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix))
						continue;
					if (map[iy][ix] == 0 && !flag[iy][ix][p.count]) {
						flag[iy][ix][p.count] = true;
						que.add(new Point(iy, ix, p.count, p.depth + 1));
					}
				}
			}

		}

	}

	static class Point {
		int y;
		int x;
		int count;
		int depth;

		public Point(int y, int x, int count, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
			this.depth = depth;
		}

	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}

	static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
