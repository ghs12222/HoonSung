package Algo_0201;

import java.util.Arrays;
import java.util.Scanner;
public class Solution_1247_최적경로 {
	
	static int T;
	static int N;
	static int[][] company;
	static int[][] home;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			
			company = new int [0][1];
			home = new int [0][1];
			map = new int [N][N];
			company[0][0] = scann.nextInt();
			company[0][1] = scann.nextInt();
			home[0][0] = scann.nextInt();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = scann.nextInt();
				}
			}
			
			int[] len= new int[N];
			int tmpx;
			int tmpy;
			boolean[] flag = new boolean [N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < 2; k++) {
					}
				}
			}
			
			
			
		}
		
	}
	public static int Length (int x1, int y1, int x2, int y2) {
		int len = Math.abs(x1-x2) + Math.abs(y1-y2);
		return len;
	}
	

	
	public static void perm (int n, int r, int flag, int count) {
		if(r==count) {
			System.out.println(Arrays.toString(map));
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) { 
				map[count] = i + 1;
				perm(n, r, flag | 1 << i, count + 1);
			}
			
		}
	}

}
