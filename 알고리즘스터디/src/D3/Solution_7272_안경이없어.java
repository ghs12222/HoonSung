package D3;

import java.util.Scanner;

public class Solution_7272_안경이없어 {

	static int T;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T= scann.nextInt();
		for (int t = 1; t <= T; t++) {
			String S1 = scann.next();
			char[] C1 = S1.toCharArray();
			String S2 = scann.next();
			char[] C2 = S2.toCharArray();
			
			for (int i = 0; i < C1.length; i++) {
				System.out.print(C1[i]);
			}
			System.out.println();
			for (int i = 0; i < C1.length; i++) {
				System.out.print(C2[i]);
			}
			System.out.println();
			System.out.println();
			System.out.println(C1.toString().charAt(t));
			System.out.println(C2.toString());

		}
		
		
		
	}

}
