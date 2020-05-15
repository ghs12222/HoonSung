package 문제_Gold_ll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	
	static int N, M;
	static int[] num;
	static int from, to;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			num[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st =  new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			bfs1(from);
			to = Integer.parseInt(st.nextToken());
			bfs2(to);
			if(from>to) {
				int temp = num[from];
				num[from] = num[to];
				num[to] = temp;
			}
		}
		for (int i = 1; i < N+1; i++) {
			sb.append(num[i]+" ");
		}
		System.out.println(sb);
		
	}
	
	static void bfs1(int target) {
		if(num[target] == from) {
			from = target;
			return;
		}
		else
			bfs1(num[target]);
		return;
	}
	
	static void bfs2(int target) {
		if(num[target] == to) {
			to = target;
			return;
		}
		else
			bfs2(num[target]);
		return;
	}
	
}
