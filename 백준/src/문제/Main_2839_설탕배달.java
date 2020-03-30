package 문제;

import java.util.Scanner;

public class Main_2839_설탕배달 {

	static int num, k5, k3;
	static int res;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		k5 = num/5;
		while(true) {
			int target = num-k5*5;
			k3 = target /= 3;
			if(target == 0)
				break;
			k5--;
		}
		res = k5+k3;
		System.out.println(res);
		
	}

}
