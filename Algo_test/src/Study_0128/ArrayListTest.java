package Study_0128;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> ns=new ArrayList<>();
		ns.clear(); // 							clear: 	�� ����
		ns.add(1);	//new Interger(1) boxing 	add :	�ǵڿ�
		//Object o=3;	//				 			add3,x: x�� 3��°�� ����
		//int ii=(Integer) o; //(int)			// 	set = �� ��ġ�� ����ģ��.
		ns.add(2);
		ns.add(5);
		ns.add(4);
		ns.add(0,7);
		ns.set(1, -5);

		
		for (int a:ns) {
			System.out.print(a+" ");
		}
		
		System.out.println();
		
		for (int i = 0; i < ns.size(); i++) {
			int b=ns.get(i);
			System.out.print(b+" ");
			
		}
		System.out.println();
		
		System.out.println(ns.contains(5));
		Object[] oo = ns.toArray();
		
		
		
	}

}
