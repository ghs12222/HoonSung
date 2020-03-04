package com.saffy.java;

import java.util.Scanner;

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieMgr mgr = new MovieMgr();
		int type = -1;
		while (type != 0) {
			System.out.println("<<<영화 관리 프로그램>>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요.");
			type = sc.nextInt();
			switch (type) {
			case 1:
				System.out.print("영화명     : ");
				String name = sc.next();
				System.out.print("영화감독 : ");
				String director = sc.next();
				System.out.print("장르       : ");
				String genre = sc.next();
				System.out.print("등급 : ");
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
				System.out.print("검색할 영화명을 입력하세요 : ");
				String S = sc.next();
				Movie[] mslist = mgr.search(S);
				for (int i = 0; i < mgr.getSize(); i++) {
					if (mslist[i] == null)
						continue;
					System.out.println(mslist[i].toString());
				}
				break;
			case 4:
				System.out.print("검색할 장르를 입력하세요 : ");
				String G = sc.next();
				Movie[] mglist = mgr.searchGenre(G);
				for (int i = 0; i < mgr.getSize(); i++) {
					if (mglist[i] == null)
						continue;
					System.out.println(mglist[i].toString());
				}
				break;

			case 5:
				System.out.print("삭제할 영화명을 입력하세요 : ");
				String D = sc.next();
				mgr.delete(D);
				break;
			case 0:
				System.out.println("종료되었습니다.");
				return;

			default:
				break;

			}

		}

	}

}
