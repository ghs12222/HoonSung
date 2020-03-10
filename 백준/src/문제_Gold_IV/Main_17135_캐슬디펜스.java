package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {

	static int N, M, Len;
	static int[][] map, smap;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] Archer;
	static int[] deleteX, deleteY;
	static int Enemy, Enemycnt, Delete, Max;
	static PriorityQueue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Len = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		smap = new int[N + 1][M];
		flag = new boolean[N + 1][M];
		Archer = new int[3];

		Enemy = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					Enemy++;
			}
		}
		Max = Integer.MIN_VALUE;
		Combi(0, 0);
		System.out.println(Max);
	}

	private static void Combi(int start, int count) {
		if (count == 3) {
			for (int i = 0; i < N + 1; i++) {
				System.arraycopy(map[i], 0, smap[i], 0, M);
			}
			Enemycnt = Enemy;
			Delete = 0;
			gameStart();
			if (Max < Delete)
				Max = Delete;
			return;
		}

		for (int i = start; i < M; i++) {
			Archer[count] = i;
			Combi(i + 1, count + 1);
		}

	}

	private static void gameStart() {
		while (Enemycnt > 0) {
			deleteX = new int[3];
			deleteY = new int[3];
			Arrays.fill(deleteX, -1);
			Arrays.fill(deleteY, -1);
			int cnt = 0;
			for (int i = 0; i < 3; i++) {

				flag = new boolean[N + 1][M];
				flag[N][Archer[i]] = true;
				que.add(new Point(N, Archer[i], 0));
				// 한발쏘기
				dfs();
				if (!que.isEmpty()) {
					Point p = que.poll();
					deleteX[cnt] = p.x;
					deleteY[cnt] = p.y;
					cnt++;
					que.clear();
				}
			}
			for (int i = 0; i < 3; i++) {
				if (safe(deleteY[i],deleteX[i]) && smap[deleteY[i]][deleteX[i]] == 1) {
					smap[deleteY[i]][deleteX[i]] = 0;
					Delete++;
					Enemycnt--;
				}
			}

			//////////////// 한칸 내리기
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (i == N - 1) {
						if (smap[i][j] == 1) {
							smap[i][j] = 0;
							Enemycnt--;
						}
					} else {
						smap[i + 1][j] = smap[i][j];
						smap[i][j] = 0;
					}
				}
			}
			Arrays.fill(smap[0], 0);
			/////////////////////////
		}

	}

	private static void dfs() {
		boolean end = false;
		while (!que.isEmpty()) {
			int count = que.size();
			for (int k = 0; k < count; k++) {
				Point p = que.poll();
				if (smap[p.y][p.x] == 1 && p.depth <= Len) {
					que.clear();
					que.add(new Point(p.y, p.x, 0));
					end = true;
					break;
				}

				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && !flag[iy][ix]) {
						flag[iy][ix] = true;
						que.add(new Point(iy, ix, p.depth + 1));
					}
				}

			}
			if (end)
				break;

		}

	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N + 1)
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
			else if (this.y > target.y) {
				if (this.x > target.x)
					return 1;
				else
					return -1;
			}
			return -1;
		}

	}

}
