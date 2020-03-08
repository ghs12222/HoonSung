package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_8658_Summation {

	static int T;
	static int[] res;
	static int max, min;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			res = new int[10];

			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				String s = st.nextToken();
				int num = 0;
				for (int j = 0; j < s.length(); j++) {
					num += s.charAt(j) - '0';
				}
				res[cnt] = num;
				cnt++;
			}
			
			Arrays.sort(res);
			sb.append("#"+t+" "+res[9]+" "+res[0]+"\n");
		}
		System.out.println(sb);
	}
}
