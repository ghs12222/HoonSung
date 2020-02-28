package D4;

import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기 {

	static int T, N;
	static char[][] cmap;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			cmap = new char[N][N];
			map = new int[N][N];
			flag = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				cmap[i] = s.toCharArray();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(cmap[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					if(cmap[i][j] == '*') {
						map[i][j] = -1;
						break;
					}
					for (int d = 0; d < 8; d++) {
						int ix = j + dx[d];
						int iy = i + dy[d];
						if(ix>=0 && iy>=0 && ix<N && iy<N && cmap[iy][ix] =='*') {
							cnt++;
						}
					}
						map[i][j] = cnt;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();

		}

	}

}
