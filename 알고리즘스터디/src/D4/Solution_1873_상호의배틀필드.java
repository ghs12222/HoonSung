package D4;

import java.util.Scanner;

public class Solution_1873_상호의배틀필드 {

	static int T;
	static int H;
	static int W;
	static char[][] map;
	static int N;
	static char[] order;
	static int x, y;
	static char[] dir = { '^', '>', 'v', '<' };
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();

		for (int t = 1; t <= T; t++) {
			H = scann.nextInt();
			W = scann.nextInt();
			map = new char[H][W];
//			for(int i )
			int d = 0; // ������ ��ȣ
			String s; // �Է°� �ޱ�

			for (int i = 0; i < H; i++) {
				s = scann.next();
				map[i] = s.toCharArray();
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^') {
						d = 0;
						x = j;
						y = i;
						break;
					}

					else if (map[i][j] == '>') {
						d = 1;
						x = j;
						y = i;
						break;
					}

					else if (map[i][j] == 'v') {
						d = 2;
						x = j;
						y = i;
						break;
					}

					else if (map[i][j] == '<') {
						d = 3;
						x = j;
						y = i;
						break;
					}
				}
			}

			N = scann.nextInt();
			s = scann.next();
			order = s.toCharArray();

			for (int i = 0; i < N; i++) {

				// ��ũ �̵�
				if (order[i] == 'U') {
					d = 0;
					map[y][x] = dir[d];
					int ix = x + dx[d];
					int iy = y + dy[d];
					if (ix >= 0 && iy >= 0 && ix < W && iy < H && map[iy][ix] == '.') {
						map[y][x] = '.';
						x = ix;
						y = iy;
						map[y][x] = dir[d];
					}
				}

				if (order[i] == 'R') {
					d = 1;
					map[y][x] = dir[d];
					int ix = x + dx[d];
					int iy = y + dy[d];
					if (ix >= 0 && iy >= 0 && ix < W && iy < H) {
						if (map[iy][ix] == '.') {
							map[y][x] = '.';
							x = ix;
							y = iy;
							map[y][x] = dir[d];
						}
					}
				}

				if (order[i] == 'D') {
					d = 2;
					map[y][x] = dir[d];
					int ix = x + dx[d];
					int iy = y + dy[d];
					if (ix >= 0 && iy >= 0 && ix < W && iy < H) {
						if (map[iy][ix] == '.') {
							map[y][x] = '.';
							x = ix;
							y = iy;
							map[y][x] = dir[d];
						}
					}
				}

				if (order[i] == 'L') {
					d = 3;
					map[y][x] = dir[d];
					int ix = x + dx[d];
					int iy = y + dy[d];
					if (ix >= 0 && iy >= 0 && ix < W && iy < H) {
						if (map[iy][ix] == '.') {
							map[y][x] = '.';
							x = ix;
							y = iy;
							map[y][x] = dir[d];
						}
					}
				}

				if (order[i] == 'S') {
					int ix = x + dx[d];
					int iy = y + dy[d];
					while (ix >= 0 && iy >= 0 && ix < W && iy < H) {
						if (map[iy][ix] == '.' || map[iy][ix] == '-') {
							ix += dx[d];
							iy += dy[d];
						} else if (map[iy][ix] == '#') {
							break;
						} else if (map[iy][ix] == '*') {
							map[iy][ix] = '.';
							break;
						}

					}

				}

			}

			System.out.print("#" + t + " ");
			for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}

		}

	}

}
