package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int step;
	static Queue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		que = new LinkedList<Point>();
		map = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		step = 0;
		que.add(new Point(0,0));
		bfs();
		System.out.println(step);
		
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			step++;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Point p = que.poll();
				if(p.y == N-1 && p.x == M-1) {
					que.clear();
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(!safe(iy,ix))
						continue;
					if(!flag[iy][ix] && map[iy][ix] == 1) {
						que.add(new Point(iy,ix));
						flag[iy][ix] = true;
					}
				}
				
			}
		}
	}
	
	static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<M && y<N)
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
