package 문제_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1946_신입사원_2 {
	
	static int T, N;
	static int[] num;
	static int cnt, min;
	static PriorityQueue<Point> que;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				que.add(new Point(n1,n2));
			}
			
			cnt = 1;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				System.out.println(que.poll().toString());
			}
			
//			for (int i = 0; i < N; i++) {
//				if(min>num[i]) {
//					min = num[i];
//				}
//				if(min == 1)
//					break;
//				if(min>num[i+1]) {
//					cnt++;
//				}
//			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	private static class Point implements Comparable<Point> {
		int n1;
		int n2;
		
		public Point(int n1, int n2) {
			super();
			this.n1 = n1;
			this.n2 = n2;
		}

		
		@Override
		public String toString() {
			return "Point [n1=" + n1 + ", n2=" + n2 + "]";
		}


		@Override
		public int compareTo(Point target) {
			if(this.n1 > target.n1)
				return 1;
			else
				return 0;
		}
		
	}
}
