package com.saffy.java;

public class TaxiUser {

	public static void main(String[] args) {
		Car car1 = new Car("K3", "����", "���",5);
		Car car2 = new Taxi("K5", "�����", "����", 5, 5, 5);

		Taxi taxi1 = new Taxi("K5", "��ȫ��", "���",5,5,5);
//		Taxi taxi2 = new Car("k7", "���", "���",7);			//�Ұ���
//		Taxi taxi2 = (Taxi) new Car("k7", "���", "���",7);	//����
		
		car1.isCar();
		System.out.println();

		car2.isCar();
//		car2.isTaxi();		����
		System.out.println();
		
		taxi1.isCar();
//		taxi1.is();
		System.out.println();
		
//		taxi2.isCar();
//		taxi2.isTaxi();
//		System.out.println();
		
		int km = 15;
		
		
	}
}
