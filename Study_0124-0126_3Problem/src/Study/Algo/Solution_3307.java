package Study.Algo;

import java.util.Scanner;

public class Solution_3307 {

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
				int x = n;
				int m = x + 1;
				while (m < N) {
					
					if (num[x] < num[m]) {
						cnt[n]++;
						x = m;
						m = x + 1;
					}
					else 
						m++;
				}
			}
			int result = 0;
			for (int i = 0; i < N; i++) {
				if (result < cnt[i])
					result = cnt[i];
			}
			result++;
			System.out.println("#" + t + " " + result);
		}
	}

}
