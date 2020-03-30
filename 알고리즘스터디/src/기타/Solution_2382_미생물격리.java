package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {

	static int T;
	static int N, M, K;
	static int[][] map;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int res;
	static PriorityQueue<Point> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			list = new PriorityQueue<Point>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				list.add(new Point(y, x, cnt, dir));
			}

			for (int i = 0; i < M; i++) {
				go();
			}

			res = 0;
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Point p = list.poll();
				res += p.cnt;
			}
			System.out.println(res);
		}

	}

	private static void go() {
		int size = list.size();
		for (int k = 0; k < size; k++) {
			Point p = list.poll();
			list.add(p);
			p.x += dx[p.dir];
			p.y += dy[p.dir];
			if (!safe(p.y, p.x)) {
				p.cnt /= 2;
				if (p.dir == 1)
					p.dir = 2;
				else if (p.dir == 2)
					p.dir = 1;
				else if (p.dir == 3)
					p.dir = 4;
				else if (p.dir == 4)
					p.dir = 3;
			}
		}
//		mapcheck();
	}

//	private static void mapcheck() {
//		int size = list.size();
//		for (int k = 0; k < size - 1; k++) {
//			Point p = list.get(k);
//			Point p1 = list.get(k + 1);
//			if (p.x == p1.x && p.y == p1.y) {
//				p1.cnt += p.cnt;
//				p1.dir = p.dir;
//				list.remove(k);
//				k--;
//				size--;
//			}
//		}
//	}

	static boolean safe(int y, int x) {
		if (x >= 1 && y >= 1 && x < N - 1 && y < N - 1)
			return true;
		else
			return false;
	}

	static class Point implements Comparable<Point> {
		int y;
		int x;
		int cnt;
		int dir;

		public Point(int y, int x, int cnt, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y > o.y)
				return 1;
			else if (this.y == o.y) {
				if (this.x > o.x)
					return 1;
				else if (this.x == o.x) {
					if (this.cnt > o.cnt) {
						return 1;
					} else
						return -1;
				}
				return -1;
			}
			return -1;
		}

	}

}
