package D4;

import java.util.Scanner;

public class Solution_8659_GCD2 {

	static int T;
	static int K;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			K=scann.nextInt();
			int A=2, B=1;
			for (int i = 1; i < K; i++) {
				int C = A+B;
				B=A;
				A=C;
			}
			
			
			
			
			
			System.out.println("#"+t+ " " + A + " " + B);
		}
		
	}

}
