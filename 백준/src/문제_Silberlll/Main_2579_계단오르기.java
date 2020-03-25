package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {

	static int N;
	static int[] num;
	static int[] dp;
	static int res;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N+3];
		dp = new int[N+3];
		
		for (int i = 0; i < N; i++) {
			num[3+i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 3; i < N+3; i++) {
			//int No_Up = dp[i-1];
			int first_Up = dp[i-2] + num[i];
			int last_Up = dp[i-3] + num[i-1] + num[i];
			res = Math.max(first_Up, last_Up);
			dp[i] = res;
		}
		System.out.println(res);
		
	}

}
