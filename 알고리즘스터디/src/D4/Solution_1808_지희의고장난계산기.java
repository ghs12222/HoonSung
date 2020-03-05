package D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기 {

	static int T;
	static int[] num, yaksu;
	static boolean end, count;
	static int target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			num = new int[10];
			yaksu = new int[10];
			for (int i = 0; i < 10; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			target = Integer.parseInt(st.nextToken());

			end = false;
			
			for (int i = 0; i < 10; i++) {
				System.out.println("yaksu["+i+"] = "+yaksu[i]);
			}
			
			if(end) 
			System.out.println("target = " + target);

		}

	}




}
