package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ing {

	static int N, M, Len;
	static int[][] fix_map, map;
	static boolean[][] flag;
	static int Enemy, Enemycnt, kill;
	static int[] Archer;
	static int Max;
	static PriorityQueue<Point> que, delete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();
		delete = new PriorityQueue<Point>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Len = Integer.parseInt(st.nextToken());
		
		fix_map = new int[N+1][M];
		map = new int[N+1][M];
		Archer = new int[3];
		Enemy = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				fix_map[i][j] = Integer.parseInt(st.nextToken());
				if(fix_map[i][j] == 1)
					Enemy++;
			}
		}
		
		
		Max = Integer.MIN_VALUE;
		Combi(0,0);
		
	}
	
	private static void Combi(int start, int count) {
		if(count == 3) {
			for (int i = 0; i < N+1; i++) {
				System.arraycopy(fix_map[i], 0, map[i], 0, M);
			}
			
			Enemycnt = Enemy;
			kill = 0;
			GameStart();
			Max = Math.max(Max, kill);
			return ;
		}
		
		for (int i = start; i < M; i++) {
			Archer[count] = i;
			Combi(i+1, count+1);
		}
	}
	
	private static void GameStart() {
		
	}
	
	
	private static void Down() {
		
	}
	
	private static class Point {
		int y;
		int x;
		int depth;
		
		public Point(int y, int x, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
		}
		
		
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	private static void Print() {
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
