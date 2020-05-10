package 문제_Silver_l;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	
	static int N, K;
	static int[] flag;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Integer>();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		flag = new int[100001];
		
		que.add(N);
		flag[N] = 0;
		bfs();
		System.out.println(flag[K]);
		
		
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			int from = que.poll();
			if(from == K) {
				que.clear();
				break;
			}
			if(from+1<=100000 && flag[from+1] == 0) {
				flag[from+1] = flag[from] + 1;
				que.add(from+1);
			}
			if(from-1>=0 && flag[from-1] == 0) {
				flag[from-1] = flag[from] + 1;
				que.add(from-1);
			}
			if(from*2<=100000 && flag[from*2] == 0) {
				flag[from*2] = flag[from] + 1;
				que.add(from*2);
			}
		}
	}
	
}
