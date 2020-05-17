package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int N, M;
	static List<Point> house;
	static List<Point> chicken;
	static int[] num, distance;
	static int houseCnt, chickenCnt, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		house = new LinkedList<Point>();
		chicken = new LinkedList<Point>();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					house.add(new Point(i, j));
				} else if (num == 2) {
					chicken.add(new Point(i, j));
				}
			}
		}
		houseCnt = house.size();
		chickenCnt = chicken.size();
		num = new int[chickenCnt];
		res = Integer.MAX_VALUE;
		Combi(0, 0);
		System.out.println(res);
	}

	private static void Combi(int start, int count) {
		if (count == M) {
			int sum = 0;
			for (int i = 0; i < houseCnt; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int x = (int) Math.abs(house.get(i).x - chicken.get(num[j]).x);
					int y = (int) Math.abs(house.get(i).y - chicken.get(num[j]).y);
					if(min>x+y) {
						min = x+y;
					}
				}
				sum+= min;
			}
//			System.out.println("sum = " + sum);
			if(res>sum)
				res = sum;
			return;
		}

		for (int i = start; i < chickenCnt; i++) {
			num[count] = i;
			Combi(i + 1, count + 1);
		}

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


}
