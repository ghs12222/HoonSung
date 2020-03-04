package Study_0128;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListTest3 {
	
	public static class PC implements Comparator<P> {

		@Override
		public int compare(P o1, P o2) {
			double pc1 = Math.sqrt(o1.x * o1.x + o1.y * o1.y);
			double pc2 = Math.sqrt(o2.x * o2.x + o2.y * o2.y);

			if (pc1 > pc2) {
				return -1;	//그대로 ==> DSC
			} else if (pc1 < pc2) {
				return 1; //반대
			} else {
				return 0;
			}
		}

	}

	public static class P {
		int x;
		int y;

		public P(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public P() {
			super();
		}

		@Override
		public String toString() {
			return "P [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) {
		ArrayList<P> ps = new ArrayList<>();
		ps.add(new P(1, 4));
		ps.add(new P(2, 5));
		ps.add(new P(7, 3));
		ps.add(new P(9, 2));
		ps.add(new P(7, 5));

		for(P p: ps) {
			System.out.println(p);
		}
		ps.sort(new PC());
		System.out.println("--------------");
		for(P p: ps) {
			System.out.println(p);
		}
		ps.sort(new PC());
		//ps.sort(c); // sort(comparator: 기준)

	}

}
