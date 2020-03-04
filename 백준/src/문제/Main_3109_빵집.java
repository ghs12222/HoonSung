package 문제;

import java.util.Scanner;

public class Main_3109_빵집 {

	static int R, C;
	static char[][] map;
	static boolean[][] flag;
	static boolean arrival;
	static int[] dx = { 1, 1, 1 };
	static int[] dy = { -1, 0, 1 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		flag = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = sc.next();
			map[i] = s.toCharArray();
		}
		
		cnt = 0;
		for (int i = 0; i < R; i++) {
			if(map[i][0] == '.') 
				arrival = false;
				dfs(i,0);
		}
		System.out.println(cnt);
	}
	
	
	
	private static void dfs(int y, int x) {
		if(x == C-1) {
			arrival = true;
			cnt ++;
			return;
		}
		for (int d = 0; d < 3; d++) {
			if(arrival)
				break;
			int ix = x+dx[d];
			int iy = y+dy[d];
			if(safe(iy,ix) && map[iy][ix] == '.' && !flag[iy][ix] && !arrival) {
				flag[iy][ix] = true;
				dfs(iy,ix);
//				if(!arrival) {
//					flag[iy][ix] = false;
//				}
//				else
//					break;
			}
		}
		
	}



	private static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<C && y<R) 
			return true;
		else
			return false;
					
	}

}
