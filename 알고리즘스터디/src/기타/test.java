package 기타;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.BrokenBarrierException;

public class test {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int cnt = 0;
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < 10000; j++) {
				System.out.print(cnt++ +" ");
			}
			System.out.println();
		}

//		int cnt = 0;
//		for (int i = 0; i < 1000; i++) {
//			for (int j = 0; j < 10000; j++) {
//				sb.append(cnt++).append(" ");
//			}
//			System.out.println();
//		}
//		System.out.println(sb);
		
//		int cnt = 0;
//		for (int i = 0; i < 1000; i++) {
//			for (int j = 0; j < 10000; j++) {
//				bw.write(cnt++ + " ");
//			}
//			bw.write("\n");
//		}
//		bw.close();
		
	}

}
