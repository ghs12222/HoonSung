package 문제_Gold_lV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2665_미로만들기 {

	static int N;
	static int[][] map;
	static int[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int min;
	static Queue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		que = new LinkedList<Point>();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flag = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
				Arrays.fill(flag[i], Integer.MAX_VALUE);
		}
		que.add(new Point(0,0,0));
		gameStart();
		System.out.println(flag[N-1][N-1]);
	}
	
	private static void gameStart() {
		while(!que.isEmpty()) {
			Point p = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int ix = p.x+dx[d];
				int iy = p.y+dy[d];
				if(!safe(iy,ix)) {
					continue;
				}
				
				if(map[iy][ix] == 1 && flag[iy][ix] > p.boom) {
					flag[iy][ix] = p.boom;
					que.add(new Point(iy,ix,p.boom));
				}
				else if(map[iy][ix] == 0 && flag[iy][ix] > p.boom+1) {
					flag[iy][ix] = p.boom+1;
					que.add(new Point(iy,ix,p.boom+1));
				}
			}
		}
	}

	static boolean safe(int y, int x) {
		if(y>=0 && x>=0 && x<N && y<N)
			return true;
		else
			return false;
	}
	
	static class Point {
		int y;
		int x;
		int boom;
		public Point(int y, int x, int boom) {
			super();
			this.y = y;
			this.x = x;
			this.boom = boom;
		}
	}
	
}
