package D3;

import java.util.Scanner;
public class Solution_1493_수의새로운연산 {

	static int T;
	static int x,y;
	static int p,q;
	
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			int pq;

			p=scann.nextInt();
			int check_p=1;
			int check = 1;
			while(check_p<p) {
				check++;
				check_p+=check;
			}
			int py = check_p-p+1;
			int check_y=1;
			int m=1;
			for (int i = 1; i < py; i++) {
				check_y+=m;
				m++;
			}
			int tmp = py;
			int px = 1;
			while(p!=check_y) {
				tmp++;
				check_y+=tmp;
				px++;
			}

			q=scann.nextInt();
			check_p=1;
			check = 1;
			while(check_p<q) {
				check++;
				check_p+=check;
			}
			int qy = check_p-q+1;
			check_y=1;
			m=1;
			for (int i = 1; i < qy; i++) {
				check_y+=m;
				m++;
			}
			tmp = qy;
			int qx = 1;
			while(q!=check_y) {
				tmp++;
				check_y+=tmp;
				qx++;
			}
			int rx = px + qx;
			int ry = py + qy;
			
			int Sr=0;
			for (int i = 1; i <=rx ; i++) {
				Sr+=i;
			}
			for (int i = 2; i <=ry; i++) {
				Sr+=rx;
				rx++;
			}
			System.out.println("#" + t + " " + Sr);
			
		}
	}

}
