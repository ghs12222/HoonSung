package 문제_Gold_V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1756_피자굽기 {
	
	static int N, D;
	static int[] ovenSize, pizzaSize;
	static int high;
	static boolean possible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		ovenSize = new int[D];
		pizzaSize = new int[N];
		possible = true;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			ovenSize[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pizzaSize[i] = Integer.parseInt(st.nextToken());
			if(ovenSize[0] == 0) {
				possible = false;
				break;
			}
			int target = 0;
			for (int j = D-1; j >= 0; j--) {
				target = j;
				if(pizzaSize[i]<=ovenSize[j])
					continue;
				else
					break;
			}
			ovenSize[target] = 0;
		}
		
		for (int i = D-1; i >= 0; i--) {
			if(ovenSize[i] == 0) {
				high = i;
				break;
			}
		}
		if(possible)
			System.out.println(high);
		else
			System.out.println("0");
	
		
	}

}
