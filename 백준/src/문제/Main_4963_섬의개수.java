package 문제;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963_섬의개수 {

	static int W, H;
	static int[][] map;
	static boolean[][] flag;
	static int cnt;
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {-1,-1,0,1,1,1,0,-1};
	static Queue<Point> que;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new LinkedList<Point>();
		
		while(true) {
			W = sc.nextInt();
			H = sc.nextInt();
			map = new int[H][W];
			flag = new boolean[H][W];

			if(W==0 && H==0)
				break;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			cnt = 0;
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(safe(i,j) && map[i][j] == 1 &&!flag[i][j]) {
						flag[i][j] = true;
						que.add(new Point(i,j));
						cnt++;
						
						while(!que.isEmpty()) {
							Point p = que.poll();
							for (int d = 0; d < 8; d++) {
								int ix = p.x + dx[d];
								int iy = p.y + dy[d];
								if(safe(iy,ix) && map[iy][ix] == 1 && !flag[iy][ix]) {
									flag[iy][ix] = true;
									que.add(new Point(iy,ix));
								}
							}
						}
					}
					
				}
			}
			
			System.out.println(cnt);
		
		}
		
	}
	
	private static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<W && y<H)
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
