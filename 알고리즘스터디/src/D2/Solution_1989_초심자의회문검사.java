package D2;

import java.util.Scanner;

public class Solution_1989_초심자의회문검사 {

	static int T;
	static String s;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			s = scann.next();
			char[] ch = s.toCharArray();
			int flag = 1;
			for (int i = 0; i < ch.length / 2; i++) {
				if (ch[i] != ch[ch.length - i - 1]) {
					flag = 0;
					break;
				}
			}
			System.out.println("#" + t + " " + flag);
		}
	}
}
