package D3;

import java.util.Scanner;

public class Solution_3307_최장증가수열 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T = scann.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();

			int[] num = new int[N];
			for (int i = 0; i < N; i++) {
				num[i] = scann.nextInt();
			}

			int cnt[] = new int[N];
			for (int n = 0; n < N; n++) {
					
				int m=n+1;
				while (m <= N) {
					if (num[n] < num[m]) {
						cnt[n]++;
					} 
					m++;
				}
				//n++;

			}

		}
		System.out.println(" o ");

	}

}
