package D2;

import java.util.Scanner;

public class Solution_1983_조교의성적매기기 {
	
	static int T;
	static int N;
	static int K;
	static int[][] stu;
	static double[]score;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			K = scann.nextInt();
			stu = new int[N][3];
			score = new double[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					stu[i][j] = scann.nextInt();
				}
			}
			for (int i = 0; i < N; i++) {
				score[i] = stu[i][0] * 0.35 + stu[i][1]*0.45 + stu[i][2]*0.20;
			}
			for (int i = 0; i < N-1; i++) {
				for (int j = 1; j < N; j++) {
					if(score[i]>score[j]) {
						double tmp = score[i];
						score[i] = score[j];
						score[j] = tmp;
					}
				}
			}
			
		}
	}
}
