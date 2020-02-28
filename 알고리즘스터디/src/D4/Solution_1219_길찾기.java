package D4;

import java.util.Scanner;

public class Solution_1219_±Ê√£±‚ {

	static int T=10;
	static int[] num1;
	static int[] num2;
	static int N;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= T; t++) {
			int tc = sc.nextInt();
			N = sc.nextInt();
			num1 = new int[100];
			num2 = new int[100];
			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				if(num1[n] == 0) {
					num1[n] = sc.nextInt();
				}
				else {
					num2[n] = sc.nextInt();
				}
				
			}
			
			flag = false;
			dfs(0);
			if(flag == true)
				System.out.println("1");
			else
				System.out.println("0");
			
			
		}
	}

	private static void dfs(int x) {
		if(num1[x] == 99 || num2[x] == 99) {
			flag = true;
			return;
		}
		
		if(num1[x] != 0) {
			dfs(num1[x]);
			if(num2[x] != 0) {
				dfs(num2[x]);
			}
		}
		
		
	}

}
