package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_새샘이와세소수 {

	static int T, N;
	static int[] num, cnt;
	static int res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num = new int[500];
			cnt = new int[3];
			int cnt = 0;
			for (int i = 2; i < 999; i++) {
				boolean check = true;
				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						check = false;
						break;
					}
				}
				if (check) {
					num[cnt] = i;
					cnt++;
				}
			}
			res = 0;
			System.out.println("N = "+ N);
			Combi(0, 0);
//			sb.append("#").append(t).append(" ").append(res).append("\n");
			
		}
//		System.out.println(sb);

	}

	private static void Combi(int start, int count) {
		if (count == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += cnt[i];
			}
			if (sum == N) {
				for (int i = 0; i < 3; i++) {
					System.out.print(cnt[i]+" ");
				}
				res++;
			}
			return;

		}

		for (int i = start; i < num.length; i++) {
			cnt[count] = num[i];
			Combi(i, count + 1);

		}
	}

}
