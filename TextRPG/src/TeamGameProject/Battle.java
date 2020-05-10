package TeamGameProject;

import java.util.Scanner;
import java.util.Random;

public class Battle {

	Scanner bt = new Scanner(System.in);
//플레이어 몬스터 모두 불러온다.

	int turns;
	boolean pass;
	int pdmg;
	int mdmg;

	int dmg;
	boolean ranAway = false;
	Random rand = new Random();
	int battleResult;
	Player p;
	Monster m;
	Town t;

//던전을 불러온다.

	// 적중 확률 = ((정확도-회피 확률)/정확도) * 100 (%)
//공격을 정의한다.
	void playerAttack(Player p, Monster m) {
		// p.inven.cal
		dmg = p.getCurrentStrength() * 10;

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
		p.setCurrentHealth(p.getCurrentHealth() - mdmg);
		System.out.println(mdmg + " 만큼 가격!   " + p.getName() + " 플레이어님의 체력은:" + (p.getCurrentHealth()));
	}

//회피를 정의 한다.	
	boolean playerEvasion(Player p) {

		if ((rand.nextInt(100) + 1) <= p.getEvasion()) {
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
			System.out.println("1.공격 2.방어");
			int choice = Integer.parseInt(bt.nextLine());

			switch (choice) {
			case 1:

				playerAttack(p, m);
				monsterAttack(p, m);
				if (p.getCurrentHealth() <= 0) {

					// 패배 시 result = 1;
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
				if (runAway(p, m)) {
					result = 2;
					break;

				} else {
					
				}
				return result;
			}
		}

	}

//	//도망
//	
	boolean runAway(Player p, Monster m) {

		if (p.getEvasion() < m.getEvasion()) {// generates a number from 1-10 and checks if < 8 //should have it check
												// agility and stuff

			ranAway = true;
			System.out.println("Ran away safely!");

		} else {
			System.out.println("Failed to escape!");
			ranAway = false;
		}

		// pass = true;
		return ranAway;
	}

}
