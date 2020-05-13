package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2931_가스관2 {

	static int N, M;
	static char[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 }; // 북동남서
	static int[] dy = { -1, 0, 1, 0 };
	static int sy, sx, ey, ex, dir;
	static boolean end;
	static char result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'M') {
					sy = i;
					sx = j;
				} else if (map[i][j] == 'Z') {
					ey = i;
					ex = j;
				}
			}
		}

		for (int d = 0; d < 4; d++) {
			int ix = sx+dx[d];
			int iy = sy+dy[d];
			if (safe(iy,ix) && map[iy][ix] != '.') {
				dir = d;
			}
		}
		end = false;
		flag[sy][sx] = true;
		System.out.println("sy = " + sy + ", sx = " + sx);
		dfs(sy, sx, dir);
		System.out.println(result);

	}

	static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void dfs(int y, int x, int d) {
		if(end)
			return;
		Print();
		int ix = x + dx[d];
		int iy = y + dy[d];
		if(!safe(iy,ix))
			return;
		flag[iy][ix] = true;
		
		if (map[iy][ix] == '.') {
			check(iy,ix,dir);
			end = true;
			return;
		}
		else if(map[iy][ix] == '+')
			flag[iy][ix] = false;
		else if((map[iy][ix] -'0') %2 != 0) {
			if(dir == 0)
				dir = 1;
			else if (dir == 1)
				dir = 0;
			else if(dir == 2)
				dir = 3;
			else if(dir ==3)
				dir = 2;
		}
		else if(map[iy][ix] - '0' %2 == 0) {
			if (dir == 1)
				dir = 2;
			else if(dir == 2)
				dir = 1;
			else if (dir == 0 )
				dir = 3;
			else if(dir == 3)
				dir = 0;
		}
		dfs(iy,ix,dir);

	}

	static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<M && y<N)
			return true;
		else
			return false;
	}
	
	private static void check(int y, int x, int direction) {
		int cnt = 0;
		boolean[] res = new boolean[4];
		for (int d = 0; d < 4; d++) {
//			if(d == direction)
//				continue;
			System.out.println("y = " + y + ", x = " + x + ", dir = " + direction);
			if(map[y][x] != '.') {
				System.out.println("?????");
				if(d %2 == 0 && (map[y][x] == '|' || map[y][x] == '+' || map[y][x] == '2' || map[y][x] == '3')) {
					res[d] = true;
					cnt++;
				} else if(d % 2 != 0 && (map[y][x] == '-' || map[y][x] == '+' || map[y][x] == '1' || map[y][x] == '4')) {
					res[d] = true;
					cnt++;
				} 
			}
		}
		for (int i = 0; i < res.length; i++) {
			System.out.println("res["+i+"] = " + res[i]);
		}
		if(cnt==4) {
			result = '+';
		return;
		}
		if(res[0] && res[2])
			result = '|';
		else if(res[1] && res[3])
			result = '-';
		else if(res[1] && res[2])
			result = '1';
		else if(res[0] && res[1])
			result = '2';
		else if(res[3] && res[0])
			result = '3';
		else if(res[3] && res[2])
			result = '4';
		return;
	}

}
