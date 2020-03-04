package Study_0129;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class test {

	static int T = 10;
	static String s = "";

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);

		for (int t = 1; t <= T; t++) {
			int N = scann.nextInt();
			s = scann.next();
			char[] str = s.toCharArray();
			HashMap<Character, Character> map = new HashMap<>();
			map.put('+', 'a');
			map.put('*', 'b');

			Stack<Character> stack = new Stack<>();
			Stack<Character> imsi = new Stack<>();

			boolean possible = true;
			for (int i = 0; i < N; i++) {
				stack.push(str[i]);
			}
			System.out.println(stack.peek());
			stack.pop();
			System.out.println(stack.peek());
			stack.pop();
			System.out.println(stack.peek());
			stack.pop();
			System.out.println(stack.peek());
		}
		System.out.println();
		System.out.println();
	}
}
