package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1249_º¸±Þ·Î {

	static int T, N;
	static int[][] map, min;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static Queue<Point> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			min = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				char[] c = s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = c[j] - '0';
					if(!((i==0 && j==0) || (i==N && j==N)))
							min[i][j] = Integer.MAX_VALUE;
				}
			}
			
			
			que.add(new Point(0,0));
			while(!que.isEmpty()) {
				Point p = que.poll();
				
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(safe(iy,ix)) {
						int tmp = min[p.y][p.x] + map[iy][ix];
						if(tmp < min[iy][ix]) {
							min[iy][ix] = tmp;
							que.add(new Point(iy,ix));
						}
					}
				}
			}
			System.out.println("#" + t+" " +min[N-1][N-1]);
		}
	}
	
	private static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<N && y<N) 
			return true;
		else
			return false;
	}
	
	private static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

}
