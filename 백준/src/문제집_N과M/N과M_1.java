package 문제집_N과M;

import java.util.Scanner;

public class N과M_1 {

	static int N, M;
	static int[] num;
	static boolean[] flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		flag = new boolean[N];
		perm(0, 0);

	}

	private static void perm(int start, int count) {
		if (count == M) {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!flag[i]) {
				num[count] = i + 1;		
				flag[i] = true;
				perm(i+1, count + 1);
				flag[i] = false;
			}
		}

	}

}
