package 문제_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {
	
	static int T, N;
	static int[] num;
	static int cnt, min;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int K = Integer.parseInt(st.nextToken());
				num[K-1] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 1;
			min = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				if(min>num[i]) {
					min = num[i];
				}
				if(min == 1)
					break;
				if(min>num[i+1]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
