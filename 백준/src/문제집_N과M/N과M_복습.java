package 문제집_N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_복습 {
	
	static int N, M;
	static int[] num;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[M];
		flag = new boolean[N];
		
		Permi(0);
		System.out.println(sb);
		
	}

	private static void Permi(int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!flag[i]) {
				flag[i] = true;
				num[count] = i+1;
				Permi(count+1);
				flag[i] = false;
			}
		}
	}
	
	
}