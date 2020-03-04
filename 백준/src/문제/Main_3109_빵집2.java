package ¹®Á¦;

import java.util.Scanner;

public class Main_3109_»§Áý2 {

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
		
		
		
	}
	

	private static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<C && y<R) 
			return true;
		else
			return false;
					
	}

}
