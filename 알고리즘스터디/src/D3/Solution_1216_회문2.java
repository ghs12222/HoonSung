package D3;

import java.util.Scanner;

public class Solution_1216_회문2 {

	static int T = 10;
	static int N;
	static char[][] map;
	static boolean[] cnt;
	static int leng;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		for (int testcase = 1; testcase <= T; testcase++) {
			N = scann.nextInt();
			map = new char[100][100];
			cnt = new boolean[101];
			cnt[1] = true;
			for (int i = 0; i < 100; i++) {
				String s = scann.next();
				map[i] = s.toCharArray();
			}

			for (int leng = 2; leng <= 100; leng++) {
				aa: for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						int n = j;
						int m = 1;
						int check = 0;
						for (int k = 0; k < leng / 2; k++) {
							
							if (map[i][n] != map[i][n + leng - m]) {
								// break aa;
								break;
							}
							n++;
							m+=2;
							check++;
							

						}
						if(check == leng/2) {
							cnt[j] = true;
							break aa;
						}

					}

				}
			}
			
			for (int leng = 2; leng <= 100; leng++) {
				aa: for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						int n = j;
						int m = 1;
						int check = 0;
						for (int k = 0; k < leng / 2; k++) {
							
							if (map[n][i] != map[n + leng - m][i]) {
								// break aa;
								break;
							}
							n++;
							m+=2;
							check++;
							

						}
						if(check == leng/2) {
							cnt[j] = true;
							break aa;
						}

					}

				}
			}

		}

	}

}
