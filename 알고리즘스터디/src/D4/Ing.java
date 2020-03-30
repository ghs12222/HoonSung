package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ing {

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
			list = new int[M][M];
			res = 0;
			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				x[i] = Integer.parseInt(st.nextToken());
//				y[i] = Integer.parseInt(st.nextToken());
//				z[i] = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
//				pq.add(new Point(x[i],y[i],z[i]));
				list[x][y] = list[y][x] = z;
				res += z;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(list[i][j]);
				}
				System.out.println();
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = i+1; j < N; j++) {
//					pq.add(new Point(x[i],y[j],z[i]));
//				}
//			}

			int cnt = 0;
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				if(cnt == N-1)
					break;
				if(flag[p.from] == flag[p.to]) {
					continue;
				}
				else if(flag[p.from] != flag[p.to]) {
					System.out.println("1");
					int from = flag[p.from];
					int to = flag[p.to];
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
