package Study_0129;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1224_°è»ê±â3 {

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
			Stack<Integer> sum = new Stack<>();

			boolean possible = true;
			for (int i = 0; i < N; i++) {
				if (!map.containsKey(str[i])) {
					stack.push(str[i]);
					// System.out.print(stack.peek());
				} else {
					if(str[i] == '(') {
						stack.push(str[i]);
					}
					else if (str[i] == '+') {
						while (!imsi.isEmpty() && imsi.peek() !='(') {
							stack.push(imsi.pop());
						}
						imsi.push(str[i]);
					} else if (str[i] == '*') {
						while (!imsi.isEmpty() && imsi.peek() != '(' && imsi.peek() != '+') {
							stack.push(imsi.pop());
						}
						imsi.push(str[i]);
					} /*else if(str[i] == ')') {
						while (!imsi.isEmpty() && (imsi.peek() == '(')) {
							stack.push(imsi.pop());
						}
						*/
						//imsi.pop();
					else if (str[i] == ')') {
						char top = imsi.pop();
						while (!imsi.isEmpty() && top !='(') {
							stack.push(top);
							top = imsi.pop();
						}
					}
				}

				
			}
			for (int j = 0; j < N; j++) {
				System.out.print(stack.get(j) + " ");
			}
			System.out.println();
			/*
			if (!imsi.isEmpty())
				while (!imsi.empty())
					stack.push(imsi.pop());
			imsi.clear();

			for (int i = 0; i < N; i++) {
				int temp = 0;
				if (Character.isDigit(stack.get(i))) {
					sum.push(stack.get(i) - '0');
				} else if (stack.get(i) == '+') {
					int num1 = sum.pop();
					int num2 = sum.pop();
					temp = num1 + num2;
					sum.push(temp);
				} else if (stack.get(i) == '*') {
					int num1 = sum.pop();
					int num2 = sum.pop();
					temp = num1 * num2;
					sum.push(temp);
				}

			}
			*/
			//System.out.println("#" + t + " " +sum.pop());
			//sum.clear();
			
		}
	}
}
