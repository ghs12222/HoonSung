package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보충_점프사방 {

	static int T;
	static int Y, X, N;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int price, boomcnt;
	static Queue<Point> que;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[Y][X];
			for (int i = 0; i < Y; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < X; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				int cnt = Integer.parseInt(st.nextToken());
				que.add(new Point(y,x,cnt));
			}
			st = new StringTokenizer(br.readLine());
			boomcnt = Integer.parseInt(st.nextToken());
			for (int k = 0; k < boomcnt; k++) {
				int y = Integer.parseInt(st.nextToken())-1;
				int x = Integer.parseInt(st.nextToken())-1;
				map[y][x] = -1;
			}
			
			for (int i = 0; i < Y; i++) {
				for (int j = 0; j < X; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("참가자");
			for (int i = 0; i < N; i++) {
				Point p = que.poll();
				System.out.println(p.toString());
			}
		}

	}
	
	private static class Point {
		int y;
		int x;
		int cnt;
		public Point(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
	}

}
