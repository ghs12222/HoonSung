package 문제_Gold_ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1445_일요일아침의데이트 {

	static int N, M;
	static char[][] map;
	static int[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ey, ex;
	static GPoint[][] pmap;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		flag = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(flag[i], Integer.MAX_VALUE);
		}

		pmap = new GPoint[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				pmap[i][j] = new GPoint(Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					que.add(new Point(i, j, 0, 0));
//					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					ey = i;
					ex = j;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'g') {
					for (int d = 0; d < 4; d++) {
						int ix = j + dx[d];
						int iy = i + dy[d];
						if (safe(iy, ix) && map[iy][ix] == '.')
							map[iy][ix] = 'a';
					}
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();

		bfs();

		System.out.println(pmap[ey][ex].Gcnt + " " + pmap[ey][ex].Scnt);

	}

	static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (pmap[i][j].Gcnt == Integer.MAX_VALUE)
					System.out.print("0");
				else
					System.out.print(pmap[i][j].Gcnt);
			}
			System.out.print("\t");
			for (int j = 0; j < M; j++) {
				if (pmap[i][j].Scnt == Integer.MAX_VALUE)
					System.out.print("0");
				else
					System.out.print(pmap[i][j].Scnt);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void bfs() {
		while (!que.isEmpty()) {
//			Print();
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int iy = p.y + dy[d];
				int pg = p.Gcnt;
				int ps = p.Scnt;
				if (!safe(iy, ix))
					continue;
				else if (map[iy][ix] == 'g') {
					pg += 1;
				} else if (map[iy][ix] == 'a') {
					ps += 1;
				}
				if (pmap[iy][ix].Gcnt > pg) {
					pmap[iy][ix].Gcnt = pg;
					pmap[iy][ix].Scnt = ps;
					que.add(new Point(iy, ix, pg, ps));
				} else if (pmap[iy][ix].Gcnt == pg) {
					if (pmap[iy][ix].Scnt > ps) {
						pmap[iy][ix].Scnt = ps;
						que.add(new Point(iy, ix, pg, ps));
					}
				}
			}

		}
//		Print();
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}

	static class GPoint {
		int Gcnt;
		int Scnt;

		public GPoint(int gcnt, int scnt) {
			super();
			Gcnt = gcnt;
			Scnt = scnt;
		}
	}

	static class Point {
		int y;
		int x;
		int Gcnt;
		int Scnt;

		public Point(int y, int x, int gcnt, int scnt) {
			super();
			this.y = y;
			this.x = x;
			Gcnt = gcnt;
			Scnt = scnt;
		}
	}

}
