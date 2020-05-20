package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	
	static int N, M, T;
	static LinkedList<Point>[] list;
	static int res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[M];
		for (int i = 0; i < M; i++) {
			list[i] = new LinkedList<Point>();
		}
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			list[x].add(new Point(y,x,speed,dir,size));
		}
		
		for (int i = 0; i < M; i++) {
			if(!list[i].isEmpty()) {
				Eat(i);
			}
			
		}
	}
	
	private static void Eat(int target) {
		int size = list[target].size();
		int min = Integer.MAX_VALUE;
		int tg = 0;
		for (int s = 0; s < size; s++) {
			if(min<list[target].get(s).y) {
				min = list[target].get(s).y;
				tg = s;
			}
		}
		res += list[target].get(tg).size;
		list[target].remove(tg);
	}

	static class Point {
		int y;
		int x;
		int speed;
		int dir;
		int size;
		public Point(int y, int x, int speed, int dir, int size) {
			super();
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
	
}
