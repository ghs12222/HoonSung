package D3;

import java.util.Scanner;

public class Solution_7236_저수지의물의총깊이구하기2 {

	static int T;
	static int N;
	static char[][] map;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map = new char[N][N];
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					String s = scann.next();
					map[i][j] = s.charAt(0);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'W') {
						int d = 0;
						int cnt = 0;
						for (int k = 0; k < 8; k++) {
							int x = j + dx[d];
							int y = i + dy[d];
							if (x >= 0 && x < N && y >= 0 && y < N) {
								if (map[y][x] == 'W')
									cnt++;
							}
							d++;
						}
						if (res < cnt)
							res = cnt;
					}
				}
			}
			if(res == 0)
				res = 1;
			System.out.println("#"+t+" "+res);

		}
	}

}
