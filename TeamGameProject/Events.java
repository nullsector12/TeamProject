
package TeamGameProject;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Events {

	Scanner input = new Scanner(System.in);
	boolean result = false;

	void rewordsOfVictory(Player p, Monster m) {

		// 0 = 패배 시, 1 = 승리 시
		// 승리 시
		System.out.println();
		System.out.println("	┌+++++++++++++++++++++++++++++++++++++++++++++++┐");
		System.out.println("	        > 축하합니다." + m.getName() + "을(를) 물리쳤습니다!	  ");

		if (p.getCurrentLevel() > (m.getWeakness() + 3)) {
			System.out.println("		[주의] 현재 레벨에 비해 몬스터가 약합니다!");
			System.out.println("		약한 몬스터에게선 획득할 수 있는 보상이 줄어듭니다.");
			p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth() / 2));
			p.setGold(p.getGold() + (m.getGoldWorth() / 2));
			System.out.println();
			System.out.println(
					"		> " + (m.getGoldWorth() / 2) + " 골드와  경험치" + (m.getExpWorth() / 2) + " 을(를) 획득했습니다.");
			System.out.println("	└+++++++++++++++++++++++++++++++++++++++++++++++┘");
			p.checkLevelUp();
			p.showStatus();

		} else if (p.getCurrentLevel() > (m.getWeakness() + 4)) {
			System.out.println("		[주의] 현재 레벨에 비해 몬스터가 너무 약합니다!");
			System.out.println("		약한 몬스터에게선 획득할 수 있는 보상이 줄어듭니다.");
			p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth() / 3));
			p.setGold(p.getGold() + (m.getGoldWorth() / 3));
			System.out.println();
			System.out.println(
					"		> " + (m.getGoldWorth() / 3) + " 골드와 경험치" + (m.getExpWorth() / 3) + " 을(를) 획득했습니다.");
			System.out.println("	└+++++++++++++++++++++++++++++++++++++++++++++++┘");
			p.checkLevelUp();
			p.showStatus();

		} else if (p.getCurrentLevel() > (m.getWeakness() + 5)) {
			System.out.println("		[주의] 약한 몬스터 좀 그만 괴롭혀");
			System.out.println("		나쁜놈에게 줄 보상은 없다.");
			p.setCurrentExp(p.getCurrentExp() + 0);
			p.setGold(p.getGold() + 0);
			System.out.println();
			System.out.println("		> 경험치와 골드를 얻지 못했습니다.");
			System.out.println("	└+++++++++++++++++++++++++++++++++++++++++++++++┘");
			p.checkLevelUp();
			p.showStatus();

		} else {
			p.setGold(p.getGold() + m.getGoldWorth());
			p.setCurrentExp(p.getCurrentExp() + m.getExpWorth());
			System.out.println("		> " + m.getGoldWorth() + " 골드와 경험치" + m.getExpWorth() + " 을(를) 획득했습니다.");
			System.out.println("	└+++++++++++++++++++++++++++++++++++++++++++++++┘");
			p.checkLevelUp();
			p.showStatus();

		}

	}

	// 패배 시
	void penaltyOfDeath(Player p) {
		
		System.out.println("	┼===============================================┼");
		System.out.println("	    쓰러져있던 플레이어를 마을로 긴급 이송합니다. : 이송 비용 발생");
		System.out.println();

		// 패널티를 지불할 충분한 골드가 있을 시
//		if ((p.getGold() - (p.getCurrentLevel() * 100)) > 0) {
		p.setGold(p.getGold() - (p.getCurrentLevel() * 100));
		p.setInvenCurrentHealth(p.getInvenCurrentHealth() + (int) (p.getInvenMaxHealth() * 0.5));
		System.out.println("	┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("	>이송 비용으로 " + (p.getCurrentLevel() * 100) + " Gold가 청구됩니다.	┃");
		System.out.println("	>남은 골드 : " + p.getGold()+"			┃"); 
		System.out.println("	>최대 체력의 절반이 회복되었습니다.	┃");
		System.out.println("	┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		// 패널티를 지불할 충분한 골드가 없을 시
//		} else if ((p.getGold() - (p.getCurrentLevel() * 100)) < 0) {
//			System.out.println("이송 비용을 지불할 소지금이 부족합니다.");
//		}
//
	}

	// 계속 진행하시겠습니까?
	public boolean takeDie(Player p) {

		if (p.getInvenCurrentHealth() <= 0) {
			// 새로운 쓰레드
			Thread death = new Thread() {
				@Override
				public void run() {
					for (int i = 20; i > 0; i--) {
						System.out.println(i);

						// super.

						try {
							sleep(1000);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			death.start();
			// 예외처리
			int n;
			while (true) {
				String choice = JOptionPane.showInputDialog(
						"	플레이어가 사망했습니다. \n\n ((주의!)) 20초 안에 입력해주세요.(입력 없으면 자동 종료) \n 1. 긴급마을이송 : 비용 - lv * 100 gold \n 2.게임 종료");// 메인
																																	// 쓰레드

				try {
					n = Integer.parseInt(choice);
					if (!(n > 0 && n < 3)) {
						System.out.println("	정상적인 메뉴 선택이 아닙니다.\n메뉴를 다시 선택해주세요.");
						continue;
					}

				} catch (NumberFormatException e) {
					System.out.println("	잘못입력하셨습니다. 다시 선택해 주세요.");
					continue;
				} catch (InputMismatchException e) {
					System.out.println("	잘못입력하셨습니다. 다시 선택해 주세요.");
					continue;
				}
				break;
			}
			if (n == 1 || n == 2)
				death.stop();
			switch (n) {

			case 1:
				penaltyOfDeath(p);
				// true = 마을로 돌아가는 선택
				this.result = true;
				break;

			case 2:
				System.out.println("	프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("	20초동안 입력이 없어 종료합니다.");

				System.exit(0);
			}

			try {
				death.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		return result;
	}

}
