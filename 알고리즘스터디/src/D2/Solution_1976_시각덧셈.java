package D2;

import java.util.Scanner;

public class Solution_1976_½Ã°¢µ¡¼À {

	static int T;
	static int si1, si2, bun1, bun2;
	static int ressi, resbun;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			si1=sc.nextInt();
			bun1=sc.nextInt();
			si2=sc.nextInt();
			bun2=sc.nextInt();
			ressi = 0;
			resbun = bun1+bun2;
			if(resbun>59) {
				resbun -= 60;
				ressi++;
			}
			ressi+=si1+si2;
			if(ressi>12)
				ressi-=12;
			System.out.println("#"+t+" "+ressi+" "+resbun);
			
		}
		
		
	}

}
