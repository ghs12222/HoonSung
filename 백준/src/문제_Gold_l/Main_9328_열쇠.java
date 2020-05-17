package 문제_Gold_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9328_열쇠 {

	static int T, N, M;
	static char[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static boolean[] key;
	static int docucnt;
	static Queue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) + 2;
			M = Integer.parseInt(st.nextToken()) + 2;
			map = new char[N][M];
			flag = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i], '.');
			}
			for (int i = 1; i < N - 1; i++) {
				String s = br.readLine();
				for (int j = 1; j < M - 1; j++) {
					map[i][j] = s.charAt(j - 1);
				}
			}
			key = new boolean[26];
			String K = br.readLine();
			char e = K.charAt(0);
			if (e != '0') {
				for (int i = 0; i < K.length(); i++) {
					int target = K.charAt(i) - 'a';
					key[target] = true;
				}
			}
			docucnt = 0;
			que.add(new Point(0, 0));
			flag[0][0] = true;
			bfs();

			System.out.println(docucnt);
		}
	}

	private static void bfs() {
		while (!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x + dx[d];
				int iy = p.y + dy[d];
				if (!safe(iy, ix) || map[iy][ix] == '*' || flag[iy][ix])
					continue;
				if (map[iy][ix] == '$') {
					docucnt++;
					map[iy][ix] = '.';
				}
				int target = map[iy][ix] - 'a';
				if (target >= 0 && target <= 25) {
					if (!key[target]) {
						key[target] = true;
						flag = new boolean[N][M];
						flag[iy][ix] = true;
						map[iy][ix] = '.';
						que.clear();
						que.add(new Point(iy, ix));
						break;
					} else
						map[p.y][p.x] = '.';
				}
				target = map[iy][ix] - 'A';
				if (target >= 0 && target <= 25 && key[target]) {
					map[iy][ix] = '.';
				}
				if (map[iy][ix] == '.') {
					que.add(new Point(iy, ix));
					flag[iy][ix] = true;
				}
			}
		}
	}

	private static void Print() {
		System.out.println("getkey");
		for (int j = 0; j < 26; j++) {
			if (key[j])
				System.out.print("1");
			else
				System.out.print("0");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();

		}
		System.out.println();
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < M && y < N)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

}
