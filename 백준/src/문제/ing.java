package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class ing { // 상범빌딩

	static int L, R, C;
	static char[][][] map;
	static boolean[][][] flag;
	static int[] dx = { 0, 1, 0, -1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<Point> que;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[L][R][C];
			flag = new boolean[L][R][C];

			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					String s = br.readLine();
					for (int j = 0; j < C; j++) {
						map[k][i][j] = s.charAt(j);
					}
				}
			}
			System.out.println("1");
			for (int k = 0; k < L; k++) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						System.out.print(map[k][i][j]);
					}
					System.out.println("0");
					System.out.println();
				}
				System.out.println();
			}

		} while (!(L == 0 && R == 0 && C == 0));

	}

	static boolean safe(int z, int y, int x) {
		if (y >= 0 && x >= 0 && z >= 0 && z < L && y < R && x < C)
			return true;
		else
			return false;
	}

	static class Point {
		int z;
		int y;
		int x;

		public Point(int z, int y, int x) {
			super();
			this.z = z;
			this.y = y;
			this.x = x;
		}

	}

}
