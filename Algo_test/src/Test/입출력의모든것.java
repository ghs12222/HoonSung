package Test;

import java.util.Scanner;

public class ������Ǹ��� {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		//1. ���� �����
		System.out.println("1. ���������");
		
		//1) ����
		System.out.println("1) ����");
		int[] num1 = new int[4];
		for (int i = 0; i < num1.length; i++) {
			num1[i] = scann.nextInt();
			System.out.print(num1[i]+" ");
		}
		System.out.println();
		System.out.println();
		
		//2) �ٿ�����
		System.out.println("2) �ٿ�����");
		String num2_s = scann.next();
		int[] num2 = new int[num2_s.length()];
		for (int i = 0; i < num2.length; i++) {
			num2[i] = num2_s.charAt(i)-'0';
			System.out.print(num2[i]+" ");
		}
		//��������
		System.out.println();
		System.out.println();
		
		//2. char�� �����
		System.out.println("2. char�� �����");
		
		//1)����
		System.out.println("1) ���� 1����_toCharArray");
		String ch1_s = scann.next();
		char[] ch1 = new char[ch1_s.length()];
		ch1 = ch1_s.toCharArray();
		System.out.println();
		
		System.out.println("1) ���� 1����_charAt");
		String ch2_s = scann.next();
		char[] ch2 = new char[ch2_s.length()];
		for (int i = 0; i < ch1.length; i++) {
			ch1[i] = ch2_s.charAt(i);
		}
		System.out.println();
		
		System.out.println("1) ���� 1����_split");
		String ch3_s = scann.next();
		char[] ch3 = new char[ch3_s.length()];
		for (int i = 0; i < ch3.length; i++) {
//			ch3[i] = ch3_s.split("");
		}
		
//		/scann.nex
		
	}

}
