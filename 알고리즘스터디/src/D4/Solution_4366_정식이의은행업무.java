package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Solution_4366_정식이의은행업무 {

	static int T;
	static int su2_size, su3_size;
	static int[] num2, num3;
	static int res;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String su2 = br.readLine();
			String su3 = br.readLine();
			su2_size = su2.length();
			su3_size = su3.length();
			num2 = new int[su2_size];
			num3 = new int[su3_size];
			for (int i = 0; i < su2_size; i++) {
				num2[i] = su2.charAt(i)-'0';
			}
			for (int i = 0; i < su3_size; i++) {
				num3[i] = su3.charAt(i)-'0';
			}
			res = 0;
			for (int i = 0; i < su2_size; i++) {
				su2_Combi(i);
				if (res != 0)
					break;
			}
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}

	private static void su2_Combi(int target) {
		if (num2[target] == 0) {
			num2[target] = 1;
			su3_Combi();
			num2[target] = 0;
		} else {
			num2[target] = 0;
			su3_Combi();
			num2[target] = 1;
		}

	}

	private static void su3_Combi() {
		for (int i = 0; i < su3_size; i++) {
			int remember = num3[i];
			for (int j = 0; j < 2; j++) {
				num3[i]++;
				if (num3[i] >= 3)
					num3[i] = 0;
				check();
			}
			if (res != 0)
				break;
			num3[i] = remember;
		}

	}

	private static void check() {
		int res2 = 0;
		for (int i = 0; i < su2_size; i++) {
			res2 += num2[su2_size - 1 - i] * (int) Math.pow(2, i);
		}
		int res3 = 0;
		for (int i = 0; i < su3_size; i++) {
			res3 += num3[su3_size - 1 - i] * (int) Math.pow(3, i);
		}
		if (res2 == res3) {
			res = res2;
		}
	}

}
