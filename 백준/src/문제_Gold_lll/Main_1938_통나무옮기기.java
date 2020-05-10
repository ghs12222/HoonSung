package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {

	static int N;
	static int[][] map;
	static boolean[][][] flag;
	static int[][] Start, End; // 통나무 시작 좌표, 끝 좌표
	static int sx, sy, sd, ex, ey, ed; // 0 = 가로, 1 = 세로
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] cdx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] cdy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int min, step;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		que = new LinkedList<Point>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flag = new boolean[2][N][N];
		Start = new int[3][2];
		End = new int[3][2];
		int startcnt = 0;
		int endcnt = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if (s.charAt(j) == 'B') {
					Start[startcnt][0] = i;
					Start[startcnt][1] = j;
					startcnt++;
					map[i][j] = 0;
				} else if (s.charAt(j) == 'E') {
					End[endcnt][0] = i;
					End[endcnt][1] = j;
					endcnt++;
					map[i][j] = 0;
				} else {
					map[i][j] = s.charAt(j) - '0';
				}
			}
		}

		// 시작좌표, 끝 좌표의 중심값과 방향 0 = 가로, 1 = 세로
		sy = Start[1][0];
		sx = Start[1][1];
		if (Start[0][0] - Start[1][0] == 0) // y좌표 차이가 0이라면 초기 방향 가로
			sd = 0;
		else
			sd = 1;
		ey = End[1][0];
		ex = End[1][1];
		if (End[0][0] - End[1][0] == 0)
			ed = 0;
		else
			ed = 1;

		flag[sd][sy][sx] = true;
		que.add(new Point(sy, sx, sd, 0));
		gameStart();
		System.out.println(step);

	}

	private static void gameStart() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Point p = que.poll();
				if (p.y == ey && p.x == ex && p.dir == ed) {
					que.clear();
					step = p.depth;
					break;
				}
				a: for (int d = 0; d < 4; d++) { // 상하 좌우 이동
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (!safe(iy,ix) || flag[p.dir][iy][ix])
						continue;
					if (p.dir == 0) {
						for (int k = -1; k < 2; k++) {
							if (!safe(iy, ix + k) || map[iy][ix + k] == 1)
								continue a;
						}
					} else if (p.dir == 1) {
						for (int k = -1; k < 2; k++) {
							if (!safe(iy + k, ix) || map[iy + k][ix] == 1) {
								continue a;
							}
						}
					}
					que.add(new Point(iy, ix, p.dir, p.depth + 1));
					flag[p.dir][iy][ix] = true;
				}
				boolean check = true;

				for (int d = 0; d < 8; d++) { // turn
					int ix = p.x + cdx[d];
					int iy = p.y + cdy[d];
					if (!safe(iy, ix) || map[iy][ix] == 1) {
						check = false;
						break;
					}
				}
				if (check) {
					if (p.dir == 0 && !flag[1][p.y][p.x]) {
						que.add(new Point(p.y, p.x, 1, p.depth + 1));
						flag[1][p.y][p.x] = true;
					} else if (p.dir == 1 && !flag[0][p.y][p.x]) {
						que.add(new Point(p.y, p.x, 0, p.depth + 1));
						flag[0][p.y][p.x] = true;
					}
				}
			}
		}
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;
		int dir;
		int depth;

		public Point(int y, int x, int dir, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.depth = depth;
		}
	}

}
