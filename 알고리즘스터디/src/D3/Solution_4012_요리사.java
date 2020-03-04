package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4012_요리사 {
	
	static int[][] S;
	static int[] cnt;
	static int[] ls;
	static int fla;
	static int res;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();
			S = new int[N][N];
			ls = new int[2];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = scann.nextInt();
				}
			}
			int count=0;
			cnt = new int[N*(N-1)/2];
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < i; j++) {
					cnt[count] = S[i][j] + S[j][i];
					count++;
				}
			}
			res = Math.abs(cnt[0]-cnt[1]);
			System.out.println(Arrays.toString(cnt));
//			for (int i = 0; i < cnt.length; i++) {
//				System.out.println();
//			}
			
			Combi(cnt.length, 2, 0, 0);
			System.out.println("��:"+res);
		}
	
	}
	
	public static void Combi (int n, int r, int start, int count) {
		
		if(count==r) {
			int bi =Math.abs(cnt[ls[0]] - cnt[ls[1]]);
//			System.out.println("res= "+res+"  bi= "+bi);
			if(res>bi)
				res=bi;
			return ;
		}
		for (int i = start; i < cnt.length; i++) {
			ls[count] = i;
			Combi(n, r, i+1, count+1);
		}
		
		
	}
}
