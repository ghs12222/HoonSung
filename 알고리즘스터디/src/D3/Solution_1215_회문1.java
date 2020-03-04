package D3;

import java.util.Scanner;

public class Solution_1215_회문1 {

	static int T=10;
	static int S=8;
	static int N;
	static char[][] map;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			N = scann.nextInt();
			map = new char[S][S];
			int cnt=0;
			boolean bb = true;
			for (int i = 0; i < S; i++) {
					String s = scann.next();
					map[i] = s.toCharArray();
			}

			for (int i = 0; i < S-N+1; i++) {
				for (int j = 0; j < S; j++) {
					bb=true;
					int m=i;
					int n=1;
					for (int k = 0; k < N/2; k++) {
						if(map[m][j]!=map[m+N-n][j]) { 
							bb=false;
						}
						m++;
						n+=2;
					}
//					while(N-n>1) {
//						if(map[m][j]!=map[m+N-n][j]) {
//							bb=false;
//						}
//						m++;
//						n++;
//					}
					if(bb==true)
						cnt++;
				}
			}	
			
			for (int i = 0; i < S; i++) {
				for (int j = 0; j < S-N+1; j++) {
					bb=true;
					int m=j;
					int n=1;
					for (int k = 0; k < N/2; k++) {
						if(map[i][m]!=map[i][m+N-n]) {
							bb=false;
						}
						m++;
						n+=2;
						
						
					}
//					while(N-n>1) {
//						if(map[m][j]!=map[m][j+N-n]) {
//							bb=false;
//						}
//						m++;
//						n++;
//					}
					if(bb==true)
						cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
