package 문제집_N과M;

import java.util.Scanner;

public class N과M_2 {

	static int N,M;
	static int[] num;
	static int[] flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M];
		flag = new int[N];
		
		combi(0,0);
	}

	public static void combi(int start, int count) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(num[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			num[count] = i+1;
			combi(i+1,count+1);
		}
		
	}

}
