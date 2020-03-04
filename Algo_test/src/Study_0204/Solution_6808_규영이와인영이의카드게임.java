package Study_0204;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6808_규영이와인영이의카드게임 {

	static int T;
	static int[] num_x;
	static int[] num_y;
	static int[] num_yi;
	static int xwin, ywin;
	static int win, loose;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			num_x = new int[9];		//규영
			num_y = new int[9];		//인영
			num_yi = new int[9]; 	//돌아갈 저장공간
			for (int i = 0; i < 9; i++) {
				num_x[i] = scann.nextInt();
			}
			boolean[] num = new boolean[19];
			int count = 0;
			for (int i = 0; i < 9; i++) {
				//if(num_x[count] == i) {
					num[num_x[i]] = true;
				//}
			}
			for (int i = 1; i < 19; i++) {
				if(num[i] == false) {
					num_y[count] = i;
					count++;
				}
			}
			win = 0;
			loose = 0;
			nPr(9,9,0,0);
			System.out.println("#"+t+" "+win+ " " + loose);
			
			
		}
		
		
	}
	
	public static void nPr (int n, int r, int flag, int count) {
		if(count==r) {
			//System.out.println(Arrays.toString(num_yi));
			xwin = 0;
			ywin = 0;

			for (int i = 0; i < 9; i++) {
				if(num_x[i]>num_yi[i])
					xwin += num_x[i]+num_yi[i];
				else if(num_x[i]<num_yi[i])
					ywin += num_x[i]+num_yi[i];
				}
			if(xwin>ywin)
				win++;
			else if(xwin<ywin)
				loose++;
			return ;
		}
		
		for (int i = 0; i < 9; i++) {
			if((flag & 1 << i) !=0) {
				continue;
			}
			else {
				num_yi[count]= num_y[i];
				nPr(n,r,flag|1<<i,count+1);
			}
				
		}
	}

}
