package 문제_Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {

	static int N;
	static int[] num, operator;
	static int[] cnt;
	static int sum, min, max;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		cnt = new int[N - 1];
		operator = new int[4];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		Permi(0);
		System.out.println(max);
		System.out.println(min);
	}

	private static void Permi(int count) {
		if (count == N - 1) {
			sum = num[0];
			for (int i = 0; i < N - 1; i++) {
				if (cnt[i] == 0) {
					sum += num[i + 1];
				}
				if (cnt[i] == 1) {
					sum -= num[i + 1];
				}
				if (cnt[i] == 2) {
					sum *= num[i + 1];
				}
				if (cnt[i] == 3) {
					sum /= num[i + 1];
				}
			}
			if(max<sum)
				max = sum;
			if(min>sum)
				min = sum;

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] != 0) {
				cnt[count] = i;
				operator[i]--;
				Permi(count + 1);
				operator[i]++;
			}
		}

	}

}
