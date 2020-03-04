package 문제;

import java.util.Scanner;

public class Soluttion_3109_빵집 {

	static int R, C;
	static char[][] tempmap;
	static char[][] map;
	static boolean[][] flag;
	static boolean[][] check;
	static int[] dx = { -1, 0, 1 };
	static int[] dy = { 1, 1, 1 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		tempmap = new char[R][C];
		map = new char[R][C];
		flag = new boolean[R][C];
		check = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = sc.next();
			tempmap[i] = s.toCharArray();
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = tempmap[j][i];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		cnt = 0;
		for (int i = 0; i < R; i++) {
			dfs(i, 0);

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(flag[i][j])
					System.out.print("o");
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println(cnt);

//		while() {
//			for (int i = 0; i < R; i++) {
//				if(map[i][0] == 0) {
//					for (int d = 0; d < 3; d++) {
//						
//					}
//					
//					
//					
//					
//				}
//			}
//			
//			
//			
//		}

	}

	public static void dfs(int x, int y) {
		if (y == C - 1) {
			cnt++;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (check[i][j] == true)
						flag[i][j] = true;
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if(flag[i][j])
						System.out.print("o");
					else
						System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		if (map[x][y] == '.') {

			for (int d = 0; d < 3; d++) {
				int ix = x + dx[d];
				int iy = y + dy[d];
				if (ix >= 0 && iy >= 0 && ix < R && iy < C && map[iy][ix] == '.' && !flag[iy][ix] && !check[iy][ix]) {
					check[ix][iy] = true;
					dfs(ix, iy);
					check[ix][iy] = false;
				}
			}
		}

//		if(y==0) {
//			for (int i = 0; i < R; i++) {
//				if(map[i][0] == '.') {
//					for (int d = 0; d < 3; d++) {
//						int ix = x+dx[d];
//						int iy = y+1;
//						if(ix>=0 && iy>=0 && ix<R && iy<C && map[iy][ix] == '.' && !flag[iy][ix]) {
//							flag[ix][iy] = true;
//							dfs(ix,iy);
//						}
//					}
//				}
//				
//			}
//		}
//		else {
//			for (int d = 0; d < 3; d++) {
//				int ix = x+dx[d];
//				int iy = y+1;
//				boolean go = false;
//				if(ix>=0 && iy>=0 && ix<R && iy<C && map[iy][ix] == '.' && !flag[iy][ix]) {
//					flag[ix][iy] = true;
//					go = true;
//					dfs(ix,iy);
//				}
//				if(go==false)
//					flag[ix][iy] = false;
//			}
//			
//		}

	}

}
