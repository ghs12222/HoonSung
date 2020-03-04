package ¹®Á¦;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_ºù»ê {

	static int N, M;
	static int time;
	static int[][] map,tmpmap;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		flag = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		time = 0;
		while (icecheck() == 1) {
			time++;
			deleteice();
		}
		
		System.out.println(time);
	}

	private static int icecheck() {
		flag = new boolean[N][M];
		int icecnt = 0;
		for (int m = 0; m < N; m++) {
			for (int n = 0; n < M; n++) {
				if (map[m][n] != 0 && !flag[m][n]) {
					que.offer(new Point(m, n));
					icecnt++;
					flag[m][n] = true;
				}
				while (!que.isEmpty()) {
					int count = que.size();
					for (int k = 0; k < count; k++) {
						Point p = que.poll();
						for (int d = 0; d < 4; d++) {
							int ix = p.x + dx[d];
							int iy = p.y + dy[d];
							if (safe(iy, ix) && map[iy][ix] != 0 && !flag[iy][ix]) {
								flag[iy][ix] = true;
								que.add(new Point(iy, ix));
							}
						}
					}

				}
			}
		}
		
		if (icecnt == 0)
			time = 0;
		return icecnt;

	}

	private static void deleteice() {
		tmpmap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, tmpmap[i], 0, map[i].length);
		}
		for (int m = 0; m < N; m++) {
			for (int n = 0; n < M; n++) {
				if (safe(m,n) && map[m][n] != 0) {
					int count = 0;
					for (int d = 0; d < 4; d++) {
						int ix = n+dx[d];
						int iy = m+dy[d];
						if(safe(iy,ix) && map[iy][ix] == 0) 
							count++;
					}
					tmpmap[m][n] = map[m][n] - count;
					if(tmpmap[m][n]<0) 
						tmpmap[m][n] =0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = tmpmap[i][j];
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

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

}
