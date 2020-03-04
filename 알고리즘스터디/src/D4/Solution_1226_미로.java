package D4;

import java.util.Scanner;

public class Solution_1226_¹Ì·Î {

	static int T = 10;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int sx,sy,ex,ey;
	static int res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			int tc = sc.nextInt();
			map = new int[16][16];
			flag = new boolean[16][16];
			res = 0;
			
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				char[] ch = s.toCharArray();
				for (int j = 0; j < 16; j++) {
					map[i][j] = ch[j]-'0';
					if(map[i][j]==2) {
						sx = j;
						sy = i;
					}
					if(map[i][j]==3) {
						ex = j;
						ey = i;
					}
					
				}
			}

			flag[sy][sx] = true;
			dfs(sy,sx);
			System.out.println("#"+t+" " + res);
		}
		
	}

	private static void dfs(int y, int x) {
		for (int d = 0; d < 4; d++) {
			int ix = x+dx[d];
			int iy = y+dy[d];
			if(map[iy][ix] == 0 && !flag[iy][ix]) {
				flag[iy][ix] = true;
				dfs(iy,ix);
				flag[iy][ix] = false;
			}
			else if(map[iy][ix] == 3) {
				res = 1;
				return;
			}
			
		}
		
	}

}
