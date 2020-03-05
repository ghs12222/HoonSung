package 문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public abstract class Main_15683_감시 {

	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static int cnt;
	static LinkedList<Point> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		flag = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] !=6) {
					list.add(new Point(i,j,0));
				}
			}
		}
		
		
		cnt = Integer.MAX_VALUE;
		
		while(true) {
			for (int i = 0; i < list.size(); i++) {
				Point p = list.get(i);
				
				
			}
			
			
			
			
			
			Combi(0,0);
		}
		
		
		
		
		
		
		
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
	}
	
	private static void Combi(int start, int count) {
		if(count == list.size()) {
			
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			
		}
		
	}

	private static class Point {
		int y;
		int x;
		int dir;
		
		public Point(int y, int x, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}

}
