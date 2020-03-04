package 문제집_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_10 {

	static int N, M;
	static int[] num, list, cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		num = new int[10001];
		cnt = new int[M];
		list = new int[N];
		
		int C = 0;
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(st.nextToken());
			if(num[K] == 0) {
				list[C] = K;
				C++;
			}
			num[K]++;
		}
		Arrays.sort(list);
		Combi(0,0);
		System.out.println(sb);
		
	}

	private static void Combi(int start, int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < list.length; i++) {
			if(list[i]!=0 && num[list[i]]!=0) {
				cnt[count] = list[i];
				num[list[i]]--;
				Combi(i,count+1);
				num[list[i]]++;
			}
		}
		
	}

}
