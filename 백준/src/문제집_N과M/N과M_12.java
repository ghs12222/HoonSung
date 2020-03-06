package 문제집_N과M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_12 {

	static int N, M;
	static int[] cnt, list;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		flag = new boolean[10001];
		cnt = new int[M];
		list = new int[N];
		int c=0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(!flag[k]) {
				list[c] = k;
				c++;
				flag[k] = true;
			}
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
		
		for (int i = start; i < N; i++) {
			if(list[i] != 0) {
				cnt[count] = list[i];
				Combi(i,count+1);
			}
		}
		
	}

}
