package D3;

import java.util.Scanner;

public class Solution_2805_농작물수확하기 {

	static int T;
	static int N;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = scann.next();
				char ch_map[] = s.toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = (int)ch_map[j]-'0';
				}
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			int mid = (N+1)/2-1;
			int x = mid;
			int y =  mid;
			int res=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if((Math.abs(mid-j)+Math.abs(mid-i))<=mid) {
						res+=map[i][j];
					}				
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}

}
