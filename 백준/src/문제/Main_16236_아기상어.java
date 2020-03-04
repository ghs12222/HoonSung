package 문제;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };
	static PriorityQueue<Point> que;
	static int agisize, sizecnt;
	static int sx, sy;
	static boolean fishisempty;
	static int time, timecount;

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new PriorityQueue<Point>();

		N = sc.nextInt();
		map = new int[N][N];
		flag = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sx = j;
					sy = i;
				}
			}
		}
		agisize = 2;
		sizecnt = 0;
		time = 0;
		fishisempty = true;

		que.add(new Point(sy, sx));
		while (!que.isEmpty()) {
			timecount = 0;
			int count = que.size();
			for (int k = 0; k < count; k++) {
				Point p = que.poll();
				timecount++;
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && map[iy][ix] <= agisize && !flag[iy][ix]) {
						if (map[iy][ix] == 0 || map[iy][ix] == agisize) {
							que.add(new Point(iy, ix));
							flag[iy][ix] = true;
						} else {
							map[iy][ix] = 0;
							sizecnt++;
							if (sizecnt == agisize) {
								agisize++;
								sizecnt = 0;
							}
							time += timecount;
							timecount = 0;
							sx = ix;
							sy = iy;
							que.clear();
							que.add(new Point(sy, sx));
							flag = new boolean[N][N];
						}

					}
				}
			}
		}
		System.out.println(time);

	}

	
	private static class Point implements Comparable<Point>{
		int y;
		int x;
		
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Point o) {
			if(this.y < o.y) {
				if(this.x < o.x) 
					return 1;
				else
					return -1;
			}
			else {
				if(this.x < o.x) 
					return 1;
				else
					return -1;
			}
		}
	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

}
