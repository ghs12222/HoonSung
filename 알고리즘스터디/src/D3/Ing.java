package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ing {

	static int T;
	static String S1, S2;
	static char[] C1, C2;
	static int N1, N2;
	static boolean res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			S1 = br.readLine();
			C1 = new char[S1.length()];
			C1 = S1.toCharArray();
			S2 = br.readLine();
			C2 = new char[S1.length()];
			C2 = S2.toCharArray();

			res = true;
			if (S1.length() == S2.length()) {
				for (int i = 0; i < S1.length(); i++) {
					if (C1[i] == 'B')
						N1 = 2;
					else if (C1[i] == 'A' || C1[i] == 'D' || C1[i] == 'O' || C1[i] == 'P' || C1[i] == 'R'
							|| C1[i] == 'Q')
						N1 = 1;
					else
						N1 = 0;

					if (C2[i] == 'B')
						N2 = 2;
					else if (C2[i] == 'A' || C2[i] == 'D' || C2[i] == 'O' || C2[i] == 'P' || C2[i] == 'R'
							|| C2[i] == 'Q')
						N2 = 1;
					else
						N2 = 0;
					if (N1 != N2) {
						res = false;
						break;
					}

				}
			}
			else
				res = false;

			if (res)
				sb.append("#").append(t).append(" ").append("DIFF").append("\n");
			else
				sb.append("#").append(t).append(" ").append("SAME").append("\n");
		}
		System.out.println(sb);

	}

}
