package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {

	static int N, M;
	static int[][] map, cntmap;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean boom, arrival;
	static int step;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cntmap = new int[N][M];

		flag = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		step = 1;
		boom = false;
		arrival = false;
		flag[0][0] = true;
		que.add(new Point(0,0));
		while(!que.isEmpty()) {
			int count = que.size();
			step++;
			for (int i = 0; i < count; i++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(safe(iy,ix) && map[iy][ix] == 0 && !flag[iy][ix]) {
						flag[iy][ix] = true;
						que.add(new Point(iy,ix));
					}
				}
				
				
				
			}
			
		}
		

		if (arrival)
			System.out.println(cntmap[N - 1][M - 1]);
		else
			System.out.println("-1");

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
