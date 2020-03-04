package 문제집_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_5 {
	
	static int N, M;
	static int[] num, cnt;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new int[N];
		cnt = new int[M];
		flag = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
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
		
		for (int i = 0; i < N; i++) {
			if(!flag[i]) {
				flag[i] = true;
				cnt[count] = num[i];
				Permi(count+1);
				flag[i] = false;
			}
			
			
		}
		
	}
	
}
