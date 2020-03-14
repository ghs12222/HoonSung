package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int N, M;
	static int[][] fix_map, map;
	static boolean[][] flag;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int cheezecnt, time;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fix_map = new int[N][M];
		map = new int[N][M];
		flag = new boolean[N][M];
		System.out.println("N = " + N + ", M = " + M);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				fix_map[i][j] = Integer.parseInt(st.nextToken());
				if (fix_map[i][j] == 0) {
					for (int d = 0; d < 4; d++) {
						int ix = j+dx[d];
						int iy = i+dy[d];
						if(!safe(iy,ix)) {
							fix_map[i][j] = 2;
							break;
						}
					}
				}
			}
		}

		
		time = 0;
		cheezecnt = 0;

		gameStart();

	}
	
	private static void gameStart() {
		boolean gameover = false;
		while (!gameover) {
			gameover = true;
			for (int i = 0; i < N; i++) {
//				System.arraycopy(fix_map[i], 0, map, 0, M);
				System.arraycopy(fix_map[i], 0, map[i], 0, M);
			}
			
			Print();

		}
	}

	private static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.print("\t");
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && x < M && y >= 0 && y < N)
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
