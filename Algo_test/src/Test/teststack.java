package Test;

import java.util.Stack;

public class teststack {

	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		stack.add('a');
		stack.add('b');
		if(stack.contains('a')) {
			System.out.println('Y');
		}

	}

}
