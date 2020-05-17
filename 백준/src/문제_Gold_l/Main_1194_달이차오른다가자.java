package 문제_Gold_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {

	static int N, M;
	static int[][] map;
	static boolean[][][] flag;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int res;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M][64];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '0') {
					map[i][j] = '.';
					que.add(new Point(i,j,0,0));
					Arrays.fill(flag[i][j], true);
				}
			}
		}
		
		gamestart();
		
		
	}
	
	private static void gamestart() {
		
		while(!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				Point p = que.poll();
				
				if(map[p.y][p.x] == '1') {
					que.clear();
					res = p.depth;
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(!safe(iy,ix) || map[iy][ix] == '#')
						continue;
					
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
		int count;
		int depth;
		public Point(int y, int x, int count, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
			this.depth = depth;
		}
	}
}
