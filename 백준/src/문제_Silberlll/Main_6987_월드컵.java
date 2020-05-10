package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {

	static int[][] team;
	static int result;
	static boolean end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			result = 0;
			end = false;
			team = new int[6][3];
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					team[i][j] = Integer.parseInt(st.nextToken());
					sum += team[i][j];
				}
			}

			if (sum != 30)
				end = false;
			else
				gameStart(0, 1, 0);
			System.out.println(!end ? 0 : 1);
		}

	}

	static void gameStart(int from, int to, int count) {
		if (count == 15) {
			end = true;
			return;
		}

		if (team[from][0] > 0 && team[to][2] > 0) {
			team[from][0]--;
			team[to][2]--;
			if (to < 5) {
				gameStart(from, to + 1, count + 1);
			} else {
				gameStart(from + 1, from + 2, count + 1);
			}
			team[from][0]++;
			team[to][2]++;
		}
		if (team[from][1] > 0 && team[to][1] > 0) {
			team[from][1]--;
			team[to][1]--;
			if (to < 5) {
				gameStart(from, to + 1, count + 1);
			} else {
				gameStart(from + 1, from + 2, count + 1);
			}
			team[from][1]++;
			team[to][1]++;
		}
		if (team[from][2] > 0 && team[to][0] > 0) {
			team[from][2]--;
			team[to][0]--;
			if (to < 5) {
				gameStart(from, to + 1, count + 1);
			} else {
				gameStart(from + 1, from + 2, count + 1);
			}
			team[from][2]++;
			team[to][0]++;
		}
	}

}