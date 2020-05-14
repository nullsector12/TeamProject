package TeamGameProject;

import java.util.Scanner;

public class TempMain {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;
		Town t = new Town();

		System.out.println("		    ADVENTURE OF JAVA");
		System.out.println("		-------------------------");
		System.out.println("		|	GAME START	|");
		System.out.println("		-------------------------");
		System.out.println("		1.새로시작	2.이어하기");
		choice = sc.nextInt();
		if (choice == 1) {// 새로 시작
			t.d.p.addName();
			System.out.println("	새로 시작한다");

		} else if (choice == 2) {// 게임 이어하기
			System.out.println("	저장된 정보를 로드합니다.");
			t.d.p.loadPlayer();
		}
		System.out.println("	어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");

		while (true) {
			t.town();
		}

	}

}
