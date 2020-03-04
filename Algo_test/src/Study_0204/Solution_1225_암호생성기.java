package Study_0204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {

	static int T = 10;
	static int TC;
	
	public static void main(String[] args) {
		 Scanner scann = new Scanner(System.in);
		 Queue<Integer> que = new LinkedList<Integer>();
		 
		 for (int t = 1; t <= T; t++) {
			TC=scann.nextInt();
			for (int i = 0; i < 8; i++) {
				que.add(scann.nextInt());
			}
			int d = 1;
			while(!que.contains(0)) {
				if(que.peek()-d>0)
					que.add(que.poll()-d);
				else {
					que.poll();
					que.add(0);
				}
				if(d==5) d=1;
				else d++;
				
			}
			System.out.print("#"+t);
			while(!que.isEmpty()) {
				System.out.print(" "+que.poll());
			}
			System.out.println();
	 
		}
	}

}
