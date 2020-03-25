package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_6497_전력난 {

	static int M, N;
	static int[][] list;
	static int[] flag;
	static int price;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Point> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		while(!(M == 0 && N == 0)) {
			pq = new PriorityQueue<Point>();
			list = new int[M][M];
			flag = new int[M];
			price = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				list[y][x] = list[x][y] = z;
				price+=z;
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = i+1; j < M; j++) {
					pq.add(new Point(i, j, list[i][j]));
				}
			}
//			int cnt = pq.size();
//			
//			for (int i = 0; i < cnt; i++) {
//				System.out.println(pq.poll());
//			}
//			System.out.println();
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(list[i][j]);
//				}
//				System.out.println();
//			}
			
			for (int i = 0; i < M; i++) {
				flag[i] = i;
			}
			int res = 0;
			int cnt = 0;
			int size = pq.size();
			for (int i = 0; i < size; i++) {
				Point p = pq.poll();
				if(cnt == N-1)
					break;
				if(flag[p.from] == flag[p.to])
					continue;
				else if(flag[p.from] != flag[p.to]) {
					int from = p.from;
					int to = p.to;
					res += p.dist;
					cnt++;
					for (int k = 0; k < M; k++) {
						if(flag[k] == from) {
							flag[k] = to;
						}
					}
				}
				
			}
			price -= res;
			System.out.println(price);
			
			
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
		}
	}
	
	private static class Point implements Comparable<Point> {
		int from;
		int to;
		int dist;
		
		@Override
		public String toString() {
			return "Point [from=" + from + ", to=" + to + ", dist=" + dist + "]";
		}

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
