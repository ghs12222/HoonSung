package 문제_Gold_lV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1726_로봇2 {

	static int N, M;
	static int[][] map;
	static int[][][] flag;
	static int[] dx = { 0, 1, 0, -1 };//북동남서
	static int[] dy = { -1, 0, 1, 0 };
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
		if(sd == 4)
			sd = 0;
		else if (sd == 1)	//북동남서
			sd = 1;
		else if (sd == 3)
			sd = 2;
		else if (sd == 2)
			sd = 3;
		que.add(new Point(sy, sx, sd, 0));

		st = new StringTokenizer(br.readLine());
		ey = Integer.parseInt(st.nextToken()) - 1;
		ex = Integer.parseInt(st.nextToken()) - 1;
		ed = Integer.parseInt(st.nextToken());
		if(ed == 4)
			ed = 0;
		else if (ed == 1)	//북동남서
			ed = 1;
		else if (ed == 3)
			ed = 2;
		else if (ed == 2)
			ed = 3;
		step = Integer.MAX_VALUE;
		bfs();
		System.out.println(step);

	}


	static int dircheck(int y, int x, int d, int dir) {
		int check = Math.abs(d - dir);
		int add = 0;
		if(check == 1 || check == 3) {
			add = 1;
		}
		else if(check == 2)
			add = 2;
		return add;
	}
	
	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			for (int s = 0; s < size; s++) {
				Point p = que.poll();
				if (p.x == ex && p.y == ey) {
					p.step += dircheck(p.y,p.x,p.d,ed);
					if(step > p.step) {
						step = p.step;
						flag[ed][ey][ex] = p.step;
					}
				}
				for (int d = 0; d < 4; d++) {
					for (int k = 1; k <= 3; k++) {
						int stepcnt = p.step;
						int ix = p.x + dx[d] * k;
						int iy = p.y + dy[d] * k;
						if (!safe(iy, ix) || map[iy][ix] == 1)
							break;
						if (map[iy][ix] == 0) {
							stepcnt += dircheck(iy,ix,d, p.d)+1;
							if(flag[d][iy][ix] > stepcnt) {
								flag[d][iy][ix] = stepcnt;
								que.add(new Point(iy,ix,d,stepcnt));
							}
						}
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
