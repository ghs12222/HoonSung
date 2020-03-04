package Study_0204;

import java.util.Arrays;

public class Combi8 {

	static int[] com = {1,2,3};
	static boolean[] isc;
	
	public static void main(String[] args) {
		int n = 3;
		int r = 2;
		isc = new boolean[n];
//		com = new int[r];
		nCr(n, n/2, 0, 0);

	}

	public static void nCr(int n, int r, int start, int count) {
		if (count == r) {
			for (int i = 0; i < isc.length; i++) {
				if(isc[i]) {
					System.out.print(com[i] + " ");
				}
			}
			
			for (int j = 0; j < isc.length; j++) {
				if(!isc[j]) {
					System.out.print(com[j]+" ");
				}
			}
			
			System.out.println();
			return;
		}

		for (int i = start; i < n; i++) {
			if(!isc[i]) {
				isc[i] = true;
				nCr(n,r,i+1,count+1);
				isc[i] = false;
			}
		}
	}
}
