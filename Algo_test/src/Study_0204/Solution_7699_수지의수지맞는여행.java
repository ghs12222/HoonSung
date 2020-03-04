package Study_0204;

import java.util.Scanner;

public class Solution_7699_수지의수지맞는여행 {

	static int T;
	static char[][] map;
	static boolean [] alphbet;
	static int ans, R, C;
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			R=scann.nextInt();
			C=scann.nextInt();
			map=new char[R][C];
			alphbet=new boolean[26];
			for (int i = 0; i <R; i++) {
				map[i]=scann.next().toCharArray();
			}
			ans=0;// 명물 최대치
			alphbet[map[0][0]-'A']=true;
			dfs(0,0,1);
			
			System.out.println("#"+t+" "+ans);
		}
	}
	
	static int[] di= {0,0,1,-1};   //우좌하상
	static int[] dj= {1,-1,0,0};
	public static void dfs(int i, int j, int cnt) {
	
		if(ans<cnt) {
			ans=cnt;
		}
		
		if(cnt==26) { return ;}
		alphbet[map[i][j]-'A']=true;
		for (int d = 0; d < 4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !alphbet[map[ni][nj]-'A']) {
				dfs(ni,nj,cnt+1);
			}
		}
		alphbet[map[i][j]-'A']=false;
		
	}

}








