package TeamGameProject;

import java.util.Scanner;
import inventory.Inventory;
import store.Store;

/**
 * 앞으로 추가 할 사항 :
 * 
 * 보스 사냥 성공 후 다음 스테이지 도전 or 마을 복귀 선택지 장비 탈착 기능
 * 
 *
 */
public class Town {

	Scanner input = new Scanner(System.in);
	Dungeon d = new Dungeon();
	Store store = new Store();
	Inventory inven = new Inventory();

	void town() throws InterruptedException {

		while (true) {
			System.out.println("\n");
			System.out.println("	++++++++	JAVA TOWN	+++++++++");
			System.out.println("	|					|");
			System.out.println("	|	          무엇을 하시겠습니까?		|");
			System.out.println("	|					|");
			System.out.println("	|	  1. 던전 가기			|");
			System.out.println("	|	  2. 캐릭터 정보			|");
			System.out.println("	|	  3. 장비창			|");
			System.out.println("	|	  4. 상점 이용			|");
			System.out.println("	|	  5. 여관 이용 (체력 회복 가능)		|");
			System.out.println("	|	  6. 현재 데이터 저장하기		|");
			System.out.println("	|	  7. 이전 데이터 불러오기		|");
			System.out.println("	|	  8. 게임 종료			|");
			System.out.println("	|					|");
			System.out.println("	+++++++++++++++++++++++++++++++++++++++++");

			int choiceMenu = input.nextInt();
			input.nextLine();

			switch (choiceMenu) {

			case 1: // 던전 들어가기
				if (d.stage(d.p)) {
					continue;
				}
				break;

			case 2: // 현재 정보 확인
				d.p.showStatus();
				break;

			case 3: // 인벤토리 확인
				inven.Inventory(d.p);
				break;

			case 4: // 상점 이용
				store.store(d.p);
				break;

			case 5: // 여관 이용 ( 골드 소모에 따라 플레이어 현재 체력 회복 )
				inn();
				break;

			case 6:// 저장
				d.p.savePlayer();
				break;
			case 7:// 불러오기
				d.p.loadPlayer();
				break;
			case 8: // 게임 완전 종료
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

			}
			return;

		}

	}

