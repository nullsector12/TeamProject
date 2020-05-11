package TeamGameProject;

import java.util.Random;
import java.util.Scanner;

import skills.Skill;

public class Battle {

	Scanner bt = new Scanner(System.in);
//플레이어 몬스터 모두 불러온다.

	int turns;
	boolean pass;
	int pdmg;
	int mdmg;
	int wns;
	int dmg;
	Random rand = new Random();
	int battleResult;

//던전을 불러온다.

	// 적중 확률 = ((정확도-회피 확률)/정확도) * 100 (%)
//공격을 정의한다.
	void playerAttack(Player p, Monster m) {

		dmg = (p.invenCurrentStrength) * 3;

		if (monsterEvasion(m)) {
			System.out.println("몬스터가 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			dmg = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - dmg);
		System.out.println(dmg + " 만큼 가격! 몬스터의 체력은:" + (m.getCurrentHealth()));
	}

	void playerAttackS(Player p, Monster m, Skill s) {

		dmg = (p.invenCurrentStrength) * 3 * s.multiple;

		if (monsterEvasion(m)) {
			System.out.println("몬스터가 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			dmg = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - dmg);
		System.out.println(dmg + " 만큼 가격! 몬스터의 체력은:" + (m.getCurrentHealth()));
	}

	void monsterAttack(Player p, Monster m) {

		mdmg = m.getCurrentStrength();

		if (playerEvasion(p)) {
			System.out.println("플레이어가 몬스터의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			mdmg = 0;
		}

		p.invenCurrentHealth = p.invenCurrentHealth - mdmg;

		if (p.invenCurrentHealth < 0)
			p.invenCurrentHealth = 0;

//		p.setCurrentHealth(p.getCurrentHealth() - mdmg);
//		
//		System.out.println(p.getCurrentHealth());

		System.out.println(mdmg + " 만큼 가격!   " + p.getName() + " 플레이어님의 체력은:" + p.invenCurrentHealth);

	}

//회피를 정의 한다.	
	boolean playerEvasion(Player p) {

		if ((rand.nextInt(100) + 1) <= p.invenCurrentEvasion) {
			return pass = true;
		} else {
			return pass = false;
		}
	}

	boolean monsterEvasion(Monster m) {

		if ((rand.nextInt(100)) <= m.getEvasion()) {
			return pass = true;
		} else {
			return pass = false;
		}
	}

//사용자의 입력에 따른 공격
	int choicePlayerMovement(Monster m, Player p) {
		int result = 0;
		this.battleResult = result;

		System.out.println("====== 전투 시작 ======");

		while (true) {
			System.out.println("1.공격 2.스킬 2. 3.스킬 5.");
			int choice = Integer.parseInt(bt.nextLine());

			switch (choice) {

			case 1:

				playerAttack(p, m);
				monsterAttack(p, m);
				if (p.invenCurrentHealth == 0) {

					// 패배 시 resul t = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;

					p.showStatus();
					break;

				} else {
					continue;
					// 추가 메뉴 반환값 구상해보기
				}

				// 전투 메뉴 추가 생각해보기
			case 2:
				result = 2;
				break;

			case 3:

				System.out.println("사용할 스킬을 골라주세요");

				p.skill.showSkill();

				int select = 0;

				select = (bt.nextInt() - 1);
				bt.nextLine();

				if (p.skill.skill.get(select).numOfChance == 0) {
					System.out.println("기회가 남아있지않습니다.");
					continue;
				}

				Skill s = p.skill.useSkill(p, select);

				playerAttackS(p, m, s);
				monsterAttack(p, m);

				if (p.invenCurrentHealth == 0) {

					// 패배 시 resul t = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;

					p.showStatus();
					break;

				} else {
					continue;
					// 추가 메뉴 반환값 구상해보기

				}

			case 4:
				System.out.println("사용할 포션을 선택해주세요");
				if (p.potion.size() == 0) {
					p.potion.add(p.sp);
					p.potion.add(p.np);
					p.potion.add(p.bp);
				}
				p.showPotion();
				int select2 = 0;

				try {
					select2 = bt.nextInt();

				} catch (NumberFormatException e) {
					System.out.println("잘못 누르셨습니다.");
					continue;
				} catch (Exception e) {
					System.out.println("잘못 누르셨습니다.");
					continue;
				} finally {
					bt.nextLine();
				}

				if (select2 == 0) {
					continue;
				}
				while(true) {
				try {
					p.usePotion(select2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("잘못누르셨습니다.");
					continue;
				}
				}
	

			}

			return result;

		}
	}

}
