package D2;

import java.util.Scanner;

public class Solution_2005_ÆÄ½ºÄ®ÀÇ»ï°¢Çü {

	static int T;
	static int N;
//	static int[][] num;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			int[][] num = new int[N+1][N+1];
			num[1][1] = 1;
			System.out.println("#"+t);
			System.out.println(num[1][1]);
			for (int i = 2; i < N+1; i++) {
				for (int j = 1; j <= i; j++) {
					num[i][j] = num[i-1][j-1] + num[i-1][j];
					System.out.print(num[i][j]+" ");
				}
				System.out.println();
			}	
		}
	}

}
