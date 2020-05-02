package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {

	static int A, B;
	static int N, M;
	static int[][] map;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean end;
	static Point[] robots;

	static class Point {
		int y;
		int x;
		int dir;

		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", dir=" + dir + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B][A];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		robots = new Point[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			robots[i + 1] = new Point(0, 0, 0);
			robots[i + 1].x = Integer.parseInt(st.nextToken())-1;
			robots[i + 1].y = Integer.parseInt(st.nextToken())-1;
			map[robots[i + 1].y][robots[i + 1].x] = i + 1;
			String t = st.nextToken();
			char s = t.charAt(0);
			if (s == 'N')
				robots[i + 1].dir = 0;
			else if (s == 'E')
				robots[i + 1].dir = 1;
			else if (s == 'S')
				robots[i + 1].dir = 2;
			else if (s == 'W')
				robots[i + 1].dir = 3;
		}
		end = false;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			char command = c.charAt(0);
			int count = Integer.parseInt(st.nextToken());

			if (end)
				break;
			for (int k = 0; k < count; k++) {
				if (command == 'F') {
					Print();
					map[robots[num].y][robots[num].x] = 0;
					int ix = robots[num].x + dx[robots[num].dir];
					int iy = robots[num].y + dy[robots[num].dir];
					if (!safe(iy, ix)) {
						System.out.println("Robot "+num+" crashes into the wall");
						end = true;
						break;
					}

					if (map[iy][ix] != 0) {
						System.out.println("Robot "+num+" crashes into robot "+map[iy][ix]);
						end = true;
						break;
					}
					
					map[iy][ix] = num;
					robots[num].x = ix;
					robots[num].y = iy;
					
				}

				else if (command == 'L') {
					robots[num].dir++;
					if (robots[num].dir > 3)
						robots[num].dir = 0;
				}

				else if (command == 'R') {
					robots[num].dir--;
					if (robots[num].dir < 0)
						robots[num].dir = 3;
				}
			}
			
			Print();
		}

		if (!end)
			System.out.println("OK");

	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < A && y < B)
			return true;
		else
			return false;
	}
	
	static void Print() {
		for (int i = 0; i < B; i++) {
			for (int j = 0; j < A; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
