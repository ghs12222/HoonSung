package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.InputMap;

public class Solution_9317_석찬이의받아쓰기 {

	static int T, N;
	static int res;
	static String target, sukchan;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			target = br.readLine();
			sukchan = br.readLine();
			res = 0;
			for (int i = 0; i < sukchan.length(); i++) {
				if(sukchan.charAt(i) == target.charAt(i))
					res++;
			}
			
			sb.append("#"+t+" "+res+"\n");
		}
		System.out.println(sb);
	}

}
