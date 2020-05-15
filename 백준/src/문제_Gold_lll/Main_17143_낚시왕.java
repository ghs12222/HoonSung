package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	
	static int N, M, K;
	static int[] dx = {0, 0, 0, 1, -1};
	static int[] dy = {0, -1, 1, 0, 0};
	static int eatCnt;
	static LinkedList<Point> shark;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		shark = new LinkedList<Point>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			shark.add(new Point(r,c,s,d,z));
		}
		
		eatCnt = 0;
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int size = shark.size();
			int target = -1;
			int targetSize = -1;
			for (int k = 0; k < size; k++) {
				Point p = shark.get(k);
				if(p.x == i && min>p.y) {
					min = p.y;
					target = k;
					targetSize = p.size;
				}
			}
			if(target != -1) {
				eatCnt += targetSize;
				shark.remove(target);	//이게 되나?
			}
			
		}
	}
	
	static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<M && y<N)
			return true;
		else
			return false;
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
