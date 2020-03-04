package Study_3rd;

import java.util.Scanner;

public class Solution_¥ﬁ∆ÿ¿Ã {

	static int T;
	static int N;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		T = scann.nextInt();

		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			int[][] map = new int[N][N];
			int num = 1;
			int d = 0;
			int x=0;
			int y=0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[y][x] = num;
					num++;
					if(x+dx[d]>=N || x+dx[d]<0 || y+dy[d]>=N || y+dy[d]<0) {
						d++;
						if(d==4)
							d=0;
					}
					y+=dy[d];
					x+=dx[d];
					
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[j][i]);
				}
				System.out.println();
			}
		}
	}

}
