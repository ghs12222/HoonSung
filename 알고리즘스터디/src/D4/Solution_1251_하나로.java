package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	
	static int T, N;
	static double E;
	static long[][] islands;
	static long[][] graph; // 정점들 간의 거리 그래프
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			///////////////////////////////////
			N = Integer.parseInt(br.readLine());
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			
			islands = new long[N][2];
			for (int i = 0; i < N; i++) {
				islands[i] = new long[] {Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken())};
			}
			
			E = Double.parseDouble(br.readLine());
			/////////////////////////////////
			graph = new long[N][N];
			long[] from, to;
			for (int r = 0; r < N; r++) {
				from = islands[r];
				for (int c = r+1; c < N; c++) {
					to = islands[c];
					graph[c][r] = graph[r][c] = (from[0] - to[0]) * (from[0] - to[0]) + (from[1] + to[1]) * (from[1] + to[1]);
				}
			}
			
			double cost = prim(0) * E;
			sb.append(Math.round(cost));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static double prim(int start) {
		
		//MST에 들어가지 않은 녀석득
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//모든 정점들을 다 관리..
		Edge[] dynamicGraph = new Edge[N];

		
		//아래 코드  잘못됨..
		for (int n = 0; n < dynamicGraph.length; n++) {
			dynamicGraph[n] = new Edge(n, Long.MAX_VALUE);
			if(n==start) {
				dynamicGraph[n].cost = 0;
			}
			pq.add(dynamicGraph[n]);
		}
		
		long cost = 0;
		while(!pq.isEmpty()) {
			Edge front = pq.poll(); //MST에 포함되는 녀석
			cost += front.cost;
			
			//자식 탐색
			for (int i = 0; i < dynamicGraph.length; i++) {
				Edge child = dynamicGraph[i];
				// pq: 비 MST
				if(pq.contains(child)) {
					long tempCost = graph[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.offer(child);
					}
				}
			}
		}
		
		return cost;
		
	}
	
	static class Edge implements Comparable<Edge> {
		int idx;
		long cost;
		public Edge(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [idx=" + idx + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(Edge o) {
			
//			return this.cost - o.cost>0 ? 1 : -1;
			return Long.compare(this.cost, o.cost);
		}
		
	}
	
}
