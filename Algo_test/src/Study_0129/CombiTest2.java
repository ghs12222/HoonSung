package Study_0129;

public class CombiTest2 {

	static int R=3;
	static int N=5;
	static char[] cs;
	static int cnt;
	
	public static void main(String[] args) {
		cnt=0;
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
			cs[count]=(char)('A'+i); //'A'+i�� ���� (char �� Ʈ��)
			nCr(i+1, count+1); //���Ϲ��� �߻�����
			//nCr(i, count+1); //�տ��� �ٽý��� -> ���Ϲ��� �߻� 'AAA'
		}
	}
	
}
