package 문제집_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_9 {
	
	static int N, M, C;
	static int[] num, list, cnt;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[10001];
		list = new int[N];
		cnt = new int[M];
		
		st = new StringTokenizer(br.readLine());
		C=0;
		for (int i = 0; i < N; i++) {
			int K = Integer.parseInt(st.nextToken());
			if(num[K] == 0) {
				list[C] = K;
				C++;
			}
			num[K]++;
		}
		
		Arrays.sort(list);
		Permi(0);
		System.out.println(sb);
		
	}

	private static void Permi(int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int asd = N-C;
		
		for (int i = asd; i < N; i++) {
			if(num[list[i]] != 0) {
				cnt[count] = list[i];
				num[list[i]] --;
				Permi(count+1);
				num[list[i]]++;
			}
		}
		
	}
	
}
