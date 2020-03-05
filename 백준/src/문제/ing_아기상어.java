package 문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ing_아기상어 {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int sx, sy;
	static int agisize, agicnt;
	static int step, stepcnt;
	static PriorityQueue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<>();

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sx = j;
					sy = i;
					map[i][j] = 0;
					flag[i][j] = true;
					que.add(new Point(i, j));
				}
			}
		}

		step = 0;
		stepcnt = 0;
		agisize = 2;
		agicnt = 0;
		bfs();

		System.out.println(step);
//		for (int m = 0; m < N; m++) {
//			for (int n = 0; n < N; n++) {
//				if(flag[m][n]) 
//					System.out.print("1");
//				else
//					System.out.print("0");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int count = que.size();
			stepcnt++;
			for (int i = 0; i < count; i++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if (safe(iy, ix) && map[iy][ix] <= agisize && !flag[iy][ix]) {
						if (map[iy][ix] == agisize || map[iy][ix] == 0) {
							flag[iy][ix] = true;
							que.add(new Point(iy, ix));
						} else {
							map[iy][ix] = 0;
							flag = new boolean[N][N];
							flag[iy][ix] = true;

							step += stepcnt;
							stepcnt = 0;

							agicnt++;
							if (agicnt == agisize) {
								agicnt = 0;
								agisize++;
							}

							que.clear();
							que.add(new Point(iy, ix));

						}
					}
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

	private static class Point implements Comparable<Point> {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Point target) {
			if(this.y < target.y) 
				return 0;
			else {
				if(this.x < target.x) 
					return 0;
				else
					return 1;
			}
			
		}

	}

}
