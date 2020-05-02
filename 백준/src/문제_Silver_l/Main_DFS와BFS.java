package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_DFS와BFS {

	static int N, M, V;
	static int[] list, cnt;
	static boolean[] visited;
	static boolean[][] flag;
	static Queue<Integer> que;
	static StringBuilder sb =  new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Integer>();
		N = Integer.parseInt(st.nextToken())+1;
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		que.add(V);
		
		list = new int[N];
		visited = new boolean[N];
		flag = new boolean[N][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			flag[from][to] = flag[to][from] = true;
			
		}
		sb.append(V).append(" ");
		visited[V] = true;
		dfs(V);
		sb.append("\n");
		visited = new boolean[N];
		sb.append(V).append(" ");
		visited[V] = true;
		bfs(V);
		System.out.println(sb);
		
	}


	private static void dfs(int start) {
		for (int i = 0; i < N; i++) {
			if(flag[start][i] && !visited[i]) {
				flag[start][i] = false;
				visited[i] = true;
				sb.append(i).append(" ");
				dfs(i);
				flag[start][i] = true;
			}
		}
	}
	

	private static void bfs(int start) {
		while(!que.isEmpty()) {
			int size = que.size();
			for (int k = 0; k < size; k++) {
				int p = que.poll();
				for (int i = 0; i < N; i++) {
					if(flag[p][i] && !visited[i]) {
						visited[i] = true;
						que.add(i);
						sb.append(i).append(" ");
					}
				}
			}
		}
	}

}
