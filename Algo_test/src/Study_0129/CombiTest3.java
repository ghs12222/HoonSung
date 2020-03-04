package Study_0129;

public class CombiTest3 {

	static int R=3;
	static int N=5;
	static char[] cs = new char[5];
	static int cnt;
	static boolean[] checked;
	
	public static void main(String[] args) {
		cnt=0;
		cs="ABCDE".toCharArray();
		checked=new boolean[N];
		nCr(0,0);
		System.out.println(cnt);
	}

	public static void nCr(int start, int count) {
		if(count==R) {
			String as="";
			String bs="";
//			char[] cc = new char[R];
			for (int i = 0; i < checked.length; i++) {
				if(checked[i]) {
					as=as+cs[i];
				} else {
					bs=bs+cs[i];
				}
			}
			System.out.println(as);
			System.out.println(bs);
			return ;
		}
		for (int i = start; i < N; i++) {
			if(!checked[i]) { //checked[i] == false
				checked[i] = true;
				nCr(i+1, count+1);
				checked[i] = false;  //중요!~!!!!
			}
			
			cs[count]=(char)('A'+i); //'A'+i는 숫자 (char 형 트릭)
			nCr(i+1, count+1); //동일문자 발생안함
			//nCr(i, count+1); //앞에서 다시시작 -> 동일문자 발생 'AAA'
		}
	}
	
}
