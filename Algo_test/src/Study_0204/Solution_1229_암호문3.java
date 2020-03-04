package Study_0204;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1229_암호문3 {

	static int T=10;
	static int N;		//원본암호길이
	static int M;		//명령어 갯수
	static String M_inout;
	static int M_num;
	static int M_count;
	
	static String[] s;
	
	
	
	public static void main(String[] args) {
		Scanner scann  = new Scanner(System.in);
		LinkedList<String> link = new LinkedList<>();
		
		for (int t = 1; t <= T; t++) {
			link.clear();
			N = scann.nextInt();
			s = new String[N+1];
			for (int i = 1; i <= N; i++) {
				s[i] = scann.next();
				link.add(s[i]);
			}
			
			M = scann.nextInt();		
			for (int i = 1; i <= M; i++) {
				M_inout = scann.next();
				M_num = scann.nextInt();
				M_count = scann.nextInt();
				
				if(M_inout.equals("I")) {
					for (int j = 0; j < M_count; j++) {
						String st = scann.next();
						link.add(M_num+j, st);
					}
				}
				
				else if(M_inout.equals("D")) {
					for (int j = 0; j < M_count; j++) {
						link.remove(M_num);
					}
				}
			}

			System.out.print("#"+t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+link.get(i));
			}
			System.out.println();
			
		}
		
	}

}
