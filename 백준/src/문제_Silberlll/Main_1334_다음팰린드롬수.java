package 문제_Silberlll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1334_다음팰린드롬수 {

	static int[] num;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int size = S.length();
		num = new int[size];
		for (int i = 0; i < size; i++) {
			num[i] = S.charAt(i) - '0';
		}
		num[size-1]++;
		for (int i = size-1; i > 0; i--) {
			if(num[i] == 10) {
				num[i] = 0;
				num[i-1]++;
			}
		}
		if(num[0] == 10) {
			size++;
			num[0] = 0;
			int[] copynum = new int[size];
			System.arraycopy(num, 0, copynum, 1, size-1);
			num = new int[size+1];
			System.arraycopy(copynum, 1, num, 1, size-1);
			num[0] = 1;
		}
//		int N = Integer.parseInt(br.readLine())+1;
//		String S = N+"";
//		int size = S.length();

		if(size == 1) 
			sb.append(num[0]);
		else if(size == 2) {
			if(num[0]<num[1])
				num[0]++;
			num[1] = num[0];
			sb.append(num[0]).append(num[1]);
		}
		else {
			int mid = size/2;
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
