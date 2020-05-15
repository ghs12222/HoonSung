package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_3020_개똥벌레 {
	
	static int H, N;
	static int[] num1,num2, num;
	static int min, count;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		num1 = new int[H];
		num2 = new int[H];
		num = new int[H];
		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine())-1;
			if(i%2==0) {
				num1[len]++;
			}
			else {
				num2[H-len-1]++;
			}
		}
		
		for (int i = H-2; i >= 0; i--) {
			num1[i] += num1[i+1];
		}
		
		for (int i = 1; i < H; i++) {
			num2[i] += num2[i-1];
		}
		for (int i = 0; i < H; i++) {
			num[i] = num1[i] + num2[i];
		}
		min = Integer.MAX_VALUE;
		count = 0;
		
		for (int i = 0; i < H; i++) {
			if(min>num[i]) {
				min = num[i];
				count = 1;
			}
			else if(min == num[i])
				count++;
		}
		System.out.println(min + " " + count);
		
	}

}
