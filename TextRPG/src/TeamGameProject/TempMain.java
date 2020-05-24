package TeamGameProject;

import java.util.Scanner;

public class TempMain {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;
		Town t = new Town();
<<<<<<< HEAD
		System.out.println();
		System.out.println("	┌━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┐");
		System.out.println("	│      ADVENTURE OF JAVA	│");
		System.out.println("	├───────────────────────────────┤");
		System.out.println("	│	1. NEW START		│");
		System.out.println("	├───────────────────────────────┤");
		System.out.println("	│	2. LOAD SAVEFILE	│");
		System.out.println("	└━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┘");
=======
		System.out.println("\n");
		System.out.println("		  Adventure In The JAVA");
		System.out.println();
		System.out.println("		┏━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("		│       	GAME START		│");
		System.out.println("		┗━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("		┣────────────────────┫");
		System.out.println("		│     		1.New Player		│");
		System.out.println("		┣────────────────────┫");
		System.out.println("		│     		2.Load Data		│");
		System.out.println("		┣────────────────────┫");
		System.out.println("		│     		3.Exit Game		│");
		System.out.println("		┗────────────────────┛");
		
>>>>>>> branch 'events' of https://github.com/nullsector12/TeamProject.git
		choice = sc.nextInt();
		
		if (choice == 1) {// 새로 시작
	
			System.out.println("	새로운 캐릭터를 생성합니다.");
			Thread.sleep(500);
			t.d.p.addName();
<<<<<<< HEAD
=======
			Thread.sleep(500);
>>>>>>> branch 'events' of https://github.com/nullsector12/TeamProject.git


		} else if (choice == 2) {// 게임 이어하기
			System.out.println("	저장된 정보를 로드합니다.");
			Thread.sleep(500);
			t.d.p.loadPlayer();
		}else if (choice == 3) {
			System.out.println("	Adventure In the JAVA 게임을 종료합니다.");
			System.exit(0);
		}
		Thread.sleep(500);
		System.out.println("\n\n\n\n");
		System.out.println("	어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");

		while (true) {
			t.town();
		}

	}

}
