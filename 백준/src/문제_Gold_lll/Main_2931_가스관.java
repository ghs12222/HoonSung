package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {

	static int N, M;
	static char[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 }; // 북동남서
	static int[] dy = { -1, 0, 1, 0 };
	static int sy, sx, ey, ex, dir;
	static boolean end;
	static char result;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == M) {
					sy = i;
					sx = j;
					que.add(new Point(sy,sx,0));
				} else if (map[i][j] == N) {
					ey = i;
					ex = j;
				}
			}
		}
		
		for (int d = 0; d < 4; d++) {
			if (map[sy + dy[d]][sx + dx[d]] != '.') {
				dir = d;
			}
		}
		end = false;
		flag[sy][sx] = true;
		dfs(sy, sx, dir);

	}

	private static void dfs(int y, int x, int d) {
		
		
	}

	private static void check(int y, int x, int direction) {
		
		
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
