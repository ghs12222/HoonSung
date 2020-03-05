package D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 포기

public class Solution_7206_숫자게임 {

	static int T;
	static String target;
	static int[] num;
	static int numlen;
	static int cnt, max;
	static boolean end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			target = br.readLine();
			numlen = target.length();
			max = Integer.MIN_VALUE;
			int n = Integer.parseInt(target);

			end = false;
			cnt++;
			go(target);

		}

	}

	private static void go(String targetnum) {
		if (Integer.parseInt(targetnum) < 10)
			end = true;
		if (end)
			return;

		numlen = targetnum.length();
		if (numlen == 5) {
			cnt++;
			num[0] = Integer.parseInt(targetnum.substring(0, 1));
			num[1] = Integer.parseInt(targetnum.substring(2, 3));
			num[2] = Integer.parseInt(targetnum.substring(4));
			String s = num[0] * num[1] * num[2] + "";
			go(s);
			
			num[0] = Integer.parseInt(targetnum.substring(0, 1));
			num[1] = Integer.parseInt(targetnum.substring(2));
			num[2] = Integer.parseInt(targetnum.substring(3, 4));
			s = num[0] * num[1] * num[2] + "";
			go(s);

			num[0] = Integer.parseInt(targetnum.substring(0));
			num[1] = Integer.parseInt(targetnum.substring(1, 2));
			num[2] = Integer.parseInt(targetnum.substring(3, 4));
			s = num[0] * num[1] * num[2] + "";
			go(s);
			
			
		}

	}

}
