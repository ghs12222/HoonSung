package Study_0203;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Solution_9280_진용이네주차타워 {
	
	static int TC;
	static int n;
	static int m;
	static int[] R_i;
	static int[] W_i;
//	static int[] num; //들어온 차량
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		
		TC = scann.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			int price = 0;
			n=scann.nextInt();
			m=scann.nextInt();
			R_i = new int[n+1];
			W_i = new int[m+1];
//			num = new int[2*m];
			int [] R_flag = new int[n+1];
			int possible = 0;		//주차 공간 여유 있는지, 주차 가능한지
			for (int i = 1; i < n+1; i++) {
				R_i[i] = scann.nextInt();
			}
			for (int i = 1; i < m+1; i++) {
				W_i[i] = scann.nextInt();
			}
			
			///////////////////////////여기서부터 시작//////////////////////////////
			for (int i = 0; i < 2*m; i++) {
				int num = scann.nextInt();
				possible = 1;
				
				////////////새로 들어오는 차량
				if(num>0) {
					
					for (int j = 1; j < R_flag.length; j++) {
						if(R_flag[j] != 0) {
							possible ++;
							if(possible == R_i.length) {		//주차 공간 없으면 큐로 넘어간다.
								que.add(num);		
							}
						}
						else {
							
//							System.out.println(num +"a" + j);
							price += R_i[j]*W_i[num];				//주차공간중 자리가 있으면 가장 앞쪽에 주차한다.
							R_flag[j]=num;						//주차공간 자리에 차량 번호 저장
							//System.out.println("b");
							break;
						}
					}
				}
				////////////////////나가는 차량
				if(num<0) {
					num *= -1.0; 
					for (int j = 1; j < R_flag.length; j++) {
						if(R_flag[j] == num) {
							R_flag[j] = 0;
						}
						
					}
//					System.out.println(i+1+"번째 수행");
//					System.out.println(que);	
					bb: while(!que.isEmpty()) {
						for (int j = 1; j < R_flag.length; j++) {
							if(R_flag[j] == 0) {
								price+=W_i[que.peek()]*R_i[j];
								R_flag[j] = que.poll();
								break bb;
							}								
						}
					}
				}
				
			}
			
			System.out.println("#"+t+" " + price);
			
		}
		
		
	}

}
