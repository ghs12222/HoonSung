package Study_0129;

public class GcdTest {

	public static void main(String[] args) {

		System.out.println(gcd(50,30));
		System.out.println(lcm(50,30));
		
	}
	
	public static int gcd(int a, int b) {
		if(a==b) {
			return a;
		}
		else if(a>b) { 
			return gcd(a-b, b);
		}
		else {
			return gcd(a,b-a);
		}
	}
	
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
}
