package Study_0129;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class Solution_1218_괄호짝짓기 {

	static int T = 10;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int N=scann.nextInt();
			String s = scann.next();
			char[] str = s.toCharArray();
			//HashMap<K,V>  			//<K,V>는 제네릭! 이없으면 모두 오브젝트가 된다!! 엉뚱한 데이터를 안하기 위해서!! -자연수 선언시 int를 하지 않으면 쓰레기 값이 나오듯이
			HashMap<Character, Character> map = new HashMap<>();
			//map.put(key, value)
			map.put('(',  ')');
			map.put('{',  '}');
			map.put('[',  ']');
			map.put('<',  '>');
			
			Stack<Character> stack = new Stack<>();
			
			boolean possible = true;
			for (int i = 0; i < N; i++) {
				if(map.containsKey(str[i])) {		//아이디어!! map안에 key값이 있으니까 containtkey로 불러오면 된다
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
