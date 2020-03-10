package 문제;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main_16236_아기상어2 {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = {0,-1,1,0};
	static int[] dy = {-1,0,0,1};
	static int agisize, sizecnt;
	static int time, timecnt;
	static PriorityQueue<Point> que;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		que = new PriorityQueue<Point>();
		
		N = sc.nextInt();
		map = new int[N][N];
		flag = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					que.add(new Point(i,j));
					flag[i][j] = true;
					map[i][j] = 0;
				}
			}
		}
		
		agisize = 2;
		sizecnt = 0;
		time = 0;
		timecnt = 0;

		while(!que.isEmpty()) {
			int count = que.size();
			for (int k = 0; k < count; k++) {
				Point p = que.poll();
				boolean eat = false;
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(safe(iy,ix) && map[iy][ix] <= agisize && !flag[iy][ix]) {
						if(map[iy][ix] == agisize || map[iy][ix] == 0) {
							flag[iy][ix] = true;
							que.add(new Point(iy,ix));
						}
						else {
							sizecnt++;
							if(sizecnt == agisize) {
								agisize++;
								sizecnt = 0;
							}
							timecnt++;
							time += timecnt;
							timecnt = 0;
							
							map[iy][ix] = 0;
							flag = new boolean[N][N];
							flag[iy][ix] = true;
							que.clear();
							que.add(new Point(iy,ix));
							eat = true;
							break;
						}
					}
				}
				if(eat) {
					break;
				}
				timecnt++;
			}
		}
		System.out.println(time);
	}
	
	private static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<N && y<N) 
			return true;
		else
			return false;
	}
	
	
	private static class Point implements Comparable<Point>{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Point o) {
			if(this.y > o.y) 
				return 1;
			else if (this.y == o.y) {
				if(this.x > o.x) 
					return 1;
				else
					return -1;
			}
			else
				return -1;
			
			
			
//			if(this.y < o.y) {
//				if(this.x <o.x)
//					return 1;
//				else
//					return -1;
//			}
//			
//			else {
//				if(this.x <o.x)
//					return 1;
//				else
//					return -1;
//			}
		}
		
	}
}
