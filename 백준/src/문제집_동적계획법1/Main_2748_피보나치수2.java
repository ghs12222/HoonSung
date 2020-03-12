package 문제집_동적계획법1;

import java.util.Scanner;

public class Main_2748_피보나치수2 {

	static int N;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		num = new int[N+1];
		num[0] = 0;
		if (N != 1) {
			num[1] = 1;
//			if (N > 1) {
				for (int i = 2; i < N+1; i++) {
					num[i] = num[i - 1] + num[i - 2];
				}
//			}
		}
		System.out.println(num[N]);

	}

}
