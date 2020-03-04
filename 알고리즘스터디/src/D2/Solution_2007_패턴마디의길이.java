package D2;

import java.util.Scanner;


public class Solution_2007_패턴마디의길이 {

	static int T;
	static char[] ch;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			String s = scann.next();
			ch = s.toCharArray();
			
			int cnt=0;
			int d=1;
			boolean patern;
			while(d<=10) {
				patern = true;
				cnt = 0;
				for (int i = 0; i < d; i++) {
					if(ch[i] != ch[d+i]) {
						patern = false;
						break;
					}
					cnt++;
				}
				if(patern == true) 
					break;
				d++;
			}
			if(d>10)
				cnt = 0;
			System.out.println("#"+t+" "+cnt);
			
			
			
		}
		
		
	}

}
