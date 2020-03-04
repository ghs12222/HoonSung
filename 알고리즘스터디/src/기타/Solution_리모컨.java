package 기타;

import java.util.Scanner;

public class Solution_리모컨 {

	static int start, end;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt();
		end = sc.nextInt();
		
		cnt = 0;
		go(start);
		System.out.println(cnt);
		
	}

	private static void go(int start) {
		if(start == end) {
			return;
		}
		
		int target = Math.abs(end - start);
		
		if(target>=10) {
			cnt++;
			if(end - start > 0) 
				go(start+10);
			else
				go(start-10);
		}
		else if(target >=5 && target<10) {
			cnt++;
			if(end - start > 0)
				go(start + 5);
			else
				go(start - 5);
			
		}
	
		else {
			cnt++;
			if(end - start >0)
				go(start + 1);
			else
				go(start - 1);
		}
		
	}

}
