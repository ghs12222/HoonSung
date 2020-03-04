package Study_0204;

import java.util.Arrays;

public class Combi7 {

	static int[] com;

	public static void main(String[] args) {
		int n = 5;
		int r = 3;
		com = new int[r];
		nCr(n, r, 0, 0);

	}

	public static void nCr(int n, int r, int start, int count) {
		if (count == r) {
			System.out.println(Arrays.toString(com));
			return;
		}

		for (int i = start; i < n; i++) {
			com[count]=i+1;
			nCr(n, r, i + 1, count + 1);
		}

	}

}
