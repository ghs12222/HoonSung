package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵2 {

	static int[][] team;
	static int[] WDL;
	static int check_win, check_loose, check_draw;
	static int res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		System.out.println();
		for (int g = 0; g < 4; g++) {
			team = new int[6][3];
			WDL = new int[3];
			check_win = 0;
			check_loose = 0;
			check_draw = 0;
			res = 1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
					WDL[j] += team[i][j];
				}
			}

			for (int i = 0; i < 6; i++) {
				bfsWL(i);
			}
			for (int i = 0; i < 6; i++) {
				bfsD(i);
			}
			
			a: for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (team[i][j] != 0) {
						res = 0;
						break a;
					}
				}
			}

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(team[i][j] + " ");
				}
				System.out.print(" ");
			}
			System.out.println();
			sb.append(res).append(" ");
		}
		System.out.println(sb);

	}

	private static void bfsD(int target) {
		if (team[target][1] > 0) {
			for (int j = 0; j < 6; j++) {
				if (j != target && team[j][1] > 0) {
					team[target][1]--;
					team[j][1]--;
					break;
				}
			}
			bfsD(target);
		}
	}	

	private static void bfsWL(int target) {
		if (team[target][0] > 0) {
			for (int i = 0; i < 6; i++) {
				if (i != target && team[i][2] > 0) {
					team[target][0]--;
					team[i][0]--;
					break;
				}
			}
			bfsWL(target);
		}
	}

}
