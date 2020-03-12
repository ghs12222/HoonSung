package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ing2 {

	static int N, M;
	static int[][] map, cntmap;
	static boolean[][] flag, bflag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int step;
	static Queue<Point> que;
	static Queue<Point> boomque;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		boomque = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cntmap = new int[N][M];

		flag = new boolean[N][M];
		bflag = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		step = 0;
		flag[0][0] = true;
		bflag[0][0] = true;
		que.add(new Point(0, 0, 0, false));
		while (!que.isEmpty()) {
			int count = que.size();
			for (int i = 0; i < count; i++) {
				Point p = que.poll();

				// 이동 끝!
				if (p.x == M - 1 && p.y == N - 1) {
					step = p.depth;
					que.clear();
					break;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix))
						continue;

					// 폭탄 사용 안한 상태 && 폭탄(x)의 방문자리가 아님
					if (!p.boom) {
						if (map[iy][ix] == 0 && !flag[iy][ix]) {
							flag[iy][ix] = true;
							que.add(new Point(iy, ix, p.depth + 1, false));
						}
						if (map[iy][ix] == 1 && !bflag[iy][ix]) {
							bflag[iy][ix] = true; // 폭탄 사용 체크하면서 폭탄 사용 flag == true;
							que.add(new Point(iy, ix, p.depth + 1, true));
						}
					}

					// 폭탄 사용한 상태 && 폭탄(o)의 방문자리가 아님
					else if (p.boom && !bflag[iy][ix]) {
						if (map[iy][ix] == 0) {
							bflag[iy][ix] = true;
							boomque.add(new Point(iy, ix, p.depth + 1, true));
							bflag = new boolean[N][M];
							bflag[iy][ix] = true;
						}
					}
				}
			}
		}
		
		if (step != 0) {
			step++;
			System.out.println(step);
		} else if (step == 0)
			System.out.println("-1");

	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}

	private static class Point {
		int y;
		int x;
		int depth;
		boolean boom;

		public Point(int y, int x, int depth, boolean boom) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.boom = boom;
		}

	}
}
