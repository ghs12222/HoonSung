package ������_N��M;

import java.util.Scanner;
//�ð��ʰ�!! �Է��� BufferedReader �� StringBuffer�� �ٲܰ�!!
public class N��M_3 {

	static int N, M;
	static int[] num;
	static boolean[] flag;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		perm(0);
	}

	private static void perm(int count) {
		if (count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			num[count] = i + 1;
			perm(count + 1);
		}
	}

}
