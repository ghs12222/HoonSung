package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2437_저울 { //해결X

	static int N;
	static int[] num;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
		for (int i = 0; i < N; i++) {
			System.out.println("num[" + i + "] = " + num[i]);
		}
		res = 1;

		for (int i = 1; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += num[j];
				System.out.println(i + "번째: " + "sum = " + sum);
			}
			if (sum >= num[i]) {
				if (res >= sum)
					continue;
			}
			res = sum;
			res++;
			break;

		}
		System.out.println(res);

	}

}
