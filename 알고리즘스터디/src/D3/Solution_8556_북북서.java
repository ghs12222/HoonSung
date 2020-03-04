package D3;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8556_북북서 {

	static int T;
	static String s;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		T = scann.nextInt();
		
		for (int t = 1; t <= T; t++) {
			s = scann.next();
			char[] ch = s.toCharArray();
			double res=0;
			int cnt=1;
			
			for (int i = 0; i < ch.length; i++) {
				if(ch[i] == 'n') {
					stack.push('n');
					i+=4;
				}
				else if(ch[i] == 'w') {
					stack.push('w');
					i+=3;
				}
			}
			
			if(stack.peek() == 'w')
				res = 90;
			stack.pop();
			int res1=1;
			int siz = stack.size();
			for (int i = 0; i < siz; i++) {
				if(stack.pop() == 'n')
					res = res-(90/Math.pow(2, cnt));
				else
					res = res+(90/Math.pow(2, cnt));
				cnt++;
			}
			res1 = (int)res*4;
			res*=4;
			System.out.print("res= "+res);
			System.out.println("res1= "+res1);
		}
		
		
	}

}
