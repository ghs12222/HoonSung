package Study_1st;

import java.util.Scanner;

public class Solution_ÃÖºó¼ö {

	static int T;
	static int N;
	static int[] score;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			score = new int[101];
			int result=0;
			int max=0;
			for (int i = 0; i < 1000; i++) {
				int s = scann.nextInt();
				score[s]++;
			}
			for (int i = 0; i < score.length; i++) {
				if(max<=score[i]) {
					max = score[i];
					result=i;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}

}
