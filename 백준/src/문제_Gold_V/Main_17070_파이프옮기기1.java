package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {

	static int N;
	static int[][] map;
	static int[] dx = {1,0,1};
	static int[] dy = {0,1,1};
	static int count;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		que.add(new Point(0, 1, 0));
		count = 0;
		bfs();
		System.out.println(count);

	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			System.out.println("------------que-----------");
			for (int s = 0; s < size; s++) {
				Point p = que.poll();
				System.out.println("p.y = " + p.y + ", p.x = " + p.x + ", p.dir = " + p.dir);
				Print(p);
				int ix = p.x + dx[p.dir];
				int iy = p.y + dy[p.dir];
				if (p.y == N - 1 && p.x == N - 1) {
					count++;
					continue;
				}
				if (!safe(iy, ix) || map[iy][ix] == 1)
					continue;

				
				
				
				if (p.dir != 2 && map[iy][ix] == 0) {
					que.add(new Point(iy, ix, p.dir));
					int check = 0;
					for (int d = 0; d < 3; d++) {
						ix = p.x + dx[d];
						iy = p.y + dy[d];
						if(safe(iy,ix) && map[iy][ix] == 0)
							check++;
					}
					if(check == 3) {
						que.add(new Point(iy+dy[2],ix+dx[2],2));
					}

				} else if (p.dir == 2) {
					System.out.println("p.dir = 2");
					for (int d = 0; d < 3; d++) {
						ix = p.x + dx[d];
						iy = p.y + dy[d];
						if (safe(iy, ix) && map[iy][ix] == 0) {
							que.add(new Point(iy, ix, d));
//							System.out.println("iy+dy[d] = " + (iy+dy[d]) + ", ix+dx[d] = " + (ix+dx[d]) + ", d = " + d);
//							System.out.println("??");
						}
					}
				}
			}
		}
	}

	private static void Print(Point p) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (p.y == i && p.x == j)
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
		System.out.println();
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

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

}
