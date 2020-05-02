package test;

public class test2 {

	static int[] num, numcheck;
	static boolean[] flag;
	static int size;
	static int[] numbers = {10, 40, 30, 20};
	static int K = 20;
	static int min;
	public static void main(String[] args) {
		size = numbers.length;
		num = new int[size];
		numcheck = new int[size];
		flag = new boolean[size];
		min = Integer.MAX_VALUE;
		Permi(0);
		System.out.println(min);
	}

	
	private static void Permi(int count) {
		if(count == size) {
			int res = check();
			if(min>res)
				min = res;
			return;
		}
		
		for (int i = 0; i < size; i++) {
			if(!flag[i]) {
				flag[i] = true;
				numcheck[count] = i+1;
				num[count] = numbers[i];
				Permi(count+1);
				flag[i] = false;
			}
		}
		
	}


	private static int check() {
		boolean aa = true;
		int cnt = 0;
		for (int i = 1; i < size; i++) {
			if(Math.abs(num[i-1]-num[i])<K) {
				aa = false;
				break;
			}
		}
		if(aa) {
			for (int i = 0; i < size; i++) {
				if(numcheck[i] != i)
					cnt++;
			}
		}
		cnt /= 2;
		return cnt;
		
	}
}
