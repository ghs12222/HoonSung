package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {

	static int N, K;
	static int[][] map;
	static List <Point> [][] info;
	static boolean[][] cnt;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int time;
	static boolean end;
	static LinkedList<Point> list;
	static LinkedList<Integer> mal;
	static Stack<Integer> stack = new Stack<Integer>();
	
	static StringBuilder sb = new StringBuilder();
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			list.add(new Point(i, y, x, d));
			
		}
		
		time = 0;
		end = false;
		start();
		
		if(end)
			System.out.println("-1");
		else
			System.out.println(time);
		

	}

	private static void start() {
		if(time>1000) 
			end = true;

		
		while(time>1000) {
			for (int i = 0; i < K; i++) {
				Point p = list.get(i);
				int ix = p.x+dx[p.d];
				int iy = p.y+dy[p.d];
				int id = p.d;
				
				if(safe(iy,ix)) {
					if(map[iy][ix] == 0) {
						list.remove(i);
						list.add(i, new Point(i,iy,ix,id));
					}
					
					if(map[iy][ix] == 1) {
						
					}
					
					if(map[iy][ix] == 2) {
						
					}
				}
				
			}
			
			
		}
	}

	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	private static class Point {
		int horsenum;
		int y;
		int x;
		int d;

		public Point(int horsenum, int y, int x, int d) {
			super();
			this.horsenum = horsenum;
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

}
