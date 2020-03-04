package Study_0129;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class Solution_1218_��ȣ¦���� {

	static int T = 10;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=scann.nextInt();
			String s = scann.next();
			char[] str = s.toCharArray();
			//HashMap<K,V>  			//<K,V>�� ���׸�! �̾����� ��� ������Ʈ�� �ȴ�!! ������ �����͸� ���ϱ� ���ؼ�!! -�ڿ��� ����� int�� ���� ������ ������ ���� ��������
			HashMap<Character, Character> map = new HashMap<>();
			//map.put(key, value)
			map.put('(',  ')');
			map.put('{',  '}');
			map.put('[',  ']');
			map.put('<',  '>');
			
			Stack<Character> stack = new Stack<>();
			
			boolean possible = true;
			for (int i = 0; i < N; i++) {
				if(map.containsKey(str[i])) {		//���̵��!! map�ȿ� key���� �����ϱ� containtkey�� �ҷ����� �ȴ�
					stack.push(str[i]);
				}
				else {
					if(!stack.isEmpty() && str[i]==map.get(stack.peek())) {
						stack.pop();
					} else {
						possible = false;
					}
				}
			}
			if(!stack.isEmpty()) {
				possible = false;
			}
			System.out.println("#" +t + " ");
			if(possible) { 
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}

		}
	}

}
