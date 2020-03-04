package 기타;

import java.util.Scanner;

public class Solution_수영장 {

	static int T;
	static int day, month, threemonth, year;
	static int[] months;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			day = sc.nextInt();
			month = sc.nextInt();
			threemonth = sc.nextInt();
			year = sc.nextInt();
			for (int i = 0; i < 12; i++) {
				months[i] = sc.nextInt();
			}
			
		}
		
		
	}

}
