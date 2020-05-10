package 문제_Gold_ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12100_2048_2 {

	static int N;
	static int[][] realmap, map;
	static int[] order;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		realmap = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				realmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		order = new int[5];
		max = Integer.MIN_VALUE;
		Permi(0);
		System.out.println(max);

	}

	private static void Permi(int count) {
		if (count == 5) {
			
			for (int i = 0; i < N; i++) {
				System.arraycopy(realmap[i], 0, map[i], 0, N);
			}
			GameStart();
			return;
		}

		for (int i = 0; i < 4; i++) {
			order[count] = i;
			Permi(count + 1);
			check();
		}

	}

	private static void check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(max<map[i][j])
					max = map[i][j];
			}
		}
	}

	private static void GameStart() {
		for (int size = 0; size < 5; size++) {
			int dir = order[size];
			int from = 0;
			int to = 0;
			if(dir <= 1) {
				from = N-1;
				to = 0;
			}
			else if(dir >= 2) {
				from = 0;
				to = N-1;
			}
			for (int i = from; i <= to; i++) {
				for (int j = from; j <= to; j++) {
					if (map[i][j] != 0) {
						int ix = j + dx[dir];
						int iy = i + dy[dir];
						while (safe(iy, ix)) {
							if (map[iy][ix] == 0) {
								ix +=dx[dir];
								iy +=dy[dir];
							}
							if(!safe(iy,ix)) {
								ix -=dx[dir];
								iy -=dy[dir];
								break;
							}
							else if(map[iy][ix] == map[i][j]) {
								map[i][j] = 0;
								map[iy][ix] = 0;
								int tmp = map[iy][ix]*2;
								while(safe(iy,ix) && map[iy][ix] == 0) {
									ix +=dx[dir];
									iy +=dy[dir];
								}
								ix -= dx[dir];
								iy -= dy[dir];
								map[iy][ix] = tmp;
							}
							else if(map[iy][ix] != 0)
								break;
						}
					}
				}
			}

//			Up(dir, from, to);
		}
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	private static void Up(int dir, int from, int to) {
		for (int i = from; i <= to; i++) {
			for (int j = from; j < to; j++) {
				if (map[i][j] != 0) {
					int ix = j + dx[dir];
					int iy = i + dy[dir];
					if(!safe(iy,ix))
						continue;
					int tmp = map[iy][ix];
					while (safe(iy, ix)) {
						if (map[iy][ix] == 0) {
							ix +=dx[dir];
							iy +=dy[dir];
						}
						if(!safe(iy,ix)) {
							ix -=dx[dir];
							iy -=dy[dir];
							break;
						}
						else
							break;
					}
					map[iy][ix] = tmp;
				}
			}
		}
	}

}
