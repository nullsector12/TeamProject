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

		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("			JAVA 마을  상점가	<DA 2 SO>");
		Thread.sleep(500);
		System.out.println("\n\n");
		Thread.sleep(500);
		System.out.println("		   다양한 종류의 상점이 모여있는 상점가에 들어섭니다. ");

		while (true) {
			System.out.println("\n\n");
			Thread.sleep(500);
			System.out.println("		  	  어떤 상점을 이용 하시겠습니까?");
			System.out.println();
			Thread.sleep(500);
			System.out.println("	+=======================================================+");
			System.out.println("	│ 							│");
			System.out.println("	│		1. 포션 상점 < JapCho >			│");
			System.out.println("	│		2. 무구점 < JapTem >			│");
			System.out.println("	│		3. 기술 상점 < Skill of YaMe >		│");
			System.out.println("	│		4. 판매점 <JagMul>			│");
			System.out.println("	│		5. 마을로 돌아갑니다.			│");
			System.out.println("	│							│");
			System.out.println("	+=======================================================+");
			System.out.println("	소지금 : " + p.getGold() + " Gold");
			System.out.println("\n\n");

			int i = sc.nextInt();
			sc.nextLine();

			switch (i) {

			case 1:
				System.out.println("		  	                 포션 상점에 들어섭니다.");
				System.out.println();
				Thread.sleep(500);
				System.out.println("	+===============================================================+");
				System.out.println("	│ 								│");
				System.out.println("	│		1. 소형 체력 포션 : 회복량 30 / 가격 20 Gold		│");
				System.out.println("	│		2. 중형 체력 포션 : 회복량 60 / 가격 30 Gold		│");
				System.out.println("	│		3. 대형 체력 포션 : 회복량 150 / 가격 60 Gold		│");
				System.out.println("	│		4. 상점가로 돌아갑니다.				│");
				System.out.println("	│								│");
				System.out.println("	+===============================================================+");
				System.out.println("	소지금 : " + p.getGold() + " Gold");
				System.out.println("\n\n");

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
					System.out.println();
					System.out.println("	포션 상점을 나갑니다. 상점가로 돌아갑니다.");
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
				System.out.println("		  	                 무구점에 들어섭니다.");
				System.out.println();
				Thread.sleep(500);
				System.out.println("\n\n");
				System.out.println("	+===============================================================+");
				System.out.println("	│ 								│");
				System.out.println("	│1. A_Hat 공격력 : +10, 체력 : +50, 회피율 +0 (100G)			│");
				System.out.println("	│2. A_Headpiece 공격력 : +10, 체력 : +200, 회피율 +1, (200G)		│");
				System.out.println("	│3. B_OldArmor 공격력 : +10, 체력: +200, 회피율 +0 (400G)		│");
				System.out.println("	│4. B_ShiningArmor 공격력 : +10, 체력: +300, 회피율 +1 (600G)	│");
				System.out.println("	│5. B_DiamondArmor 공격력 : +10, 체력: +500, 회피율 +2 (1000G)	│");
				System.out.println("	│6. C_OldCloak 공격력 : +10, 체력: +200, 회피율 +1 (200G)		│");
				System.out.println("	│7. C_ShiningCloak 공격력 : +50, 체력: +200, 회피율 +1 (800G)	│");
				System.out.println("	│8. C_InvisibilityCloak 공격력 : +100, 체력: +500, 회피율 +4 (2000G) │");
				System.out.println("	│9. D_SilverWand 공격력 : +50, 체력: +100, 회피율 +1 (300G)		│");
				System.out.println("	│10. D_GoldWand 공격력 : +100, 체력: +100, 회피율 +1 (1000G)		│");
				System.out.println("	│11. D_DiamondWand 공격력 : +300, 체력: +200, 회피율 +2 (3000G)	│");
				System.out.println("	│0. 상점가로 돌아가기						│");
				System.out.println("	│ 								│");
				System.out.println("	+===============================================================+");
				System.out.println("	소지금 : " + p.getGold() + " Gold");
				System.out.println("\n\n");
				int select = sc.nextInt();
				sc.nextLine();

				if (select == 0) {
					System.out.println("	무구점을 나옵니다. 상점가로 돌아갑니다.");
					continue;
				}

				p.buyEquipment(select);
				break;

			case 3:

				System.out.println("		  	                 기술 상점에 들어섭니다.");
				System.out.println();
				Thread.sleep(500);
				System.out.println("	+=======================================================================+");
				System.out.println("	│ 									│");
				System.out.println("	│ 1. 배		쉬/ 사용 가능 횟수 : 3 / 효과 : 공격력*2데미지 / 5000Gold		│");
				System.out.println("	│ 2. 엣지 스트라이크/ 사용 가능 횟수 : 3 / 효과 : 공격력*3의 데미지 / 8000Gold		│");
				System.out.println("	│ 3. 브랜	디쉬/ 사용 가능 횟수 : 3 / 효과 : 공격력*4의 데미지 / 15000Gold	│");
				System.out.println("	│ 4. 상점가로 돌아갑니다.							│");
				System.out.println("	│									│");
				System.out.println("	+=======================================================================+");
				System.out.println("	소지금 : " + p.getGold() + " Gold");
				System.out.println("\n\n");

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
					System.out.println("	기술 상점을 나옵니다. 상점가로 돌아갑니다.");
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
				System.out.println("	상점가를 나섭니다. 마을로 돌아갑니다.");
				return;

			//
//		  break;

			}

		}
	}
}