package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질 {

	static int N, M;
	static boolean[] visit;
	static boolean[][] list;
	static int step, count, min;
	static Queue<Integer> que;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Integer>();
	
		N = Integer.parseInt(st.nextToken())+1;
		M	= Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		list = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from][to] = list[to][from] = true;
			
		}
		visit[1] = true;
		que.add(1);
//		for (int i = 1; i < N; i++) {
//			
//			if(list[1][i]) {
//				visit[i] = true;
//			}
//		}
		step=0;
		count = 0;
		bfs();
		System.out.print(min+" ");
		System.out.print(step-1);
		System.out.print(" "+ count);
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			int size = que.size();
			count = size;
			min = Integer.MAX_VALUE;
			for (int k = 0; k < size; k++) {
				int from = que.poll();
				if(min>from)
					min = from;
				for (int to = 0; to < N; to++) {
					if(list[from][to] && !visit[to]) {
						visit[to] = true;
						que.add(to);
					}
				}
			}
			step++;
		}
	}
	
}
