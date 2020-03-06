package D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_9480_민정이와광직이의알파벳공부 {

	static int T, N;
	static String[] minjung;
	static boolean[] flag;
	static int res, end;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Stack<String> alphbet = new Stack<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			minjung = new String[N];

			for (int i = 0; i < N; i++) {
				minjung[i] = br.readLine();
			}
			
			res = 0;
			for (int i = 1; i <= N; i++) {
				alphbet.clear();
				end = i;
				Combi(0, 0);

			}
			sb.append("#" + t + " " + res + "\n");

		}
		System.out.println(sb);

	}

	private static void Combi(int start, int count) {
		if (count == end) {
			flag = new boolean[26];
			for (int i = 0; i < alphbet.size(); i++) {
				String s = alphbet.get(i);
				for (int j = 0; j < s.length(); j++) {
					flag[s.charAt(j)-97] = true;
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				if(flag[i])
					cnt++;
			}
			
			if (cnt == 26) {
				res++;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			for (int j = 0; j < minjung[i].length(); j++) {
				alphbet.add(minjung[i]);
			}
			Combi(i+1, count+1);
			for (int j = 0; j < minjung[i].length(); j++) {
				alphbet.pop();
			}
		}
	}

}
