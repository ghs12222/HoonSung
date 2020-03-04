package Study_1st;
import java.util.Scanner;
public class Solution_원재의메모리복구하기 {
	
	static int T;
	static char[] tmp;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			char[] memo = scann.next().toCharArray();
			tmp = new char[51];
			int cnt = 0;
			
			for (int i = 0; i < memo.length; i++) {
				tmp[i] = '0';
			}
			for (int i = 0; i < memo.length; i++) {
				if(tmp[i] != memo[i]) {
					cnt++;
					for (int j = i; j < memo.length; j++) {
						tmp[j] = memo[i];
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
