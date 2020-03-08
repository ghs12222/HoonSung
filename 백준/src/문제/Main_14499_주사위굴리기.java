package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {

	static int N, M, movecnt;
	static int sy, sx;
	static int[] dice;
	static int[][] map;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 0 };
	static int[] movedir;
	static LinkedList<Point> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		movecnt = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		movedir = new int[movecnt];
		dice = new int[6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < movecnt; i++) {
			movedir[i] = Integer.parseInt(st.nextToken()) - 1;
		}

//		list.add(new Point(sy, sx, movedir[0], dice));
//		Point p = new Point(sy, sx, movedir[0], dice);
		
		dicestart(new Point(sy, sx, movedir[0], dice));

		System.out.println(sb);
		
		
	}

	private static void dicestart(Point p) {
		for (int d = 0; d < movecnt; d++) {
			int ix = p.x + dx[movedir[d]];
			int iy = p.y + dy[movedir[d]];

			if (safe(iy, ix)) {
				// 움직이는 곳이 0일때
				if (map[iy][ix] == 0) {
					map[iy][ix] = p.value[5];
					sb.append(p.value[0]).append("\n");
				}

				else {
					p.dicestate(movedir[d]);
					p.value[5] = map[iy][ix];
					sb.append(p.value[0]).append("\n");
				}
				
				p.x += ix;
				p.y += iy;
			}
		}
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
		int d;
		int[] value = new int[6];

		public Point(int y, int x, int d, int[] value) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
			this.value = value;
		}

		private void dicestate(int dir) {
			int tmp0 = value[0];
			int tmp1 = value[1];
			int tmp2 = value[2];
			int tmp3 = value[3];
			int tmp4 = value[4];
			int tmp5 = value[5];
			if (dir == 0) {
				value[0] = tmp3;
				value[3] = tmp5;
				value[5] = tmp2;
				value[2] = tmp0;
			} else if (dir == 1) {
				value[0] = tmp2;
				value[2] = tmp5;
				value[5] = tmp3;
				value[3] = tmp0;
			} else if (dir == 2) {
				value[0] = tmp4;
				value[4] = tmp5;
				value[5] = tmp1;
				value[1] = tmp0;
			} else if (dir == 3) {
				value[0] = tmp1;
				value[1] = tmp5;
				value[5] = tmp4;
				value[4] = tmp0;
			}
		}

	}

}
