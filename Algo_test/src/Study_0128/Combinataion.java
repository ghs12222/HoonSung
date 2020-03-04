package Study_0128;

import java.util.Arrays;

public class Combinataion {

	static int[] num;
	static int it=0;
	public static void main(String[] args) {
		num = new int[3];
		it = 0;
		combi(5,3,0,0);
		System.out.println(it);
	
	}
	
	public static void combi(int n, int r, int start, int count) {
		if(count==r) {
			it++;
			System.out.println(Arrays.toString(num));
			return ;
		}
		for (int i = start; i < n; i++) {
			num[count] = i+1;
//			System.out.println("i= " + i + ", num[count]= " + num[count] + ", start= "+start+", count= "+count);
			combi(n, r, i+1, count+1);
		}
//		System.out.println();
	}

}
