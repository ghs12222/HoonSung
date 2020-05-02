package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] flag;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.copyOf(arr[i], 10001);
			arr[i][i] = 0;
		}
		
		flag = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int tax = Integer.parseInt(st.nextToken());
			if(arr[from][to] == 0 || (arr[from][to] != 0 && arr[from][to] > tax)) {
				arr[from][to] = tax;
				flag[from][to] = true;
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(arr[i][k] ==0)
					continue;
				for (int j = 0; j < N; j++) {
					if(arr[k][j] == 0 || i==j)
						continue;
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
