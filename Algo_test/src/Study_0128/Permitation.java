package Study_0128;

import java.util.Arrays;
public class Permitation {

	static int m;
	static int[] num;

	public static void main(String[] args) {
		num = new int[3];
		m = 0;
		perm(5, 3, 0, 0);
		System.out.println(m);
	}

	public static void perm(int n, int r, int flag, int count) {
		if (count == r) {
			m++;
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) { // ¾ÈÇØÁàµµ µÊ.
				continue;
			}
			if ((flag & 1 << i) == 0) { // 0 & 1<<0 0& 1<<1 0& 1<<2
				num[count] = i + 1;
				perm(n, r, flag | 1 << i, count + 1);
			}
			
		}
		System.out.println();
	}
}
