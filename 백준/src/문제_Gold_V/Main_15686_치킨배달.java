package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N, M;
	static List<Integer>[] house;
	static List<Integer>[] chicken;
	static int[] target;
	static int min, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		target = new int[M];
		Arrays.fill(target, -1);
		house = new LinkedList[2];
		chicken = new LinkedList[3];
		for (int i = 0; i < 2; i++)
			house[i] = new LinkedList<>();
		for (int i = 0; i < 3; i++)
			chicken[i] = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					house[0].add(i);
					house[1].add(j);
				} else if (num == 2) {
					chicken[0].add(i);
					chicken[1].add(j);
					chicken[2].add(Integer.MAX_VALUE);
				}
			}
		}

		min = Integer.MAX_VALUE;
		for (int k = 0; k < M; k++) {
			int size = house[0].size();
			for (int s = 0; s < size; s++) {
				int ix = (int) Math.abs(house[0].get(s) - chicken[0].get(k));
				int iy = (int) Math.abs(house[1].get(s) - chicken[1].get(k));
				int distance = ix + iy;
				if (chicken[2].get(k) > distance) {
					chicken[2].set(k, distance);
					min = distance;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (chicken[2].get(i) > min) {
				target[cnt] = i;
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 3; j++) {
				chicken[j].remove(i);
			}
		}
		int c = chicken[0].size();
		for (int k = 0; k < c; k++) {
			int size = house[0].size();
			for (int s = 0; s < size; s++) {
				int ix = (int) Math.abs(house[0].get(s) - chicken[0].get(k));
				int iy = (int) Math.abs(house[1].get(s) - chicken[1].get(k));
				int distance = ix + iy;
				res += distance;
			}
		}
		
		System.out.println(res);
	}

	static boolean safe(int y, int x) {
		if (x >= 0 && y >= 0 && x < N && y < N)
			return true;
		else
			return false;
	}

	static class Point {
		int y;
		int x;
		int depth;

		public Point(int y, int x, int depth, int count) {
			super();
			this.y = y;
			this.x = x;
			this.depth = depth;
			this.count = count;
		}

		int count;
	}

}
