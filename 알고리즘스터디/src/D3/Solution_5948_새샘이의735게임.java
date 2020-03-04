package D3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_5948_새샘이의735게임 {

	static int T;
	static int[] num;
	static int[] res;
	static int[] sum;
	static LinkedList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		list = new LinkedList<Integer>();
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			num = new int[7];
			res = new int[7];
			sum = new int[3];
			list.clear();
			for (int i = 0; i < 7; i++) {
				num[i] = sc.nextInt();
			}
			Combi(0, 0);

			System.out.println("#" + t + " " + list.get(4));

		}

	}

	private static void Combi(int start, int count) {
		if (count == 3) {
//			System.out.println(Arrays.toString(sum));
			int summ = 0;
			for (int i = 0; i < 3; i++) {
				summ += sum[i];
			}
			if (!list.contains(summ))
				list.add(summ);
			list.sort(new OHC());
			return;
		}

		for (int i = start; i < 7; i++) {
			sum[count] = num[i];
			Combi(i + 1, count + 1);
		}

	}

//	public static class OHC implements Comparator<Integer> {
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return -(o1 - o2);
//		}
//
//	}
	private static class OHC implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return -(o1 - o2);
		}
		
	}
	
}
