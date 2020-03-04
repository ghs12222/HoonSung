package Study.Algo;

import java.util.Scanner;

public class Solution_1859_백만장자프로젝트 {

	static int T;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 0; t < T; t++) {
			int n = scann.nextInt();
			int[] price = new int[n];
			for (int i = 0; i < n; i++) {
				price[i] = scann.nextInt();
			}
			int max=price[n-1];
			long sum=0;
			
			for (int i = n-2; i >= 0; i--) {
				if(price[i]>=max) {
					max = price[i];
				}
				else {
					sum+= max - price[i];
				}
			}
			
			System.out.println("#" + t + " " + sum);
			
		}
		
	}

}
