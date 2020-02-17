package D4;

import java.util.Scanner;

public class Solution_8659_GCD {

	static int T;
	static int K;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			K=scann.nextInt();
			int A=2, B=1;
			int cnt=0;
			while (cnt != K) {
				cnt = 0;
				int a=A;
				int b=B;
				while (b != 0) {
					int c = a % b;
					a = b;
					b = c;
					cnt++;
				}
				if(cnt == K)  break;
				B++;
				if(A==B) {
					A++;
					B=0;
				}
			}
			System.out.println("#"+t+ " " + A + " " + B);
		}
		
	}

}
