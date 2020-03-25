package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9326_곰돌이 {

	static int T, N, S;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int Max, time;
	static boolean end;
	static LinkedList<Point> que;
	static LinkedList<Point> save;
	static Queue<Point> fire;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			que = new LinkedList<Point>();
			save = new LinkedList<Point>();
			fire = new LinkedList<Point>();

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			flag = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					// T(나무): -3
					if (s.charAt(j) == 'T')
						map[i][j] = -3;
					// G(풀밭): 0
					else if (s.charAt(j) == 'G')
						map[i][j] = 0;
					// H(벌집): -2
					else if (s.charAt(j) == 'H') {
						map[i][j] = -2;
						fire.add(new Point(i, j));
					}
					// D(곰돌이집)
					else if (s.charAt(j) == 'D')
						map[i][j] = -4;
					// M(곰돌이 최초 위치): 0
					else if (s.charAt(j) == 'M') {
						map[i][j] = 0;
						flag[i][j] = true;
						que.add(new Point(i, j));
					}
				}
			}
//			Print();
			beeinitialization();
			Print();
			end = false;
			time = Integer.MIN_VALUE;
			gameStart();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (time < map[i][j])
						time = map[i][j];
				}
			}
			System.out.println(time + 1);

		}
	}

	private static void beeinitialization() {
		int timecount = 1;
		int timecnt = 0;
		while (!fire.isEmpty()) {
			int count = fire.size();
			if (timecnt == S) {
				timecount++;
				timecnt = 0;
			}
			timecnt++;
			for (int k = 0; k < count; k++) {
				Point p = fire.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy, ix))
						continue;
					if (map[iy][ix] == 0) {
						map[iy][ix] = timecount;
						fire.offer(new Point(iy, ix));
					}
				}
			}
		}
	}

	private static void gameStart() {
		aa: while (!que.isEmpty()) {
			int count = que.size();
			int max4d = Integer.MIN_VALUE;
			boolean check = false;
			System.out.println("count = " + count);
			for (int k = 0; k < count; k++) {
				save.offer(que.poll());
			}
			System.out.println("quesize = " + que.size());
			Print();
			while (!check) {
				for (int k = 0; k < count; k++) {
					Point p = save.get(k);
					for (int d = 0; d < 4; d++) {
						int ix = p.x + dx[d];
						int iy = p.y + dy[d];
						if (!safe(iy, ix) || flag[iy][iy])
							continue;
						if (map[iy][ix] == -4) {
							end = true;
							que.clear();
							break aa;
						} else if (map[iy][ix] == 0) {
							flag[iy][ix] = true;
							check = true;
							que.offer(new Point(iy, ix));
						}

						else if (map[iy][ix] > 0) {
							if (max4d < map[iy][ix]) {
								max4d = map[iy][ix];
							}
						}
					}
				}
				if (!check) {
					delete(max4d);
				} else {
					System.out.println("savesize = " + save.size());
					save.clear();
				}
					
			}
		}
	}

	private static void delete(int max4d) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] >= max4d) {
					map[i][j] = 0;
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

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	private static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}

			System.out.print("\t\t");

			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + "\t");

			}
			System.out.println();
		}
		System.out.println();
	}

}
