package 문제_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1946_신입사원 {

	static int T, N;
	static boolean[] flag, possible;
	static int[] num1, num2;
	static int[] cnt;
	static int target, bigyo, res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			num1 = new int[N];
			num2 = new int[N];
			flag = new boolean[N];
			possible = new boolean[N];
			cnt = new int[2];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				num1[i] = Integer.parseInt(st.nextToken());
				num2[i] = Integer.parseInt(st.nextToken());
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println("num1["+i+"] = " + num1[i] + ", num2["+i+"] = " + num2[i]);
//			}
			res = 0;
			Permi(0);

			for (int i = 0; i < N; i++) {
				if(!possible[i]) 
					res++;
			}
			System.out.println(res);
		}

	}

	private static void Permi(int count) {

		if (count == 2) {
			
			if(num1[cnt[0]] > num1[cnt[1]]) {
				if(num2[cnt[0]] > num2[cnt[1]]) {
					possible[cnt[0]] = true;
				}
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if(possible[i])
				continue;
			if (!flag[i]) {
				flag[i] = true;
				cnt[count] = i;
				Permi(count + 1);
				flag[i] = false;
			}
		}

	}

}
