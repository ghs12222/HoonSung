package 문제_Gold_lll;

import java.util.LinkedList;

public class test {
	
	static LinkedList<Integer> list;
	
	
	public static void main(String[] args) {
		list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.remove(4);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}

}
