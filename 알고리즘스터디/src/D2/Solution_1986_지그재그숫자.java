package D2;

import java.util.Scanner;

public class Solution_1986_지그재그숫자 {

	static int T;
	static int N;
	static int res;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			if(N%2==0)
				res = (N/2)*-1;
			else
				res = N/2+1;
			
			System.out.println("#"+t+" " + res);
			
		}
	}

}
