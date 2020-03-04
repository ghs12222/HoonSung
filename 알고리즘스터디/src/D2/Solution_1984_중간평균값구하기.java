package D2;

import java.util.Scanner;

public class Solution_1984_중간평균값구하기 {

	static int T;
	static int[] num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=scann.nextInt();
		num = new int[10];
		for (int t = 1; t <= T; t++) {
			for (int i = 0; i < 10; i++) {
				num[i] = scann.nextInt();
			}
			
			for (int i = 0; i < 9; i++) {
				for (int j = i+1; j < 10; j++) {
					if(num[i]>num[j]) {
						int tmp = num[i];
						num[i] = num[j];
						num[j] = tmp;
					}
						
				}
			}
			
			
			double sum=0;
			for (int i = 1; i < 9; i++) {
				sum+=num[i];
			}
			sum/=8;
			System.out.println("#"+t+" " + Math.round(sum));
		}
	}
	

}
