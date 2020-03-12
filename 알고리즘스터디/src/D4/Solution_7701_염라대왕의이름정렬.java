package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution_7701_염라대왕의이름정렬 {

	static int T, N;
	static TreeSet<String> yo;
	static PriorityQueue<Point> pq;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<>();
		yo = new TreeSet<>();

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append("\n");
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				yo.add(br.readLine());
//				String s = br.readLine();
//				boolean check = true;
//				for (int j = 0; j < pq.size(); j++) {
//					if(pq.equals(s))
//						check = false;
//				}
//				if(check)
//					pq.add(new Point(s));
			}

			int count = yo.size();
			for (int i = 0; i < count; i++) {
				pq.add(new Point(yo.pollFirst()));
			}
			
//			for (int i = 0; i < count; i++) {
//				System.out.println(pq.poll().toString());
//			}
			
			for (int i = 0; i < count; i++) {
				sb.append(pq.poll()).append("\n");
			}

		}
		System.out.println(sb);
	}

	private static class Point implements Comparable<Point> {
		String s;

		public Point(String s) {
			super();
			this.s = s;
		}

		@Override
		public String toString() {
			return s;
		}

		@Override
		public int compareTo(Point o) {
			if (this.s.length() > o.s.length())
				return 1;
			else if (this.s.length() == o.s.length()) {
				char[] c1 = this.s.toCharArray();
				char[] c2 = o.s.toCharArray();
				for (int i = 0; i < c2.length; i++) {
					if (c1[i] > c2[i])
						return 1;
				}
			}
			return -1;
		}

	}

}
