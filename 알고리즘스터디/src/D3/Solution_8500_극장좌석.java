package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_8500_극장좌석 {

	static int T, N;
	static int[] num;
	static int res;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				que.add(new Point(num[i]));
			}
			que.poll();
			res = 0;
			while(que.isEmpty()) {
				Point p = que.poll();
				res += 2*p.n;
			}
			
			System.out.println(res);
			
		}
	}
	
	private static class Point implements Comparable<Point>{
		int n;

		public Point(int n) {
			super();
			this.n = n;
		}

		@Override
		public int compareTo(Point o) {
			if(this.n < o.n)
				return 1;
			else
				return -1;
		}
		
	}
}
