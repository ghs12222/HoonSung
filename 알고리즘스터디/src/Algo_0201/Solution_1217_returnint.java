package Algo_0201;

import java.util.Scanner;

public class Solution_1217_returnint {

	static int N;
	static int M;
	static int T;
	static int res;
	static int num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=10;
		for (int t = 1; t <= T; t++) {
			num = scann.nextInt();
			N = scann.nextInt();
			M = scann.nextInt();
			res = N;
			zegop(N, 1, M);
			System.out.println("#" + t + " " + res);

		}
	}

	public static int zegop(int n, int r, int m) {
		if (r == m) {
			return res;
		}
		res *= n;
		zegop(n, r + 1, m);
		System.out.println("b");
		return res;
	}

}
