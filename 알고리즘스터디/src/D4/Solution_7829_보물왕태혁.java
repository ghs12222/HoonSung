package D4;
import java.util.Scanner;
public class Solution_7829_보물왕태혁 {

	static int T;
	static int P;
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		
		T = scann.nextInt();
		for (int t = 1; t <= T; t++) {
			P = scann.nextInt();
			int[] num = new int[P];
			int res = 0;
			for (int i = 0; i < P; i++) {
				num[i] = scann.nextInt();
			}

			for (int i = 0; i < P-1; i++) {
				for (int j = i+1; j < P; j++) {
					if(num[i]>num[j]) {
						int tmp = num[i];
						num[i] = num[j];
						num[j] = tmp;
					}
				}
			}
			
			if(P == 1)
				res = num[0] * num[0];
			else if (P/2 == 0) {
				res = num[P/2] * num[P/2+1];
			}
			else
				res = num[0] * num[P-1];
			
			System.out.println("#"+t+" "+res);
		}
		
	}

}
