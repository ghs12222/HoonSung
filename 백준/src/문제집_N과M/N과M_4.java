package 문제집_N과M;

import java.util.Arrays;
import java.util.Scanner;

public class N과M_4 {

	static int N, M;
	static int[] num;
	static boolean temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];

		combi(0, 0);
	}

	private static void combi(int start, int count) {
		if (count == M) {
			temp = false;
			for (int j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) {
					temp = true;
					break;
				}
			}
			if (!temp) {
				for (int i = 0; i < N; i++) {
					System.out.print(num[i]+" ");
				}
				System.out.println();
			}

			return;
		}

		for (int i = 0; i < N; i++) {
			num[count] = i + 1;
//			if(count+1<N && num[count]>num[count+1])
//				continue;
			combi(i, count + 1);

		}
	}

}
