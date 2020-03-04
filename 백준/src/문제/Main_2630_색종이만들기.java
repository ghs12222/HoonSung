package 문제;

import java.util.Scanner;

public class Main_2630_색종이만들기 {

	static int N;
	static int[][] map;
	static int num1, num2;
	static boolean flag, endflag;
	static int cnt0, cnt1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		flag = true;
		endflag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		go(0,0, N, N);
		
	}
	
	private static void go(int y, int x, int m, int n) {
		num1 = map[y][x];
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if(map[i][j] != num1) {
					
					break;
				}
				
			}
		}
		
		
	}

}
