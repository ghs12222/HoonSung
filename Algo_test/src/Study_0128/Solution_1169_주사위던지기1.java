package Study_0128;
import java.util.Scanner;

public class Solution_1169_주사위던지기1 {

	static int N;
	static int M;
	static int[] num;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();
		M = scann.nextInt();
		num = new int[N];
		
		if (M==3) {
			m3(6,N,0,0);
		} else if (M==2) {
			m2(6,N,0,0);
		} else if (M==1) {
			m1(6,N,0);
		}

	}
	public static void m1(int n, int r, int cnt) {
		if(r==cnt) {
			for (int i = 0; i < r; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return ;
		}
		for (int i = 0; i < n; i++) {
			num[cnt]=i+1;
			m1(n, r, cnt+1);
		}
	}
	
	public static void m2(int n, int r, int start, int cnt) {
		if(r==cnt) {
			for (int i = 0; i < r; i++) {
				System.out.print(num[i]+ " ");
			}
			System.out.println();
			return ;
		}
		for (int i = start; i < n; i++) {
			num[cnt]=i+1;
			m2(n, r, i, cnt+1);
		}
	}
	
	public static void m3(int n, int r, int flag, int cnt) {
		if(r==cnt) {
			for (int i = 0; i < r; i++) {
				System.out.print(num[i]+ " ");
			}
			System.out.println();
			return ;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) == 0) {
				num[cnt] = i+1;
				m3(n, r, flag | 1 << i, cnt + 1);
			}
 		}
	}

}
