package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int time;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					que.add(new Point(i, j));
					flag[i][j] = true;
				}
			}
		}
		time = 0;
		bfs();
		if(check())
			System.out.println(time);
		else
			System.out.println("-1");

	}

	private static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			int size = que.size();
			boolean change = false;
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(!safe(iy,ix) || map[iy][ix] == -1)
						continue;
					if(map[iy][ix] == 0 && !flag[iy][ix]) {
						map[iy][ix] = 1;
						flag[iy][ix] = true;
						que.add(new Point(iy,ix));
						change = true;
					}
				}
			}
			if(change)
				time++;
			else
				break;
		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}
}
