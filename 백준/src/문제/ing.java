package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ing {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int Agisize, Eatcnt;
	static int Step;
	static PriorityQueue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					que.add(new Point(i, j, 0));
					flag[i][j] = true;
					map[i][j] = 0;
				}
			}
		}

		Agisize = 2;
		Eatcnt = 0;
		Step = 0;
		gameStart();
		System.out.println(Step);

	}

	private static void gameStart() {
		while (!que.isEmpty()) {
			int count = que.size();
			Point p = que.poll();
			// 먹을때
			for (int i = 0; i < count; i++) {
				if (map[p.y][p.x] != 0 && map[p.y][p.x] < Agisize) {
					flag = new boolean[N][N];
					flag[p.y][p.x] = true;
					map[p.y][p.x] = 0;
					que.clear();
					que.add(new Point(p.y, p.x, 0));
					Step += p.depth;
					Eatcnt++;
					if (Eatcnt == Agisize) {
						Eatcnt = 0;
						Agisize++;
					}
					break;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix) || flag[iy][ix])
						continue;
					if (map[iy][ix] <= Agisize) {
						flag[iy][ix] = true;
						que.add(new Point(iy, ix, p.depth + 1));
					}
				}
			}
		}
	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	private static class Point implements Comparable<Point> {
		int y;
		int x;
		int depth;

		public Point(int y, int x, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
		}

		@Override
		public int compareTo(Point target) {
			if (this.depth > target.depth)
				return 1;
			else if (this.depth == target.depth) {
				if (this.y > target.y)
					return 1;
				else if (this.y == target.y) {
					if (this.x > target.x)
						return 1;
					else
						return -1;
				}
				return -1;
			}
			return -1;
		}
	}

}
