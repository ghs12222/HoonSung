package Study_0128;


import java.util.ArrayList;

public class ArrayListTest2 {
	// 필통 생성 방법!!
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x=x;		//밖에서의 x를 들인다.
			this.y=y;
		}
		public Point() {}	//default
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]" ;
		}
		
	}
	
	public static void main(String[] args) {
		Point p1 = new Point();
		Point p2 = new Point(5,2);
		Point p3 = new Point(5,2);
		p1.x=6;
		System.out.println(p1.x);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println();
		
		Point[] pp = new Point[3];
		pp[0] = new Point();
		pp[1] = new Point(3,6);
		pp[2] = new Point(5,6);
		
		for(Point pt:pp) { 
			System.out.println(pt+" ");
		}
		System.out.println("1");
		//위와 같은거
		//for(int i=0; i<pp.length; i++) {
		//	Point pt=pp[i];
		//System.out.println(pt);
		
		ArrayList<Point> ps=new ArrayList<>();
		ps.add(new Point(4,5));
		ps.add(new Point(3,4));
		ps.add(new Point(2,7));
		
		System.out.println();
		
		for (Point pt:ps) {
			System.out.println(pt);
		}
		System.out.println();
		for (int i = 0; i < ps.size(); i++) {
			Point pt = ps.get(i);
			System.out.println(pt);
		}
		
	}

}
