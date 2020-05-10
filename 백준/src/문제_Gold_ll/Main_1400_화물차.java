package 문제_Gold_ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1400_화물차 {

	static int N, M;
	static char[][] map;
	static int[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int sx, sy, ex, ey;
	static int trafficcnt;
	static TrafficInfo[] traffic;
	static int[][] Info_Traffictime;
	static int[] Info_Trafficdir;
	static Queue<Point> que;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = M = -1;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while (!(N == 0 && M == 0)) {
			que = new LinkedList<Point>();
			map = new char[N][M];
			flag = new int[N][M];
			for (int i = 0; i < N; i++) {
				Arrays.fill(flag[i], Integer.MAX_VALUE);
			}
			Info_Traffictime = new int[10][2];
			Info_Trafficdir = new int[10];
			trafficcnt = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] - '0' >= 0 && map[i][j] - '0' <= 9) {
						trafficcnt++;
					}
					if (map[i][j] == 'A') {
						sx = j;
						sy = i;
						map[i][j] = '#';
						flag[i][j] = 0;
						que.add(new Point(i, j, 0));
					} else if (map[i][j] == 'B') {
						ex = j;
						ey = i;
					}
				}
			}
			traffic = new TrafficInfo[trafficcnt];
			for (int k = 0; k < trafficcnt; k++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				char dir = st.nextToken().charAt(0);
				int time0 = Integer.parseInt(st.nextToken());
				int time1 = Integer.parseInt(st.nextToken());
				int d;
				if (dir == '-')
					d = 0;
				else
					d = 1;
				traffic[num] = new TrafficInfo(time0, time1, d);
			}
			bfs();

			if (flag[ey][ex] == Integer.MAX_VALUE)
				System.out.println("impossible");
			else
				System.out.println(flag[ey][ex]);
			br.readLine();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}

	}

	static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (flag[i][j] == Integer.MAX_VALUE)
					System.out.print("0");
				else
					System.out.print(flag[i][j]);
			}
			System.out.print("\t");
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}

			System.out.println();
		}
		System.out.println();
	}

	private static void bfs() {
		while (!que.isEmpty()) {
//			Print();
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix) || map[iy][ix] == '.' || flag[iy][ix] < p.time + 1)
						continue;

					if (map[iy][ix] == 'B') {
						flag[iy][ix] = p.time + 1;
						continue;
					}
					if (map[iy][ix] == '#') {
						flag[iy][ix] = p.time + 1;
						que.add(new Point(iy, ix, p.time + 1));
					}

					else {
						int present = map[iy][ix] - '0';
						int dir = traffic[present].dir;
						int addtime = p.time;
						while (addtime >= 0) {
							if (dir == 0) {//동서
								addtime -= traffic[present].time0;
								dir = 1;
							} else {
								addtime -= traffic[present].time1;
								dir = 0;
							}
						}
						if (dir == 1) {//동서 일떄
							if (d == 0 || d == 2) {//남북
								addtime = p.time - addtime;
								if (flag[iy][ix] > addtime + 1) {
									que.add(new Point(iy, ix, addtime + 1));
									flag[iy][ix] = addtime + 1;
								}
							} else {
									que.add(new Point(iy, ix, p.time + 1));
									flag[iy][ix] = p.time + 1;
							}

						} else {
							if (d == 1 || d == 3) {
								addtime = p.time - addtime;
								if (flag[iy][ix] > addtime + 1) {
									que.add(new Point(iy, ix, addtime + 1));
									flag[iy][ix] = addtime + 1;
								}
							} else {
									que.add(new Point(iy, ix, p.time + 1));
									flag[iy][ix] = p.time + 1;
							}
						}

					}
				}

			}
		}
	}

	static class TrafficInfo {
		int time0;
		int time1;
		int dir;

		public TrafficInfo(int time0, int time1, int dir) {
			super();
			this.time0 = time0;
			this.time1 = time1;
			this.dir = dir;
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
		int time;

		public Point(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
	}

}
