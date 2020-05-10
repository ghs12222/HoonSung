package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵4 {

	static int[][] team;
	static int[] WDL;
	static int cnt = 0;
	static boolean check_WL, check_D;
	static int res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int size = 0; size < 4; size++) {
			st = new StringTokenizer(br.readLine());
			team = new int[6][3];
			cnt = 0;
			check_WL = check_D = false;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 6; i++) {
				bfsWL(i, 0);
			}
			for (int i = 0; i < 6; i++) {
				bfsD(i, 0);
			}
			check();
			Print();
			System.out.println("cnt = " + cnt);
			if (cnt == 15)
				System.out.println("1");
			else
				System.out.println("0");
//			System.out.println(res);
		}

	}

	private static void bfsWL(int target, int start) {
		Print();
		if (cnt == 15)
			return;
		for (int i = start; i < 6; i++) {
			if (i == target)
				continue;
			if (team[i][2] > 0 && team[target][0] > 0) {
				team[target][0]--;
				team[i][2]--;
				cnt++;
				bfsWL(target, i + 1);
				team[target][0]++;
				team[i][2]++;
			}

			else if (team[i][0] > 0 && team[target][2] > 0) {
				team[target][2]--;
				team[i][0]--;
				cnt++;
				bfsWL(target, i + 1);
				team[target][2]++;
				team[i][0]++;
			}

			else if (team[i][1] > 0 && team[target][1] > 0) {
				team[target][1]--;
				team[i][1]--;
				cnt++;
				bfsWL(target, i + 1);
				team[target][1]++;
				team[i][1]++;
			}
		}
	}

	private static void bfsD(int target, int start) {
		if (team[target][1] == 0)
			return;
		for (int i = start; i < 6; i++) {
			if (i == target)
				continue;
			if (team[i][1] > 0) {
				team[target][1]--;
				team[i][1]--;
				cnt++;
				bfsWL(target, i + 1);
				team[target][1]++;
				team[i][1]++;

			}
		}
	}

	private static void check() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				if (team[i][j] != 0) {
					res = 0;
					return;
				}
			}
		}

	}

	private static void Print() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(team[i][j] + " ");
			}
			System.out.print(" ");
		}
		System.out.println();
	}
}
