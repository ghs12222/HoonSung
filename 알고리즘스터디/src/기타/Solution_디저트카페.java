package 기타;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_디저트카페 {
	
	static int T,N;
	static int max;
	static int sx,sy;
	static int[][] map;
	static boolean[][] flag;
	static HashSet<Integer> list = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	static int[][] direction = {{1,1},{1,-1},{-1,-1},{-1,1}};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			flag = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sy=i;
					sx=j;
					list.clear();
					flag = new boolean[N][N];
					dfs(i,j,0);
				}
			}
			if(max == 0)
				sb.append("#"+t+" -1\n");
			else
				sb.append("#"+t+" "+max+"\n");
		}		
		System.out.println(sb);
	}

	private static void dfs(int y, int x, int dir) {
		flag[y][x] = true;
		list.add(map[y][x]);
		for (int d = dir; d < 4; d++) {
			int iy = y+direction[d][0];
			int ix = x+direction[d][1];
			int cnt = list.size();
			if(ix==sx && iy == sy && cnt>=4) {
				if(cnt>max) {
					max = cnt;
					return;
				}
			}
			if(safe(iy,ix) && !flag[iy][ix] && !list.contains(map[iy][ix])) {
				dfs(iy,ix,d);
			}
		}
		flag[y][x] = false;
		list.remove(map[y][x]);
	}
	
	private static boolean safe(int y, int x) {
		if(y>=0 && x>=0 && y<N && x<N)
			return true;
		else
			return false;
	}
}
