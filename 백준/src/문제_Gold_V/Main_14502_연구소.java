package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {

	static int N, M;
	static int wallcnt, diffusion, noviruscnt, max;
	static int[][] map, virus;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		virus = new int[10][2];
		for (int i = 0; i < 10; i++) {
			Arrays.fill(virus[i], -1);
		}

		int cnt = 0;
		noviruscnt = -3;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus[cnt][0] = i;
					virus[cnt][1] = j;
					cnt++;
				}
				if (map[i][j] == 0) {
					noviruscnt++;
				}
			}
		}

		wallcnt = 3;
		fillWall();
		System.out.println(max);
	}

	private static void fillWall() {
		if (wallcnt == 0) {
			flag = new boolean[N][M];
			que = new LinkedList<Point>();
			diffusion = 0;
			for (int i = 0; i < 10; i++) {
				if (virus[i][0] != -1) {
					que.add(new Point(virus[i][0], virus[i][1]));
				}
			}
			bfs();
			if (max < noviruscnt - diffusion)
				max = noviruscnt - diffusion;
		}
		else if (wallcnt > 0) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 && wallcnt > 0) {
						wallcnt--;
						map[i][j] = 1;
						fillWall();
						wallcnt++;
						map[i][j] = 0;
					}
				}
			}
		}

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix))
						continue;
					if (map[iy][ix] == 0 && !flag[iy][ix]) {
						que.add(new Point(iy, ix));
						flag[iy][ix] = true;
						diffusion++;
					}
				}

			}
		}
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
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
