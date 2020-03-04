package Study_2st;

import java.util.Arrays;

public class Array {

	static int it;
	static int[] num;
	public static void main(String[] args) {
		num = new int[3];
		it = 0;
		Perm(5,3,0,0);
		System.out.println(it);
	}
	
	public static void Perm(int n, int r, int flag, int count) {
		if(count==r) {
			it++;
			System.out.println(Arrays.toString(num));
			return ;
		}
		
		for (int i = 0; i < n; i++) {
//			System.out.println("i= "+i+", flag= "+flag+", count= "+count);
//			System.out.println("(flag & 1 << i) = " + (flag & 1 << i));
			if ((flag & 1 << i) != 0) { // ¾ÈÇØÁàµµ µÊ.
//				System.out.println("continue!");
//				System.out.println();
				continue;
			}
			if((flag & 1<<i)==0) {
				num[count] = i+1;
				Perm(n,r,flag|1<<i,count+1);
			}
			
		}
	}
	
}
