package 문제집_N과M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_복습 {

	static int N, M, C;
	static int[] num, cnt, list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[10001];
		cnt = new int[M];
		list = new int[N];
		
		C = 0;
		st = new StringTokenizer(br.readLine());
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
		bw.write(sb.toString());
		bw.close();
		
	}

	private static void Combi(int start, int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < C; i++) {
			if(list[i] != 0 && num[list[i]] != 0) {
				cnt[count] = list[i];
				num[list[i]]--;
				Combi(i,count+1);
				num[list[i]]++;
			}
			
			
		}
		
		
	}

}
