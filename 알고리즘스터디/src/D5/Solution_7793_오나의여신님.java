package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {

	static int T;
	static int N, M;
	static char[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int ResStep;
	static Queue<Point> que;
	static Queue<Point> fire;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		fire = new LinkedList<Point>();
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			flag = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == 'S') {
						flag[i][j] = true;
						map[i][j] = '.';
						que.add(new Point(i, j, 0));
					}
					else if (map[i][j] == '*')
						fire.add(new Point(i, j, 0));
				}
			}
			
			ResStep = 0;
			gameStart();
			if(ResStep != 0)
				sb.append("#").append(t).append(" ").append(ResStep).append("\n");
			else
				sb.append("#").append(t).append(" ").append("GAME OVER").append("\n");
			
		}
		System.out.println(sb);

	}

	private static void gameStart() {
		while (!que.isEmpty()) {
			int count = fire.size();
			for (int k = 0; k < count; k++) {
				Point p = fire.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(!safe(iy,ix))
						continue;
					if(map[iy][ix] =='.') {
						map[iy][ix] = '*';
						fire.add(new Point(iy,ix,0));
					}
				}
			}
			
			count = que.size();
			for (int k = 0; k < count; k++) {
				Point p = que.poll();
				if(map[p.y][p.x] == 'D') {
					ResStep = p.step;
					que.clear();
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(!safe(iy,ix) || flag[iy][ix])
						continue;
					if(map[iy][ix] != '*' && map[iy][ix] != 'X') {
						flag[iy][ix] = true;
						que.add(new Point(iy,ix,p.step+1));
					}
				}
			}


		}

	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}

	private static class Point {
		int y;
		int x;
		int step;

		public Point(int y, int x, int step) {
			super();
			this.y = y;
			this.x = x;
			this.step = step;
		}
	}

}
