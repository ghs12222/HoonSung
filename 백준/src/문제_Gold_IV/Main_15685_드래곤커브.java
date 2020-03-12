package 문제_Gold_IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {

	static int N;
	static int[] X, Y, D, G;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] flag, save_map;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		X = new int[N];
		Y = new int[N];
		D = new int[N];
		G = new int[N];
		res = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
			G[i] = Integer.parseInt(st.nextToken());
		}

		save_map = new boolean[100][100];
		
		for (int i = 0; i < N; i++) {
			flag = new boolean[100][100];
			GameStart(Y[i],X[i],D[i],G[i]);
		}
		
		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 99; j++) {
				if(save_map[i][j] && save_map[i+1][j] && save_map[i][j+1] && save_map[i+1][j+1])
					res++;
			}
		}
		System.out.println(res);

	}


	private static void GameStart(int sy, int sx, int dir, int g) {
		flag = new boolean[100][100];
		flag[sy][sx] = true;
		flag[sy+dy[dir]][sx+dx[dir]] = true;
		
		for (int k = 0; k < g; k++) {
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(flag[i][j]) {
						int ix = sx-j;
						int iy = sy-i;
						if(!safe(iy,ix))
							continue;
						if(ix>=0 && iy>=0) {
							flag[sy+i][j] = true;
						}

						if(ix>=0 && iy<=0) {
							flag[i][sx+j] = true;
						}
					
						if(ix<=0 && iy<=0) {
							flag[sy-i][j] = false;
						}
						
						if(ix<=0 && iy>=0) {
							flag[i][sx-j] = true;
						}
						
					}
				}
			}
		}
		
		//save_map에 저장
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(flag[i][j])
					save_map[i][j] = true;
			}
		}
		
		
	}


	private static boolean safe(int y, int x) {
		if (x >= 0 && y >= 100 && x < 100 && y < 100)
			return true;
		else
			return false;
	}

}
