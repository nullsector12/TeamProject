package TeamGameProject;

import java.util.Scanner;

public class Town {


	Dungeon d = new Dungeon();
	Scanner input = new Scanner(System.in);

	void town() {

		System.out.println("무엇을 하시겠습니까  >>> 1. 던전 가기  2. 캐릭터 정보창  3. 상점 이용  4. 여관 이용(체력회복)   5. 게임 종료");

		while (true) {
			
			int choiceMenu = input.nextInt();
			input.nextLine();

			switch (choiceMenu) {
		
			case 1: // 던전 들어가기
				d.stage(d.p);
				break;
				
			case 2: // 현재 정보 확인
				d.p.showStatus();
				break;
				
			case 3: // 상점 이용
				break;
				
			case 4: // 여관 이용 ( 골드 소모에 따라 플레이어 현재 체력 회복 )
				break;
				
			case 5: // 게임 완전 종료
				System.out.println("게임을 정말 종료하시겠습니까? 종료하면 지금까지의 플레이 기록은 삭제됩니다. y or n");
				String exit = input.nextLine();
				if (exit.equals("y")) {
					System.out.println("게임을 종료합니다. 안녕히 가세요!");
					System.exit(0);
					break;
				} else if (exit.equals("n")) {
					System.out.println("마을로 돌아갑니다.");
					break;
				}

			}return;
		
		}

	}
}