package Study_0204;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution_5948_새샘이의735게임 {

	static int T;
	static int[] num;
	static int[] com;
	static int[] num_sort;
	static LinkedList<Integer> link; 
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			link = new LinkedList<>();
			int n = 7;
			int r = 3;
			
			num = new int[7];
			for (int i = 0; i < 7; i++) {
				num[i]=scann.nextInt();
			}
			com = new int[r];
			nCr(n,r,0,0);
			System.out.println("#"+t+" "+link.get(4));
			}
		
	
		
		
	}
	
	public static void nCr(int n, int r, int start, int count) {
		if(count == r) {
			int sum = 0;
//			System.out.println(Arrays.toString(num));
			for (int i = 0; i < com.length; i++) {
				sum+=com[i];
			}
			if(!link.contains(sum)) {
				link.add(sum);				
			}
			link.sort(new OHC());
			return;
		}
		
		for (int i = start; i < n; i++) {
			com[count] = num[i];
			nCr(n,r,i+1,count+1);
		}
	
	}
	
	public static class OHC implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			return -(o1-o2);
		}
	
		
	}

}
