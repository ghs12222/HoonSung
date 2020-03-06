package 문제집_N과M;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과M_11 {

	static int N, M;
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
		
		st = new StringTokenizer(br.readLine());
		int c = 0;
		for (int i = 0; i < N; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(num[k] == 0) {
				list[c] = k;
				c++;
			}
			num[k]++;
		}
		
		Arrays.sort(list);
		for (int i = 0; i < N; i++) {
			System.out.println(list[i]);
		}
		Permi(0);
		bw.write(sb.toString());
		bw.close();
		
		
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
			if(list[i] != 0) {
				cnt[count] = list[i];
				Permi(count+1);
			}
		}
	
	}

}
