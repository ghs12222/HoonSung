package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9015_배열의분할 {

	static int T, N;
	static int[] num;
	static int Min;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			Min = Integer.MAX_VALUE;
			int cnt = 1;
			boolean ascending;
			if(num[0] <= num[1])
				ascending = true;
			else
				ascending = false;
			for (int i = 1; i < N; i++) {
				if(ascending) {
					if(num[i-1] <= num[i])
						continue;
					else {
						ascending = false;
						cnt++;
					}
				}
				else {
					if(num[i-1] >= num[i])
						continue;
					else {
						ascending = true;
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
			
		}
		
		
	}

}
