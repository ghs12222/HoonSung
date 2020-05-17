package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_9940_순열1 {

	static int T, N;
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			flag = new boolean[N + 1];
			boolean res = false;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				if (!flag[num]) {
					flag[num] = true;
				} else {
					break;
				}
				if (i == N - 1)
					res = true;
			}

			sb.append("#").append(t).append(" ");
			if (res)
				sb.append("Yes");
			else
				sb.append("No");
			sb.append("\n");
		}

		System.out.println(sb);

	}

}