	// 장비 장착한 체력값으로 수정
	void inn() {

		System.out.println("	어서오세요, 모험가님. JAVA 여관에 오신걸 환영합니다.");

		while (true) {

			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ어떤 종류의 방을 원하시나요?ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println();
			System.out.println("+===========================================================+");
			System.out.println("| 							    |");
			System.out.println("| 	1. 다락방 : 숙박비 - 35Gold / 효과 : 최대 체력의 15% 회복	    |");
			System.out.println("|	2. 저급 숙소 : 숙박비 - 50 Gold / 효과 : 최대 체력의 25% 회복      |");
			System.out.println("|	3. 보통 숙소 : 숙박비 - 100 Gold / 효과 : 최대 체력의 40% 회복    |");
			System.out.println("|	4. 고급 숙소 : 숙박비 - 150Gold / 효과 : 최대 체력의 65% 회복      |");
			System.out.println("|	5. FLEX : 숙박비 - 250Gold / 효과 :  체력 완전 회복	    |");
			System.out.println("|	6. 여관을 나간다.				            |");
			System.out.println("|						            |");
			System.out.println("+===========================================================+");

			int choiceRoomClass = input.nextInt();
			input.nextLine();

			switch (choiceRoomClass) {

			case 1:
				System.out.println("	다락방을 선택하셨습니다. 35Gold를 지불합니다.");
				if (d.p.getGold() > 35) {
					d.p.setGold(d.p.getGold() - 35);
					System.out.println("	현재 소지금 : " + d.p.getGold());
					// d.p.setCurrentHealth(d.p.invenCurrentHealth + (int) (d.p.invenMaxHealth *
					// 1.15));

					d.p.setInvenCurrentHealth(d.p.getInvenCurrentHealth() + (int) (d.p.getInvenMaxHealth() * 0.15));
					if (d.p.getInvenCurrentHealth() > d.p.getInvenMaxHealth()) {
						d.p.setInvenCurrentHealth(d.p.getInvenMaxHealth());
					}
					System.out.println("	값이 싼 만큼 찬 바람이 그대로 느껴지지만 지붕이 있다는 것에 만족하며 잠에 듭니다.");
					System.out.println("	체력이 미량 회복되었습니다.");
					System.out.println("	현재 체력 : " + d.p.getInvenCurrentHealth());

				} else {
					System.out.println("	system : 소지금이 부족합니다.");
					System.out.println("	여관 주인 : 돈이 없으면 나가서 주무세연.");
				}
				break;

			case 2:
				System.out.println("	저급 숙소를 선택하셨습니다. 50Gold를 지불합니다.");
				if (d.p.getGold() > 50) {
					d.p.setGold(d.p.getGold() - 50);
					System.out.println("	현재 소지금 : " + d.p.getGold());
					// d.p.setCurrentHealth(d.p.invenCurrentHealth + (int) (d.p.invenMaxHealth *
					// 1.25));

					d.p.setInvenCurrentHealth(d.p.getInvenCurrentHealth() + (int) (d.p.getInvenMaxHealth() * 0.25));

					if (d.p.getInvenCurrentHealth() > d.p.getInvenMaxHealth()) {
						d.p.setInvenCurrentHealth(d.p.getInvenMaxHealth());
					}
					System.out.println("	짚으로 만든 잠자리에 몸을 뉘우고 조각천을 대충 기워놓은 엉성한 이불을 덮고 잠에 듭니다.");
					System.out.println("	체력이 소량 회복되었습니다.");
					System.out.println("	현재 체력 : " + d.p.getInvenCurrentHealth());

				} else {
					System.out.println("	system : 소지금이 부족합니다.");
					System.out.println("	여관 주인 : 돈이 없으면 나가서 주무세연.");
				}
				break;

			case 3:
				System.out.println("	보통 숙소를 선택하셨습니다. 100Gold를 지불합니다.");
				if (d.p.getGold() > 100) {
					d.p.setGold(d.p.getGold() - 100);
					System.out.println("현재 소지금 : " + d.p.getGold());
					// d.p.setCurrentHealth(d.p.invenCurrentHealth + (int) (d.p.invenMaxHealth *
					// 1.45));

					d.p.setInvenCurrentHealth(d.p.getInvenCurrentHealth() + (int) (d.p.getInvenMaxHealth() * 0.45));

					if (d.p.getInvenCurrentHealth() > d.p.getInvenMaxHealth()) {
						d.p.setInvenCurrentHealth(d.p.getInvenMaxHealth());
					}
					System.out.println("	적당히 푹신한 침대와 적당히 따뜻한 이불을 덮고 잠에 듭니다.");
					System.out.println("	체력이 회복되었습니다.");
					System.out.println("	현재 체력 : " + d.p.getInvenCurrentHealth());
				} else {
					System.out.println("	system : 소지금이 부족합니다.");
					System.out.println("	여관 주인 : 돈이 없으면 나가서 주무세연.");
				}

				break;

			case 4:
				System.out.println("	고급 숙소를 선택하셨습니다. 150Gold를 지불합니다.");
				if (d.p.getGold() > 150) {
					d.p.setGold(d.p.getGold() - 150);
					System.out.println("현재 소지금 : " + d.p.getGold());
					// d.p.setCurrentHealth(d.p.invenCurrentHealth + (int) (d.p.invenMaxHealth *
					// 1.65));
					d.p.setInvenCurrentHealth(d.p.getInvenCurrentHealth() + (int) (d.p.getInvenMaxHealth() * 0.65));

					if (d.p.getInvenCurrentHealth() > d.p.getInvenMaxHealth()) {
						d.p.setInvenCurrentHealth(d.p.getInvenMaxHealth());
					}
					System.out.println("	꽤 푹신한 침대와 이불이 반겨줍니다. 오랜만에 편안한 잠자리에 들 수 있을 것 같습니다.");
					System.out.println("	체력이 대량 회복되었습니다.");
					System.out.println("	현재 체력 : " + d.p.getInvenCurrentHealth());
				} else {
					System.out.println("	system : 소지금이 부족합니다.");
					System.out.println("	여관 주인 : 돈이 없으면 나가서 주무세연.");
				}
				break;

			case 5:
				System.out.println("	F.L.E.X. 를 선택하셨습니다. 250Gold를 지불합니다.");
				if (d.p.getGold() > 250) {
					d.p.setGold(d.p.getGold() - 250);
					System.out.println("	현재 소지금 : " + d.p.getGold());
					// d.p.setCurrentHealth(d.p.getMaxHealth());

					d.p.setInvenCurrentHealth(d.p.getInvenMaxHealth());

					System.out.println("	돈이 남아 돕니까 휴먼?");
					System.out.println("	체력이 전부 회복되었습니다.");
					System.out.println("	현재 체력 : " + d.p.getInvenCurrentHealth());
				} else {
					System.out.println("	system : 소지금이 부족합니다.");
					System.out.println("	여관 주인 : 돈이 없으면 나가서 주무세연.");
				}
				break;

			case 6:
				System.out.println("	여관 밖으로 나갑니다.");
				return;

			}

		}

	}

}
