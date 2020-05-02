package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int N;
	static int[] team1, team2;
	static boolean[] flag1, flag2;
	static int[][] list;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		list = new int[N][N];
		team1 = new int[N/2];
		team2 = new int[N/2];
		flag1 = new boolean[N];
		flag2 = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Combi(0,0);
		
	}


	private static void Combi(int start, int count) {
		if(count == N/2-1) {
			flag2 = new boolean[N];
			for (int i = 0; i < N/2; i++) {
				for (int j = 0; j < N; j++) {
					if(!flag1[j] && !flag2[j]) {
						team2[i]=j;
						flag2[j]=true;
						continue;
					}
				}
			}
			
			System.out.print("team1 = ");
			for (int i = 0; i < N/2; i++) {
				System.out.print(team1[i] + " ");
			}
			System.out.println();
			System.out.print("team2 = ");
			for (int i = 0; i < N/2; i++) {
				System.out.print(team2[i] + " ");
			}
			System.out.println();
		}
		
		for (int i = start; i < N; i++) {
			System.out.println("count = " + count);
			team1[count] = i+1;
			flag1[i] = true;
			Combi(i+1, count+1);
			flag1[i] = false;
		}
		
	}

}
