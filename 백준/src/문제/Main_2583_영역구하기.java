package 문제;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2583_영역구하기 {

	static int M, N, K;
	static int cnt , cntsize;
	static int[][] map;
	static boolean[][] flag;
	static int[] size;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static Queue<Point> que;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[M][N];
		flag = new boolean[M][N];
		size = new int[M*N];
		for (int i = 0; i < K; i++) {
			int x1, x2, y1, y2;
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt() - 1;
			y2 = sc.nextInt() - 1;
			for (int m = y1; m <= y2; m++) {
				for (int n = x1; n <= x2; n++) {
					map[m][n] = 1;
				}
			}
		}

		cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(safe(i,j) && map[i][j] == 0 && !flag[i][j]) {
					cnt++;
					cntsize = 0;
					flag[i][j] = true;
					que.add(new Point(i,j));
					
					while(!que.isEmpty()) {
						Point p = que.poll();
						cntsize++;
						for (int d = 0; d < 4; d++) {
							int ix = p.x + dx[d];
							int iy = p.y + dy[d];
							if(safe(iy,ix) && map[iy][ix] == 0 && !flag[iy][ix]) {
								flag[iy][ix] = true;
								que.add(new Point(iy,ix));
							}
						}
					}
					size[cnt] = cntsize;
					
				}
				
			}
		}
		Arrays.sort(size);
		System.out.println(cnt);
		for (int i = 0; i < size.length; i++) {
			if(size[i] != 0)
				System.out.print(size[i] + " ");
		}
	}

	private static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && y < M && x < N) {
			return true;
		} else
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
