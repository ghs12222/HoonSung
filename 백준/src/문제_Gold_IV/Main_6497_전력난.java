package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6497_전력난 {

	static int M, N;
	static int[] flag;
	static int[] x, y, z;
	static int[][] list;
	static int res;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		while (!(N == 0 && M == 0)) {
			pq = new PriorityQueue<Point>();
			flag = new int[M];
			res = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				pq.add(new Point(x,y,z));
				res += z;
			}
			
			int cnt = 0;
			int size = pq.size();
			for (int i = 0; i < M; i++) {
				flag[i] = i;
			}
			for (int i = 0; i < size; i++) {
				System.out.println("2");
				Point p = pq.poll();
				if(cnt == N-1)
					break;
				int from = flag[p.from];
				int to = flag[p.to];
				if(from != to) {
					System.out.println("1");
					res -= p.dist;
					cnt++;
					for (int j = 0; j < M; j++) {
						if(flag[j] == from)
							flag[j] = to;
					}
				}
			}
			System.out.println(res);
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
		}

	}

	static class Point implements Comparable<Point> {
		int from;
		int to;
		int dist;

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

}
