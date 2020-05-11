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
	void playerUseSkills(Player p, Monster m, Skill s) throws InterruptedException {

		damage = (p.invenCurrentStrength) * 3 * s.multiple;

		if (monsterEvasion(m)) {
			Thread.sleep(500);
			System.out.println("	몬스터가 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			damage = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - damage);
		Thread.sleep(500);
		System.out.println("	플레이어의 " + s.skillName + " 사용 >>");
		System.out.println("	┌──────────────────────────────────────────────┐");
		System.out.println("	>" + p.getName() + " 님이	\n" + "	>" + m.getName() + " 에게 " + damage
				+ "의 데미지를 줬습니다! 몬스터의 체력은:" + (m.getCurrentHealth()));
		System.out.println("	└──────────────────────────────────────────────┘");
	}

	// 공격을 정의한다.
	void playerAttack(Player p, Monster m) throws InterruptedException {

		damage = (p.invenCurrentStrength) * 3;
		System.out.println("	플레이어의 턴 >>");

		if (monsterEvasion(m)) {
			Thread.sleep(500);
			System.out.println("	" + m.getName() + " 이(가) 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			damage = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - damage);
		Thread.sleep(500);
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
	void playerDefense(Player p, Monster m) throws InterruptedException {

		System.out.println("	플레이어의 턴 >>");
		monsterDamage = m.getCurrentStrength();
		playerDefense = (int) ((Math.random() * m.getCurrentStrength()) + p.getCurrentLevel());
		depenseDmg = monsterDamage - playerDefense;
		p.invenCurrentHealth = p.invenCurrentHealth - depenseDmg;
		Thread.sleep(500);
		System.out.println(
				"	몬스터의 공격을 " + playerDefense + " 만큼 방어합니다." + p.getName() + " 플레이어 체력 : " + p.invenCurrentHealth);
	}

	// 몬스터의 공격
	void monsterAttack(Player p, Monster m) throws InterruptedException {

		monsterDamage = m.getCurrentStrength();
		System.out.println("\n");
		System.out.println("	몬스터의 턴 >>");

		if (playerEvasion(p)) {
			Thread.sleep(500);
			System.out.println("	플레이어가" + m.getName() + "	의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			monsterDamage = 0;
		}

		p.invenCurrentHealth = p.invenCurrentHealth - monsterDamage;

		if (p.invenCurrentHealth < 0)
			p.invenCurrentHealth = 0;

//		p.setCurrentHealth(p.getCurrentHealth() - mdmg);
//		
//		System.out.println(p.getCurrentHealth());
		Thread.sleep(500);
		System.out.println("	┌──────────────────────────────────────────────┐");
		System.out.println("	>" + m.getName() + " 에게	\n" + "	>" + monsterDamage + "의 데미지를 받았습니다! 플레이어의 현재 체력 :"
				+ (p.invenCurrentHealth));
		System.out.println("	└──────────────────────────────────────────────┘");
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
	int choicePlayerMovement(Monster m, Player p) throws InterruptedException {
		int result = 0;
		this.battleResult = result;

		while (true) {
			Thread.sleep(500);
			System.out.println("");
			System.out.println("	┌───────────────────────┐");
			System.out.println("	│    행동을 선택해 주세요.	│");
			System.out.println("	└───────────────────────┘");
			System.out.println();
			System.out.println("	>1.공격		>5.플레이어 정보 출력	\n	>2.스킬 사용	>6.적 정보	\n	>3.방어하기	>7.마을로 귀환	\n	>4.포션 사용");
			int choice = Integer.parseInt(bt.nextLine());

			switch (choice) {
			case 1:

				playerAttack(p, m);
				Thread.sleep(500);
				// 만약 플레이어의 공격으로 몬스터가 죽었다면 몬스터는 공격하지 못하고 죽음
				if (!(m.getCurrentHealth() <= 0)) {
					monsterAttack(p, m);
				}
				if (p.invenCurrentHealth <= 0) {

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

				p.skillInven.showSkill();

				int skillSelect = 0;

				skillSelect = (bt.nextInt() - 1);
				bt.nextLine();

				if (p.skillInven.skill.get(skillSelect).numOfChance == 0) {
					System.out.println("	기회가 남아있지않습니다.");
					continue;
				}

				Skill s = p.skillInven.useSkill(p, skillSelect);

				playerUseSkills(p, m, s);
				// 만약 플레이어의 스킬로 몬스터가 죽었다면 몬스터는 공격하지 못하고 죽음
				if (!(m.getCurrentHealth() <= 0)) {
					monsterAttack(p, m);
				}

				if (p.invenCurrentHealth <= 0) {

					// 패배 시 result = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;
					break;

				} else {
					continue;
				}

			case 3:
				// 방어를 선택하면 나만 맞음!
				playerDefense(p, m);
				if (p.invenCurrentHealth <= 0) {

					// 방어 했는데도 패배 시 result = 1;
					result = 1;
					break;
				} else {
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

			case 5: // 플레이어 정보 확인
				p.showStatus();
				continue;
				
			case 6: // 몬스터 상태 확인
				m.showMonsterDetail();
				continue;
				
			case 7: // 도망
				result = 2;
				break;
			}

			return result;

		}
	}

}