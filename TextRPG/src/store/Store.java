package store;

import java.util.InputMismatchException;
import java.util.Scanner;

import TeamGameProject.Player;
import items.Inven;
import potionStore.Potion;
import skills.Bash;
import skills.Skill;

public class Store {

	Scanner sc = new Scanner(System.in);
	int num;
	int select;
	Potion potion = new Potion(null, num, num, num);
	Skill skill = new Skill("", 0, 0, 0);

	public void store(Player p) throws InterruptedException {
		Thread.sleep(500);
		System.out.println("\n\n\n");
		System.out.println("				〈Da 2 So〉");
		System.out.println("		        어서오세요, 모험가님. Da 2 so에 오신걸 환영합니다.");

		while (true) {
			System.out.println("				어떤 상점을 이용하시겠습니까?");
			System.out.println();
			System.out.println("	┏=======================================================┓");
			System.out.println("	│							│");
			System.out.println("	│ 		1. 포션 상점을 이용하겠습니다.			│");
			System.out.println("	│		2. 쓸만한 장비를 사고 싶습니다.			│");
			System.out.println("	│		3. 스킬을 배우고 싶습니다.			│");
			System.out.println("	│		4. 필요없는 장비를 판매하고 싶습니다.		│");
			System.out.println("	│		5. 상점을 나갑니다.				│");
			System.out.println("	│							│");
			System.out.println("	┗=======================================================┛");

			int i = sc.nextInt();
			sc.nextLine();

			switch (i) {

			case 1:
				System.out.println("\n\n");
				System.out.println("	포션상점 Jap-Cho에 어서오세요.");
				System.out.println("	1. 소형 체력 포션 구매: 가격 20 Gold / 효과 : 체력 30 회복");
				System.out.println("	2. 중형 체력 포션 구매: 가격 30 Gold / 효과 : 체력 60 회복");
				System.out.println("	3. 대형 체력 포션 구매: 가격 60 Gold / 효과 : 체력 150 회복");
				System.out.println("	4. 상점 메뉴로 돌아가기");
				System.out.println("	소지금 :" + p.getGold());

				try {
					select = sc.nextInt();

				} catch (InputMismatchException e) {
					System.out.println("	잘못 누르셨습니다.");
					return;
				}

				catch (Exception e) {
					System.out.println("	잘못 누르셨습니다.");
					return;
				} finally {
					sc.nextLine();
				}

				if (select == 4) {
					System.out.println("	상점 메뉴로 돌아갑니다.");
					continue;
				}

				System.out.println("	구매할 포션의 개수를 입력해주세요");
				num = sc.nextInt();
				sc.nextLine();
				try {
					p.buyPotion(select, num);
				} catch (Exception e) {

					System.out.println("	잘못 누르셨습니다.");
					return;
				}

				break;

			case 2:
				System.out.println("\n\n");
				System.out.println("	무구점 Jang-Mul에 오신 걸 환영합니다!");
				System.out.println("	1.철	투구 : 공격력+10/체력+50 (100G)");
				System.out.println("	2.지휘관의	투구 : 공격력+10/체력+200/회피율 +1 (200G)");
				System.out.println("	3.낡은	흉갑 : 공격력+10/체력+200 (400G)");
				System.out.println("	4.사슬	흉갑 : 공격력+10/체력+300/회피율 +1 (600G)");
				System.out.println("	5.지휘관의	흉갑 : 공격력+10/체력+500/회피율 +2 (1000G)");
				System.out.println("	6.낡은	견장 : 공격력+10/체력/+200/회피율 +1 (200G)");
				System.out.println("	7.사슬	견장 : 공격력+50/체력+200/회피율 +1 (800G)");
				System.out.println("	8.지휘관의	견장 : 공격력+100/체력/+500/회피율 +4 (2000G)");
				System.out.println("	9.수련용	철검 : 공격력+50/체력/+100/회회피율 +1 (300G)");
				System.out.println("	10.브로드	소드 : 공격력+100/체력/+100/회피율 +1 (1000G)");
				System.out.println("	11.지휘관의  검: 공격력+300/체력/+200/회피율 +2 (3000G)");
				System.out.println("	0.마을로 돌아가기");
				System.out.println("	소지금 :" + p.getGold());

				int select = sc.nextInt();
				sc.nextLine();

				if (select == 0) {
					System.out.println("	상점 메뉴로 돌아갑니다.");
					continue;
				}

				p.buyEquipment(select);
				break;

			case 3:
				System.out.println("	어서오세요. 마법상점 Ya-Me 입니다.");
				System.out.println("	1. 스킬명 : 배	쉬	/ 사용 기회 : 3 / 피해량 : 공격력 * 2 (5000G)");
				System.out.println("	2. 스킬명 : 엣지 스트라이크	/ 사용 기회 : 3 / 피해량 : 공격력 * 3 (8000G)");
				System.out.println("	3. 스킬명 : 브   랜	디  쉬	/ 사용 기회 : 3 / 피해량 : 공격력 * 4 (15000G)");
				System.out.println("	4. 상점 메뉴로 돌아가기");
				System.out.println("	소지금 :" + p.getGold());

				select = 0;

				select = sc.nextInt();

				sc.nextLine();

				// 캐릭터에있는 인스턴스

				if (select == 1) {

					skill = p.Skill1;

				} else if (select == 2) {

					skill = p.Skill2;

				} else if (select == 3) {

					skill = p.Skill3;

				} else if (select == 4) {
					continue;
				}

				p.skillInven.buySkill(p, skill);
				p.skillInven.showSkill();
				break;

			case 4:

				p.inven.showInventory();
				p.sellItem();
				break;
			case 5:
				System.out.println("	상점을 나섭니다.");
				return;
			//
//		  break;

			}

		}
	}
}