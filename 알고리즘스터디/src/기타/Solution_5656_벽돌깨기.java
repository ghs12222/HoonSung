package 기타;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기 {

	static int T, N, W, H;
	static int[][] map, smap;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int count, Max;
	static boolean[] visited;
	static int[] cnt;
	static int gamecnt;
	static Queue<Point> que;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();

		// 입력
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			flag = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// Permi
			Max = Integer.MIN_VALUE;
			visited = new boolean[W];
			cnt = new int[N];
			gamecnt = 0;
			Permi(0);

			System.out.println(Max);
		}

	}

	// Permi: smap을 map으로 저장 후에 게임 돌리기
	// 안에 Gamestart
	private static void Permi(int countPermi) {
		if (countPermi == N) {

			// Permi확인 출력
//			for (int i = 0; i < N; i++) {
//				System.out.print(cnt[i]+" ");
//			}
//			System.out.println();
//			return;

			// smamp에 원본 저장
			smap = new int[H][W];
			for (int i = 0; i < H; i++) {
				System.arraycopy(map[i], 0, smap[i], 0, W);
			}

			count = 0;
			Gamestart();
			if (Max < count) {
				Max = count;
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						System.out.print(smap[i][j]);
					}
					System.out.println();
				}
				System.out.print("cnt: ");
				for (int i = 0; i < cnt.length; i++) {
					System.out.print(cnt[i]+" ");
				}
				System.out.println();
				System.out.println("Max = " + Max);
			}
			return;
		}

		for (int i = 0; i < W; i++) {
			cnt[countPermi] = i;
			Permi(countPermi + 1);

		}

	}

	// Gamestart:폭탄 터지는거만 계산
	// N번 게임시작 전 flag 초기화, 벽돌 0으로 바꿔주기
	// 안에 Down
	private static void Gamestart() {

		for (int i = 0; i < N; i++) {
			flag = new boolean[H][W]; // 이위치가 맞나..?
			for (int j = 0; j < H; j++) {
				if (smap[j][cnt[i]] != 0) {
					if (smap[j][cnt[i]] != 1) {
						que.add(new Point(j, cnt[i], smap[j][cnt[i]] - 1));
						flag[j][cnt[i]] = true;
					}
					smap[j][cnt[i]] = 0;
					count++;
					break;
				}
			}

			while (!que.isEmpty()) {
				for (int j = 0; j < cnt.length; j++) {
					System.out.print(cnt[j]+" ");
				}
				System.out.println();
				for (int j = 0; j < H; j++) {
					for (int k = 0; k < W; k++) {
						System.out.print(smap[j][k]);
					}
					System.out.println();
				}
				System.out.println();
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					for (int k = 1; k <= p.size; k++) {
						int ix = p.x + dx[d] * k;
						int iy = p.y + dy[d] * k;
						if (safe(iy, ix) && smap[iy][ix] != 0 && !flag[iy][ix]) {
							if (smap[iy][ix] != 1) {
								que.add(new Point(iy, ix, smap[iy][ix] - 1));
							}
							flag[iy][ix] = true;
							smap[iy][ix] = 0;
							count++;
						}
					}
				}

			}
			// 밑으로보내기
			for (int n = H-1; n > 0; n--) {
				for (int m = 0; m < W; m++) {
					if (smap[n][m] != 0)
						Down(n, m);
				}
			}
		}

	}

	// Down

	private static void Down(int y, int ix) {
		int iy = y -1;
		if (safe(iy, ix) && map[iy][ix] == 0) {
			map[iy][ix] = map[y][ix];
			map[y][ix] = 0;
			Down(iy, ix);
		}
	}

	// safe
	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < W && y < H)
			return true;
		else
			return false;
	}

	// Point
	private static class Point {
		int y;
		int x;
		int size;

		public Point(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		}

	}

}
