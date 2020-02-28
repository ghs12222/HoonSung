package D4;

import java.util.Scanner;

public class Solution_1226_¹Ì·Î1 {

	static int T=10;
	static int[][] map;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			map = new int[16][16];
			
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			flag = false;
			dfs(1,1);
			if(flag == true)
				System.out.println("#"+t+" 1");
			else
				System.out.println("#"+t+" 2");
		}
		
	}

	private static void dfs(int y, int x) {
		if(map[y][x] == 3) {
			flag = true;
			return ;
		}
		
		for (int d = 0; d < 4; d++) {
			if(x>=0 && y>=0 && x<16 && y<16 && map[y+dy[d]][x+dx[d]] == 0) {
				dfs(y+dy[d],x+dx[d]);
			}
		}
		
	}

}
