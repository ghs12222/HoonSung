package 문제_Gold_lll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2026_소풍 {

	static int N, K, F;
	static int count;
	static int[] res;
	static boolean[] flag;
	static List<Integer>[] list;
	static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		res = new int[N];
		list = new List[K];
		for (int i = 0; i < K; i++) {
			list[i] = new LinkedList<Integer>();
		}
		que = new LinkedList<Integer>();
		flag = new boolean[K];

		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			list[from].add(to);
			list[to].add(from);
		}
		
		count = 0;
		go();
		Arrays.sort(res);
		for (int i = 0; i < N; i++) {
			System.out.println(res[i]);
		}
	}

	private static void go() {
		if(que.size() == N) {
			System.out.println(1);
			for (int i = 0; i < N; i++) {
				res[i] = que.poll();
			}
		}
			
		for (int i = 0; i < K; i++) {
			if (!flag[i] && list[i].size() == N) {
				flag[i] = true;
				que.add(i);
				go();
				que.poll();
				flag[i] = false;
			} else
				flag[i] = true;
		}
	}

}
