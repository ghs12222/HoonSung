package Test;

import java.util.Scanner;

public class 입출력의모든것 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		//1. 숫자 입출력
		System.out.println("1. 숫자입출력");
		
		//1) 띄어쓰기
		System.out.println("1) 띄어쓰기");
		int[] num1 = new int[4];
		for (int i = 0; i < num1.length; i++) {
			num1[i] = scann.nextInt();
			System.out.print(num1[i]+" ");
		}
		System.out.println();
		System.out.println();
		
		//2) 붙여쓰기
		System.out.println("2) 붙여쓰기");
		String num2_s = scann.next();
		int[] num2 = new int[num2_s.length()];
		for (int i = 0; i < num2.length; i++) {
			num2[i] = num2_s.charAt(i)-'0';
			System.out.print(num2[i]+" ");
		}
		//더없을까
		System.out.println();
		System.out.println();
		
		//2. char형 입출력
		System.out.println("2. char형 입출력");
		
		//1)띄어쓰기
		System.out.println("1) 띄어쓰기 1차원_toCharArray");
		String ch1_s = scann.next();
		char[] ch1 = new char[ch1_s.length()];
		ch1 = ch1_s.toCharArray();
		System.out.println();
		
		System.out.println("1) 띄어쓰기 1차원_charAt");
		String ch2_s = scann.next();
		char[] ch2 = new char[ch2_s.length()];
		for (int i = 0; i < ch1.length; i++) {
			ch1[i] = ch2_s.charAt(i);
		}
		System.out.println();
		
		System.out.println("1) 띄어쓰기 1차원_split");
		String ch3_s = scann.next();
		char[] ch3 = new char[ch3_s.length()];
		for (int i = 0; i < ch3.length; i++) {
//			ch3[i] = ch3_s.split("");
		}
		
//		/scann.nex
		
	}

}
