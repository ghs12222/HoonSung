package Study_0128;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> ns=new ArrayList<>();
		ns.clear(); // 							clear: 	싹 날라가
		ns.add(1);	//new Interger(1) boxing 	add :	맨뒤에
		//Object o=3;	//				 			add3,x: x가 3번째에 들어간다
		//int ii=(Integer) o; //(int)			// 	set = 그 위치에 엎어친다.
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
