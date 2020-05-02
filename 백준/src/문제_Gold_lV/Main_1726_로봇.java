package 문제_Gold_lV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇 {

	static int N, M;
	static int[][] map;
	static int[][][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int step, ex, ey, ed;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new int[4][N][M];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(flag[i][j], Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sd = Integer.parseInt(st.nextToken());
		if (sd == 2)
			sd = 3;
		else if (sd == 3)
			sd = 2;
		else if (sd == 4)
			sd = 0;
		que.add(new Point(sy, sx, sd, 0));

		st = new StringTokenizer(br.readLine());
		ey = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ed = Integer.parseInt(st.nextToken());
		if (ed == 2)
			ed = 3;
		else if (ed == 3)
			ed = 2;
		else if (ed == 4)
			ed = 0;
		step = Integer.MAX_VALUE;
		bfs();

		System.out.println(step);

	}

	private static void Print() {
		System.out.println();
		for (int d = 0; d < 4; d++) {
			System.out.println("d = " + d);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (flag[d][i][j] == Integer.MAX_VALUE)
						System.out.print("0 ");
					else
						System.out.print(flag[d][i][j] + " ");

				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			Print();
			for (int s = 0; s < size; s++) {
				Point p = que.poll();
				if (p.x == ex && p.y == ey) {
					int fuck = Math.abs(p.d - ed);
					if (fuck == 0) {
						if (flag[p.d][p.y][p.x] > p.step)
							flag[p.d][p.y][p.x] = p.step;
					} else if (fuck == 1) {
						if (flag[p.d][p.y][p.x] > p.step + 1)
							flag[p.d][p.y][p.x] = p.step + 1;
					} else if (fuck == 2) {
						if (flag[p.d][p.y][p.x] > p.step + 2)
							flag[p.d][p.y][p.x] = p.step + 2;
					} else if (fuck == 3) {
						if (flag[p.d][p.y][p.x] > p.step + 1)
							flag[p.d][p.y][p.x] = p.step + 1;
					}
					if(step > flag[p.d][p.y][p.x])
						step = flag[p.d][p.y][p.x];
				}
				for (int d = 0; d < 4; d++) {
					int id = Math.abs(p.d - d);

					for (int k = 1; k <= 3; k++) {
						int ix = p.x + dx[d] * k;
						int iy = p.y + dy[d] * k;
						if (!safe(iy, ix) || map[iy][ix] == 1)
							break;
						if (map[iy][ix] == 0) {
							if (flag[d][iy][ix] > p.step + 1 && id == 0) {
								que.add(new Point(iy, ix, d, p.step + 1));
								flag[d][iy][ix] = p.step + 1;
							} else if (flag[d][iy][ix] > p.step + 2 && id == 1) {
								que.add(new Point(iy, ix, d, p.step + 2));
								flag[d][iy][ix] = p.step + 2;
							} else if (flag[d][iy][ix] > p.step + 3 && id == 2) {
								que.add(new Point(iy, ix, d, p.step + 3));
								flag[d][iy][ix] = p.step + 3;
							} else if (flag[d][iy][ix] > p.step + 2 && id == 3) {
								que.add(new Point(iy, ix, d, p.step + 2));
								flag[d][iy][ix] = p.step + 2;
							}

						}

//							if (flag[d][iy][ix] > p.step + 1) {
//								if (id == 0) {
//									que.add(new Point(iy, ix, d, p.step + 1));
//									flag[d][iy][ix] = p.step + 1;
//								} else if (id == 1) {
//									que.add(new Point(iy, ix, d, p.step + 2));
//									flag[d][iy][ix] = p.step + 2;
//								} else if (id == 2)
//									que.add(new Point(iy, ix, d, p.step + 3));
//								else if (id == 3)
//									que.add(new Point(iy, ix, d, p.step + 2));
//
//							}
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
		int d;
		int step;

		public Point(int y, int x, int d, int step) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.step = step;
		}
	}

}
