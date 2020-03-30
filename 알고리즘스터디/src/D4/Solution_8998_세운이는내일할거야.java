package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_8998_세운이는내일할거야 {

	static int T, N;
	static int[][]num;
	static long time, res;
	static StringBuilder sb = new StringBuilder();
	
	public static class C implements Comparator<Integer>{
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return Integer.compare(num[1][o1], num[1][o2]);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[2][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				num[0][i] = Integer.parseInt(st.nextToken());
				num[1][i] = Integer.parseInt(st.nextToken());
			}
			
//			Integer.compare(x, y)
//			Arrays.sort(num[1]);
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(num[1][i]<num[1][j]) {
						int tmp = num[1][i];
						num[1][i] = num[1][j];
						num[1][j] = tmp;
						tmp = num[0][i];
						num[0][i] = num[0][j];
						num[0][j] = tmp;
					}
				}
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(num[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			res = num[1][0];
			time = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				if(time>num[1][i]) {
					time = num[1][i] - num[0][i];
				}
				else if(time<=num[1][i]) {
					time-=num[0][i];
				}
			}
			sb.append("#").append(t).append(" ").append(time).append("\n");
		}
//		System.out.println(sb);
		
	}

}
