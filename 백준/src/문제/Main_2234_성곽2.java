package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성곽2 {

	static int N, M;
	static int[][] map, bmap;
	static boolean[][] flag;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int catslecnt, max, wallmax, bcnt;
	static List<Integer> bmapcnt;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		bmapcnt = new LinkedList<Integer>();
		que = new LinkedList<Point>();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		bmap = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 성의 개수, 성 크기 최대
		catslecnt = 0;
		max = Integer.MIN_VALUE;
		wallmax = Integer.MIN_VALUE;
		bcnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!flag[i][j]) {
					flag[i][j] = true;
					que.add(new Point(i, j, false));
					catslecnt++;
					bmap[i][j] = bcnt;
					bfs1();
					bcnt++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int ix = j+dx[d];
					int iy = i+dy[d];
					if(!safe(iy,ix))
						continue;
					if(bmap[i][j] != bmap[iy][ix])
						cnt = bmapcnt.get(bmap[i][j]) + bmapcnt.get(bmap[iy][ix]);
					if(wallmax<cnt)
						wallmax = cnt;
				}
			}
		}
		System.out.println(catslecnt);
		System.out.println(max);
		System.out.println(wallmax);

	}


	private static void bfs1() {
		int size = 1;
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int iy = p.y + dy[d];
				if ((map[p.y][p.x] & (1 << d)) == 0) {
					if (!flag[iy][ix]) {
						que.add(new Point(iy, ix, false));
						flag[iy][ix] = true;
						bmap[iy][ix] = bcnt;
						size++;
					}
				}
			}
		}
		bmapcnt.add(size);
		if (max < size)
			max = size;
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
		boolean boom;

		public Point(int y, int x, boolean boom) {
			super();
			this.y = y;
			this.x = x;
			this.boom = boom;
		}
	}
}
