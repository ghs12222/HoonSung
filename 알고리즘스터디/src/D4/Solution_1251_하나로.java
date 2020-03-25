package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

	static int T, N;
	static int[] xmap, ymap;
	static int[] flag;
	static double tax;
	static long res;
	static PriorityQueue<Point> pq;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			pq = new PriorityQueue<Point>();
			N = Integer.parseInt(br.readLine());
			xmap = new int[N];
			ymap = new int[N];
			flag = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xmap[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ymap[i] = Integer.parseInt(st.nextToken());
			}
			tax = Double.parseDouble(br.readLine());
			int union = 1;
			for (int i = 0; i < N; i++) {
				flag[i] = union++;
			}
//			for (int i = 0; i < N; i++) {
//				flag[i] = i;
//			}
//			System.out.println("flag = " + Arrays.toString(flag));
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long su = (long) Math.pow(xmap[i] - xmap[j], 2) + (long) Math.pow(ymap[i] - ymap[j], 2);
					pq.add(new Point(i, j, su));
				}
			}
//			System.out.println("pq = " + pq.toString());
			res = 0;
			int cnt = 0;
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				if (cnt == N - 1)
					break;
				if (flag[p.from] == flag[p.to])
					continue;
				else if (flag[p.from] != flag[p.to]) {
					int from = flag[p.from];
					int to = flag[p.to];
					res += p.dist;
					cnt++;
					for (int k = 0; k < N; k++) {
						if (flag[k] == to) {
							flag[k] = from;
						}
					}
				}

			}

			sb.append("#").append(t).append(" ").append((long) (Math.round(res * tax))).append("\n");
		}
		System.out.println(sb);

	}

	static class Point implements Comparable<Point> {
		int from;
		int to;
		long dist;

		public Point(int from, int to, long dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
//			return Long.compare(this.dist, o.dist);
			if(this.dist < o.dist) {
				return -1;
			}
			else if(this.dist>o.dist) {
				return 1;
			}
			else
				return 0;

		}

		@Override
		public String toString() {
			return "Point [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}

	}

}
