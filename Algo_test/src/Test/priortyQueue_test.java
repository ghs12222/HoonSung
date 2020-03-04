package Test;

import java.util.PriorityQueue;

public class priortyQueue_test {

	public static void main(String[] args) {
		PriorityQueue<Integer> prq = new PriorityQueue<Integer>();
		
		for (int i = 3; i < 10; i++) {
			prq.add(i);
		}
		
		System.out.println(prq);
		
		Integer head = prq.peek();
		System.out.println(head);
		
	}
	
	
	

}
