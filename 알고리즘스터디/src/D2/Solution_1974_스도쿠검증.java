package D2;

import java.util.Scanner;

public class Solution_1974_스도쿠검증 {

	static int T;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] map = new int[9][9];
			boolean flag;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			flag = true;
			
			for (int i = 0; i < 9; i++) {
				if(!flag)
					break;
				String check1 = "";
				for (int j = 0; j < 9; j++) {
					String s = "" +map[i][j];
					if(check1.contains(s)) {
						flag = false;
						break;
					}
					check1 += map[i][j];
				}
			}
			
			for (int i = 0; i < 9; i++) {
				if(!flag)
					break;
				String check1 = "";
				for (int j = 0; j < 9; j++) {
					String s = "" +map[j][i];
					if(check1.contains(s)) {
						flag = false;
						break;
					}
					check1 += map[j][i];
				}
			}
			
			for (int n = 0; n < 3; n++) {
				if(!flag)
					break;
				for (int m = 0; m < 3; m++) {
					String check1 = "";
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							String s = ""+map[3*n+i][3*m+j];
							if(check1.contains(s)) {
								flag = false;
								break;
							}
							check1 +=map[3*n+i][3*m+j];
						}
					}
				}
			}
			
			
			if(flag)
				System.out.println("#"+t+" 1");
			else
				System.out.println("#"+t+" 0");
			
			
		}
	}
}
