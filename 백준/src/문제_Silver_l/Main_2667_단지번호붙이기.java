package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {

	static int N;
	static int[][] map;
	static int[] danzi;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int res;
	static Queue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		danzi = new int[N*N];
		Arrays.fill(danzi, 0);
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !flag[i][j]) {
					flag[i][j] = true;
					que.add(new Point(i,j));
					danzi[res]++;
					bfs();
					res++;
				}
			}
		}
		Arrays.sort(danzi);
		System.out.println(res);
		for (int i = 0; i < N*N; i++) {
			if(danzi[i] != 0)
			System.out.println(danzi[i]);
		}
	}
	
	private static void bfs() {
		while(!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(!safe(iy,ix))
						continue;
					if(map[iy][ix] == 1 && !flag[iy][ix]) {
						danzi[res]++;
						que.add(new Point(iy,ix));
						flag[iy][ix] = true;
					}
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
