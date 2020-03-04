package Study.Algo;

import java.util.Scanner;

public class Solution_2806_nQeen {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();
			int[][] map = new int[N][N];
			boolean[][] map_check = new boolean [N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map_check[i][j] == false && map[i][j] ==0) {
						map_check[i][j] = true;
						for (int x = 0; x < N; x++) {
							map[x][j] = 1;
						}
						for (int x = 0; x < N; x++) {
							map[i][x] = 1;
						}
						for (int x = 0; x < N; x++) {
							map[][] = 1;
						}
					}
					
				}
			}
			
			
			
		}
	}

}
