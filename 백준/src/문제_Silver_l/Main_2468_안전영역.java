package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	
	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int day, max, count;
	static Queue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		
		day = 0;
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(day<map[i][j])
					day = map[i][j];
			}
		}
		
		for (int k = 1; k <= day; k++) {
			count = 0;
			flag = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > k && !flag[i][j]) {
						count++;
						que.add(new Point(i,j));
						flag[i][j] = true;
						bfs(k);
						if(max<count)
							max = count;
					}
				}
			}
		}
		if(max == Integer.MIN_VALUE)
			System.out.println("1");
		else
			System.out.println(max);
		
	}
	

	private static void bfs(int today) {
		while(!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x+dx[d];
				int iy = p.y+dy[d];
				if(!safe(iy,ix) || flag[iy][ix])
					continue;
				if(map[iy][ix] > today ) {
					que.add(new Point(iy,ix));
					flag[iy][ix] = true;
				}
			}
			
		}
	}
	
	static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<N && y<N)
			return true;
		else
			return false;
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
	
}
