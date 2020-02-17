package D2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2007_패턴마디의길이 {

	static int T;
	static char[] ch;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		Queue<Character> que = new LinkedList<>();
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int cnt = 0;
			String s = scann.next();
			ch = s.toCharArray();
			que.add(ch[0]);
//			for (int i = 1; i < ch.length; i++) {
//				if(que.isEmpty())
//					
//				if(que.peek() != ch[i])
//					que.add(ch[i]);
//				else 
//					que.poll();
//				if(que.isEmpty())
//					cnt++;
//			}
			int n=0;
			for (int i = 1; i < ch.length; i++) {
				if(ch[n] == ch[i]) {
					n=i;
					break;
				}
				
			}
			n++;
			
			System.out.println("#"+t+" "+n);
			
		}
		
	}

}
