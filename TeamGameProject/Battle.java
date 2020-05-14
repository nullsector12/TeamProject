package TeamGameProject;

import java.util.Scanner;

import skills.Skill;

import java.util.Random;

public class Battle {

	Scanner bt = new Scanner(System.in);
//플레이어 몬스터 모두 불러온다.

	int turns;
	boolean pass;
	int playerDamage;
	int monsterDamage;
	int weakness;
	int damage;
	Random rand = new Random();
	int battleResult;
	int depenseDmg;

	int playerDefense;

	// 스킬 정의
	void playerUseSkills(Player p, Monster m, Skill s) {

		damage = (p.getInvenCurrentStrength()) * 3 * s.multiple;

		if (monsterEvasion(m)) {
			System.out.println("몬스터가 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			damage = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - damage);
		System.out.println(damage + " 만큼 가격! 몬스터의 체력은:" + (m.getCurrentHealth()));
	}

	// 공격을 정의한다.
	void playerAttack(Player p, Monster m) {

		damage = (p.getInvenCurrentStrength()) * 3;

		if (monsterEvasion(m)) {
			System.out.println("	" + m.getName() + " 이(가) 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			damage = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - damage);
		System.out.println("	┌──────────────────────────────────────────────┐");
		System.out.println("	>" + p.getName() + " 님이	\n" + "	>" + m.getName() + " 에게 " + damage
				+ "의 데미지를 줬습니다! 몬스터의 체력은:" + (m.getCurrentHealth()));
		System.out.println("	└──────────────────────────────────────────────┘");
	}

	// 방어를 정의 한다.
	// mdmg =(int) ((((int)(Math.random()*Player.attackPower())+5)* 최대값 몬스터 공격력, 최소값
	// 플레이어레벨
	// Player.weakness)-m.attackPower());
	// mdmg - 몬스터가 때리는 데미지
	// pdf - 방어값
	// depenseDmg - 몬스터가 날때리는거에서 방어값을 빼서 내가 실제로 맞는값
	void playerDefense(Player p, Monster m) {

		monsterDamage = m.getCurrentStrength();
		playerDefense = (int) ((Math.random() * m.getCurrentStrength()) + p.getCurrentLevel());
		depenseDmg = monsterDamage - playerDefense;
		p.setInvenCurrentHealth(p.getInvenCurrentHealth() - depenseDmg);

		System.out.println("	"+depenseDmg + " 방어" + p.getName() + " 플레이어님의 체력은:" + p.getInvenCurrentHealth());
	}

	// 몬스터의 공격
	void monsterAttack(Player p, Monster m) {

		monsterDamage = m.getCurrentStrength();

		if (playerEvasion(p)) {
			System.out.println("	플레이어가" + m.getName() + "	의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			monsterDamage = 0;
		}
		p.setInvenCurrentHealth(p.getInvenCurrentHealth() - monsterDamage);

		if (p.getInvenCurrentHealth() < 0)
			p.setInvenCurrentHealth(0);

//		p.setCurrentHealth(p.getCurrentHealth() - mdmg);
//		
//		System.out.println(p.getCurrentHealth());
		System.out.println();
		System.out.println("	┌──────────────────────────────────────────────┐");
		System.out.println("	>" + m.getName() + " 에게	\n" + "	>" + monsterDamage + "의 데미지를 받았습니다! 플레이어의 현재 체력 :"
				+ (p.getInvenCurrentHealth()));
		System.out.println("	└──────────────────────────────────────────────┘");
	}

//회피를 정의 한다.	
	boolean playerEvasion(Player p) {

		if ((rand.nextInt(100) + 1) <= p.getInvenCurrentEvasion()) {
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

		while (true) {
			System.out.println("	┌───────────────────────┐");
			System.out.println("	|    행동을 선택해 주세요.	|");
			System.out.println("	└───────────────────────┘");
			System.out.println();
			System.out.println("	>1.공격		>3.방어	\n	>2.스킬 사용	>4.포션 사용	\n	>5. 도망가기(마을로)");
			int choice = Integer.parseInt(bt.nextLine());

			switch (choice) {
			case 1:

				playerAttack(p, m);
				monsterAttack(p, m);
				if (p.getInvenCurrentHealth() <= 0) {

					// 패배 시 result = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;
					break;

				} else {
					continue;
					// 추가 메뉴 반환값 구상해보기
				}

			case 2: // 스킬 사용

				System.out.println("	사용할 스킬을 골라주세요");

				p.getSkillInven().showSkill();

				int skillSelect = 0;

				skillSelect = (bt.nextInt() - 1);
				bt.nextLine();

				if (p.getSkillInven().skill.get(skillSelect).numOfChance == 0) {
					System.out.println("	기회가 남아있지않습니다.");
					continue;
				}

				Skill s = p.getSkillInven().useSkill(p, skillSelect);

				playerUseSkills(p, m, s);
				monsterAttack(p, m);

				if (p.getInvenCurrentHealth() <= 0) {

					// 패배 시 result = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;

					p.showStatus();
					break;

				} else {
					continue;
				}

			case 3:
				// 방어를 선택하면 나만 맞음!
				playerDefense(p, m);
				if (p.getInvenCurrentHealth() <= 0) {

					// 방어 했는데도 패배 시 result = 1;
					result = 1;
					break;
				}else {
					continue;
				}
				

			case 4:
				System.out.println("	┌───────────────────────┐");
				System.out.println("	|  사용할 포션을 선택해 주세요.	|");
				System.out.println("	└───────────────────────┘");

				p.showPotion();

				int potionSelect = bt.nextInt();

				bt.nextLine();

				if (potionSelect == 0) {
					continue;
				}

				p.usePotion(potionSelect);

				continue;
			case 5: // 도망
				result = 2;
				break;
			}

			return result;

		}
	}

}