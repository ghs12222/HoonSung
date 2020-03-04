package com.saffy.java;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieMgr mgr = new MovieMgr();
		int type = -1;
		while (type != 0) {
			System.out.println("<<<��ȭ ���� ���α׷�>>>");
			System.out.println("1. ��ȭ ���� �Է�");
			System.out.println("2. ��ȭ ���� ��ü �˻�");
			System.out.println("3. ��ȭ�� �˻�");
			System.out.println("4. ��ȭ �帣�� �˻�");
			System.out.println("5. ��ȭ ���� ����");
			System.out.println("0. ����");
			System.out.println("���ϴ� ��ȣ�� �����ϼ���.");
			type = sc.nextInt();
			switch (type) {
			case 1:
				System.out.print("��ȭ��     : ");
				String name = sc.next();
				System.out.print("��ȭ���� : ");
				String director = sc.next();
				System.out.print("�帣       : ");
				String genre = sc.next();
				System.out.print("��� : ");
				int grade = sc.nextInt();
				mgr.add(new Movie(name, director, grade, genre));
				break;
			case 2:
				Movie[] mlist = mgr.search();
				for (int i = 0; i < mgr.getSize(); i++) {
					if (mlist[i] == null)
						continue;
					System.out.println(mlist[i].toString());
				}
				break;
			case 3:
				System.out.print("�˻��� ��ȭ���� �Է��ϼ��� : ");
				String S = sc.next();
				Movie[] mslist = mgr.search(S);
				for (int i = 0; i < mgr.getSize(); i++) {
					if (mslist[i] == null)
						continue;
					System.out.println(mslist[i].toString());
				}
				break;
			case 4:
				System.out.print("�˻��� �帣�� �Է��ϼ��� : ");
				String G = sc.next();
				Movie[] mglist = mgr.searchGenre(G);
				for (int i = 0; i < mgr.getSize(); i++) {
					if (mglist[i] == null)
						continue;
					System.out.println(mglist[i].toString());
				}
				break;

			case 5:
				System.out.print("������ ��ȭ���� �Է��ϼ��� : ");
				String D = sc.next();
				mgr.delete(D);
				break;
			case 0:
				System.out.println("����Ǿ����ϴ�.");
				return;

			default:
				break;

			}

		}

	}

}
