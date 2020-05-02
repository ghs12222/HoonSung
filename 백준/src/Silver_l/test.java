package Silver_l;

public class test {

	public static void main(String[] args) {
		int num = 52;
		System.out.println(num);
		String num2 = Integer.toBinaryString(num);
		String num3 = Integer.toBinaryString(num>>1);
		System.out.println(num2);
		System.out.println(num3);
		String num4 = Integer.toOctalString(num);
		System.out.println(num4);
		String num8 = Integer.toHexString(num);
		System.out.println(num8);
		
		
	}

}
