package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_8741_두문자어 {

	static int T;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String S = br.readLine();
			char[] c = new char[3];
			int cnt = 1;
			c[0] = S.charAt(0);
			for (int i = 0; i < S.length(); i++) {
				if(S.charAt(i) == ' ') {
					c[cnt] = S.charAt(i+1);
					cnt++;
				}
			}
			System.out.print("#" + t+" ");
			for (int i = 0; i < 3; i++) {
				System.out.print((char)(c[i]-'a'+'A'));
			}
			System.out.println();
			
		}
		
	}

}
