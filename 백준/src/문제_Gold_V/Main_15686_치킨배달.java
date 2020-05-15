package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] flag;
	static List<Integer>[] house;
	static List<Integer>[] chicken;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		house = new LinkedList[2];
		chicken = new LinkedList[4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					house[0].add(i);
				}
				
			}
		}
	}
	
	private static void bfs(int target) {
		
	}

	static boolean safe(int y, int x) { 
		if(x>=0 && y>=0 && x<N && y<N)
			return true;
		else
			return false;
	}
	
	
	static class Point {
		int y;
		int x;
		int depth;
		public Point(int y, int x, int depth, int count) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.count = count;
		}
		int count;
	}

}
