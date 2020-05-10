package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ing {

	static int N;
	static int[][] map;
	static boolean[][] flag;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int eatCnt, stepCnt, agiSize, step;
	static PriorityQueue<Point> que;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new PriorityQueue<Point>();
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		flag = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					que.add(new Point(i, j, 0));
					flag[i][j] = true;
					map[i][j] = 0;
				}
			}
		}

		step = 0;
		stepCnt = 0;
		eatCnt = 0;
		agiSize = 2;
		gameStrat();
		System.out.println(step);

	}

	private static void gameStrat() {
//		while (!que.isEmpty()) {
//			int count = que.size();
//			// 먹을때
//			for (int i = 0; i < count; i++) {
//				Point p = que.poll();
//				if (map[p.y][p.x] != 0 && map[p.y][p.x] < agiSize) {
//					flag = new boolean[N][N];
//					flag[p.y][p.x] = true;
//					map[p.y][p.x] = 0;
//					que.clear();
//					que.add(new Point(p.y, p.x, 0));
//					step += p.depth;
//					eatCnt++;
//					if (eatCnt == agiSize) {
//						eatCnt = 0;
//						agiSize++;
//					}
//					break;
//				}
//
//				for (int d = 0; d < 4; d++) {
//					int ix = p.x + dx[d];
//					int iy = p.y + dy[d];
//					if (!safe(iy, ix) || flag[iy][ix])
//						continue;
//					if (map[iy][ix] <= agiSize) {
//						flag[iy][ix] = true;
//						que.add(new Point(iy, ix, p.depth + 1));
//					}
//				}
//			}
//		}
		while (!que.isEmpty()) {
			int size = que.size();
			a: for (int k = 0; k < size; k++) {
				Point p = que.poll();
				for (int d = 0; d < 4; d++) {
					int ix = p.x+dx[d];
					int iy = p.y+dy[d];
					if(!safe(iy,ix) || flag[iy][ix] || map[iy][ix] > agiSize)
						continue;
					if(map[iy][ix] == 0 || map[iy][ix] == agiSize) {
						que.add(new Point(iy,ix,p.depth+1));
						flag[iy][ix] = true;
					}
					else if(map[iy][ix] < agiSize) {
//						step += p.depth+1;
						step += stepCnt+1;
						stepCnt=0;
						eatCnt++;
						if(eatCnt == agiSize) {
							agiSize++;
							eatCnt = 0;
						}
						que.clear();
						que.add(new Point(iy,ix,0));
						flag = new boolean[N][N];
						flag[iy][ix] = true;
						map[iy][ix] = 0;
						break a;
					}
				}
//				stepCnt++;
			}
		}
	}

	static boolean safe(int y, int x) {
		if (y >= 0 && x >= 0 && x < N && y < N)
			return true;
		else
			return false;

	}

	static class Point implements Comparable<Point> {
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
		public int compareTo(Point target) {
			if (this.depth > target.depth)
				return 1;
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
