package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		int T=10;
		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();			
			int[] num = new int[100];
			for (int i = 0; i< 100; i++) {
				num[i] = scann.nextInt();
			}
			for (int i = 0; i < N; i++) {
				num[0]++;
				num[99]--;
				Arrays.sort(num);
			}
			int res = num[99]-num[0];
			
			System.out.println("#"+t+" " + res);
			
		}
		
	}

}
