package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {

	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int count;
	static Point p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		p = new Point(0,0,0);
		p.y = Integer.parseInt(st.nextToken());
		p.x = Integer.parseInt(st.nextToken());
		p.d = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		gameStart();
		System.out.println(count);
		
		
	}

	private static void gameStart() {
		while(true) {
			if(!flag[p.y][p.x]) {
				flag[p.y][p.x] = true;
				count++;
			}
			boolean check = true;
			boolean back = true;
			for (int d = 0; d < 4; d++) {
				p.d--;
				if(p.d < 0)
					p.d = 3;
				int ix = p.x+dx[p.d];
				int iy = p.y+dy[p.d];
				if(safe(iy,ix) && map[iy][ix] == 0) {
					if(!flag[iy][ix]) {
						p.x = ix;
						p.y = iy;
						check = false;
						break;
					}
				}
			}
			
			if(check) {
				int dir = p.d+2;
				if(dir > 3)
					dir -= 4;
				int ix = p.x + dx[dir];
				int iy = p.y + dy[dir];
				if(!safe(iy,ix) || map[iy][ix] == 1) {
					back = false;
				}
				else {
					p.x = ix;
					p.y = iy;
				}
			}
			if(!back)
				break;
			
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
		int d;
		public Point(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
		
	}
}
