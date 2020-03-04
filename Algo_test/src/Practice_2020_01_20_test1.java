import java.util.Scanner;
public class Practice_2020_01_20_test1 {
	
	static int iT;
	static int n=9;
	static int[] num;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		iT=scann.nextInt();
		
		for (int i = 0; i < iT; i++) {
			num=new int[n];
			for (int j = 0; j < n; j++) {
				num[j]=scann.nextInt();
			}
			
		}

	}

}


/*
import java.util.Scanner;

public class Solution {
 
    static int iT;
    static int n=10;
    static int[] num;
     
    public static void main(String[] args) {
        Scanner scann=new Scanner(System.in);
        iT=scann.nextInt();
         
        for (int i = 1; i <= iT; i++) {
            num=new int[n];
            for (int j = 0; j < n; j++) {
                num[j]=scann.nextInt();
            }
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=num[j];
            }
            double ds=0.0;
            ds=Math.round(1.0*sum/n);
             
            System.out.printf("#%d %.0f\n",i, ds);
        }
    }
}
*/