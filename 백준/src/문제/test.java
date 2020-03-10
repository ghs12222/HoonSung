package 문제;

import java.util.PriorityQueue;

public class test {

	static PriorityQueue<Point> que;
	
	public static void main(String[] args) {
		que = new PriorityQueue<Point>();
		
		que.add(new Point(1,2,3));
		que.add(new Point(2,2,3));
		que.add(new Point(1,2,2));
		que.add(new Point(1,1,2));
		que.add(new Point(5,2,1));
		que.add(new Point(4,3,1));
		
		int count = que.size();
		for (int i = 0; i < count; i++) {
			System.out.println(que.poll().toString());
		}
		
	}
	
	private static class Point implements Comparable<Point> {
		int y;
		int x;
		int depth;

		public Point(int y, int x, int depth) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
		}

		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", depth=" + depth + "]";
		}

		@Override
		public int compareTo(Point target) {
			if (this.depth > target.depth) {
				return 1;
			}
			else if (this.depth == target.depth) {
				if (this.y > target.y)
					return 1;
				else if (this.y == target.y) {
					if (this.x > target.x)
						return 1;
					else
						return -1;
				}
				return -1;
			}
			return -1;
		}

	}

}
