package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2234_성곽 {

	static int N, M;
	static int[][] realmap, map;
	static boolean[][] flag;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int catslecnt, max, wallmax;
	static Queue<Point> que;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		que = new LinkedList<Point>();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		realmap = new int[N][M];
		map = new int[2*N+1][2*M+1];
		flag = new boolean[2*N+1][2*M+1];
		for (int i = 0; i < 2*N+1; i++) {
			Arrays.fill(map[i], 1);
		}
		map[0][0] = -1;
		map[0][2*M] = -1;
		map[2*N][0] = -1;
		map[2*N][2*M] = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				realmap[i][j] = Integer.parseInt(st.nextToken());
				if(realmap[i][j]>=8) {
					realmap[i][j] -= 8;
					map[i*2+1][j*2+1] = 0;
					map[i*2+1+1][j*2+1] = -1;
				}
				if(realmap[i][j]>=4) {
					realmap[i][j] -= 4;
					map[i*2+1][j*2+1] = 0;
					map[i*2+1][j*2+1+1] = -1;
				}
				if(realmap[i][j]>=2) {
					realmap[i][j] -= 2;
					map[i*2+1][j*2+1] = 0;
					map[i*2+1-1][j*2+1] = -1;
				}
				if(realmap[i][j]>=1) {
					realmap[i][j] -= 1;
					map[i*2+1][j*2+1] = 0;
					map[i*2+1][j*2+1-1] = -1;
				}
			}
		}
		
		//성의 개수, 성 크기 최대
		flag = new boolean[2*N+1][2*M+1];
		catslecnt = 0;
		max = Integer.MIN_VALUE;
		for (int i = 0; i < 2*N+1; i++) {
			for (int j = 0; j < 2*M+1; j++) {
				if(map[i][j] == 0 && !flag[i][j]) {
					flag[i][j] = true;
					que.add(new Point(i,j));
					catslecnt++;
					bfs1();
				}
			}
		}
		Print();
		System.out.println(catslecnt);
		System.out.println(max);
		
	}
	
	
	
	private static void bfs1() {
		int size = 1;
		while(!que.isEmpty()) {
			Point p = que.poll();
			for (int d = 0; d < 4; d++) {
				int ix = p.x+dx[d];
				int iy = p.y+dy[d];
				if(!safe(iy,ix) || flag[iy][ix] || map[iy][ix]==-1)
					continue;
				if(map[iy][ix] == 1) {
					que.add(new Point(iy,ix));
					flag[iy][ix] = true;
				}
				else if(map[iy][ix] == 0) {
					que.add(new Point(iy,ix));
					flag[iy][ix] = true;
					size++;
				}
				Printflag();
			}
		}
		if(max<size)
			max = size;
	}

	static boolean safe(int y, int x) {
		if(x>=0 && y>=0 && x<M && y<N)
			return true;
		else
			return false;
	}
	
	static class Point {
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static void Printflag() {
		for (int i = 0; i < N*2+1; i++) {
			for (int j = 0; j < M*2+1; j++) {
				if(flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
				System.out.print("\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void Print() {
		for (int i = 0; i < N*2+1; i++) {
			for (int j = 0; j < M*2+1; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.print("\t");
			for (int j = 0; j < M*2+1; j++) {
				if(flag[i][j])
					System.out.print("1");
				else
					System.out.print("0");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
