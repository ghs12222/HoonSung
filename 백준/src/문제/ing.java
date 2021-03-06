package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ing {

	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine())+1;
		String S = N+"";
		int size = S.length();
		int mid = size/2;
		num = new int[size];
		for (int i = 0; i < size; i++) {
			num[i] = S.charAt(i) - '0';
		}
		if(size == 1) 
			sb.append(N);
		else if(size == 2) {
			num[1] = num[0];
			sb.append(num[0]).append(num[1]);
		}
		else {
			if(size%2==0 && num[mid-1] < num[mid]) 
				num[mid-1]++;
			else if(size%2==0 && num[mid-1] < num[mid+1]) 
				num[mid-1]++;
			for (int i = 0; i < mid; i++) {
				if(num[i] != num[size-1-i])
					num[size-1-i] = num[i];
			}
			for (int i = 0; i < size; i++) {
				sb.append(num[i]);
			}
		}
		System.out.println(sb);
	}

}
