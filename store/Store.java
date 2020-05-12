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

	public void store(Player p) {

		System.out.println("1.포션 2.장비 3.스킬 4.판매"); //
		System.out.println("===========================");
		System.out.println("현재 골드 :" + p.getGold());
		int i = sc.nextInt();
		sc.nextLine();

		switch (i) {

		case 1:
			System.out.println("1. 작은 포션 -회복량 :30 [20G]");
			System.out.println("2. 중간 포션 -회복량 :60 [30G]");
			System.out.println("3. 큰 포션 -회복량 :150 [60G]");
			System.out.println("0. 마을로 돌아가기");

			try {
				select = sc.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("잘못 누르셨습니다.");
				return;
			}

			catch (Exception e) {
				System.out.println("잘못 누르셨습니다.");
				return;
			} finally {
				sc.nextLine();
			}

			if (select == 0) {
				System.out.println("마을로 돌아갑니다.");
				return;
			}

			System.out.println("구매할 포션의 개수를 입력해주세요");
			num = sc.nextInt();
			sc.nextLine();
			try {
				p.buyPotion(select, num);
			} catch (Exception e) {

				System.out.println("잘못 누르셨습니다.");
				return;
			}

			break;

		case 2:

			System.out.println("1. A_Hat 공격력 : +10, 체력: +50, 회피율 +0 (100G)");
			System.out.println("2. A_HeadPiece 공격력 : +10, 체력: +200, 회피율 +1 (200G)");
			System.out.println("3. B_OldArmor 공격력 : +10, 체력: +200, 회피율 +0 (400G)");
			System.out.println("4. B_ShiningArmor 공격력 : +10, 체력: +300, 회피율 +1 (600G)");
			System.out.println("5. B_DiamondArmor 공격력 : +10, 체력: +500, 회피율 +2 (1000G)");
			System.out.println("6. C_OldCloak 공격력 : +10, 체력: +200, 회피율 +1 (200G)");
			System.out.println("7. C_ShiningCloak 공격력 : +50, 체력: +200, 회피율 +1 (800G)");
			System.out.println("8. C_InvisibilityCloak 공격력 : +100, 체력: +500, 회피율 +4 (2000G)");
			System.out.println("9. D_SilverWand 공격력 : +50, 체력: +100, 회피율 +1 (300G)");
			System.out.println("10. D_GoldWand 공격력 : +100, 체력: +100, 회피율 +1 (1000G)");
			System.out.println("11. D_DiamondWand 공격력 : +300, 체력: +200, 회피율 +2 (3000G)");
			System.out.println("0. 마을로 돌아가기");

			System.out.println("구매할 장비를 골라주세요");
			int select = sc.nextInt();
			sc.nextLine();

			if (select == 0) {
				System.out.println("마을로 돌아갑니다.");
				return;
			}

			p.buyEquipment(select);
			break;

		case 3:

			System.out.println("1. 배쉬  기회: 3, 배율 2 (5000G)");
			System.out.println("2. 엣지 스트라이크 기회: 3, 배율3 (8000G)");
			System.out.println("3. 브랜디쉬 기회: 3 , 배율4 (15000G)");

			System.out.println("구매할 스킬을 선택해주세요");

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

			}

			p.skillInven.buySkill(p, skill);

			p.skillInven.showSkill();

			break;
		case 4:

			p.inven.showInventory();
			p.sellItem();

			break;

		//
//		  break;

		}

	}

}