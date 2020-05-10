package 문제;

public class test {

	public static void main(String[] args) {

		int test = 11;
		for (int d = 0; d < 4; d++) {
			if ((test & (1 << d)) == 0)
				System.out.print(0);
			else
				System.out.print(1);
		}
	}

}
