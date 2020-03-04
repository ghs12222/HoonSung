package 문제집_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_8 {
	
	static int N,M;
	static int[] num, cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		cnt = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
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

		for (int i = start; i < N; i++) {
			cnt[count] = num[i];
			Combi(i, count+1);
		}
		
	}
	
}
