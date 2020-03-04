package Study_0204;

import java.util.Scanner;

public class Solution_7699_수지의수지맞는여행2 {

	static int T;
	static int R;
	static int C;
	static char[][] map;
	static boolean[] alphabet;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int d;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			R = scann.nextInt();
			C = scann.nextInt();
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				String s = scann.next();
				map[i] = s.toCharArray();
			}
			
			
			
			
			
		}
	}
	
	public static void Tri(int y, int x, int count) {
		d=0;
		if(y+dy[d]>=0 && y+dy[d]<R && x+dx[d]>=0 && x+dx[d]<C) {
			
		}
	}

}
