package Study_0129;

public class PermTest2 {

	static int R=3;
	static int N=5;
	static char[] cs;
	static int cnt;
	
	public static void main(String[] args) {
		cs=new char[R];
		nCr(0,0);
		System.out.println(cnt);
	}

	public static void nCr(int start, int count) {
		if(count==R) {
			cnt++;
			System.out.println(String.valueOf(cs));
			return ;
		}
		for (int i = start; i < N; i++) {
			cs[count]=(char)('A'+i); //'A'+i는 숫자 (char 형 트릭)
			nCr(i+1, count+1);
		}
	}
	
}
