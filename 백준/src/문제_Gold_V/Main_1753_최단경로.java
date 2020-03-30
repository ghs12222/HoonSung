package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {

	static int V, E, Start;
//	static int[] len;
	static LinkedList<Point> list;
	static StringBuilder sb = new StringBuilder();
	
	static class Point implements Comparable<Point>{
		int from, to, dist;

		public Point(int from, int to, int dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		list = new LinkedList<Point>();
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(br.readLine());
		Point len[] = new Point[V];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Point(x,y,z));
			len[i] = list.peek();
		}
		
		Arrays.fill(len, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			
			
		}
		 
		
	}

}
