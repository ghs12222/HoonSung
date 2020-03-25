package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int AgiSize, EatCnt, Step;
	static PriorityQueue<Point> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pq = new PriorityQueue<Point>();
	
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					map[i][j] = 0;
					flag[i][j] = true;
					pq.add(new Point(i,j,0));
				}
			}
		}
		
		AgiSize = 2;
		EatCnt = 0;
		Step = 0;
		
		gameStart();
		
		System.out.println(Step);
	}

	private static void gameStart() {
		while(!pq.isEmpty()) {
			int count = pq.size();
			Point p = pq.poll();
			for (int k = 0; k < count; k++) {
				System.out.println("p.x = " + p.x + ", p.y = " + p.y);
				print();
				if(map[p.y][p.x] < AgiSize && map[p.y][p.x] !=0) {
					map[p.y][p.x] = 0;
					flag = new boolean[N][N];
					pq.clear();
					pq.add(new Point(p.y, p.x, 0));
					EatCnt++;
					if(EatCnt == AgiSize) {
						AgiSize++;
						EatCnt = 0;
					}
					Step += p.depth;
					break;
				}
				for (int d = 0; d < 4; d++) {
					int ix = p.x + dx[d];
					int iy = p.y + dy[d];
					if(!safe(iy,ix) || flag[iy][ix]) 
						continue;
					if(map[iy][ix] <= AgiSize) {
						pq.add(new Point(iy,ix,p.depth+1));
						flag[iy][ix] = true;
					}
				}
			}
		}
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.print("\t");
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean safe (int y, int x) {
		if(x>=0 && y>=0 && x<N && y<N)
			return true;
		else
			return false;
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

		@Override
		public int compareTo(Point o) {
			if (this.depth > o.depth)
				return 1;
			else if (this.depth == o.depth) {
				if (this.y > o.y)
					return 1;
				else if (this.y == o.y) {
					if (this.x > o.x)
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
