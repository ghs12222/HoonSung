package D3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8821_적고지우기 {

	static int T;
	static String S;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			S = scann.next();
			char[] ch = S.toCharArray();
			boolean[] num = new boolean[10];
			int cnt = 0;
			for (int i = 0; i < ch.length; i++) {
				if(num[ch[i]-'0'] == false)
					num[ch[i]-'0'] = true;
				else
					num[ch[i]-'0'] = false;
			}
			for (int i = 0; i < 10; i++) {
				if(num[i]==true)
					cnt++;
			}
			System.out.println("#"+t+" " + cnt);
		}
		
	}

}
