package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ing {
	
	static int T, N;
	static int[] mapx, mapy;
	static double tax;
	static int[] flag;
	static long res;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Point> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		pq = new PriorityQueue<Point>();
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			mapx = new int[N];
			mapy = new int[N];
			flag = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				mapx[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				mapy[i] = Integer.parseInt(st.nextToken());
			}
			tax = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				flag[i] = i;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long su = (long) Math.pow(mapx[i] - mapx[j], 2) + (long) Math.pow(mapy[i] - mapy[j], 2);
					pq.add(new Point(i,j,su));
				}
			}
			
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
					for (int k = 0; k < N; k++) {
						if(flag[k] == from) {
							flag[k] = to;
						}
					}
					
				}
			}
			sb.append(res).append("\n");
		}
		System.out.println(sb);
	}
	
	private static class Point implements Comparable<Point>{
		int from;
		int to;
		long dist;

		public Point(int from, int to, long dist) {
			super();
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Point o) {
			return Long.compare(this.dist, o.dist);
		}
	}
}
