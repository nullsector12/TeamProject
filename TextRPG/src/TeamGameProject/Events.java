package TeamGameProject;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Events {

	Scanner input = new Scanner(System.in);
	boolean result = false;

	void rewordsOfVictory(Player p, Monster m) {

		// 0 = 패배 시, 1 = 승리 시
		// 승리 시

		System.out.println("축하합니다. 전투에서 승리하였습니다!");

		if (p.getCurrentLevel() > (m.getWeakness() + 3)) {
			System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
			p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth() / 2));
			p.setGold(p.getGold() + (m.getGoldWorth() / 2));
			System.out.println((m.getGoldWorth() / 2) + " 골드와  \n경험치" + (m.getExpWorth() / 2) + " 을(를) 획득했습니다.");
			p.checkLevelUp();

		} else if (p.getCurrentLevel() > (m.getWeakness() + 4)) {
			System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
			p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth() / 3));
			p.setGold(p.getGold() + (m.getGoldWorth() / 3));
			System.out.println((m.getGoldWorth() / 3) + " 골드와 \n경험치" + (m.getExpWorth() / 3) + " 을(를) 획득했습니다.");
			p.checkLevelUp();

		} else if (p.getCurrentLevel() > (m.getWeakness() + 5)) {
			System.out.println("약한 몬스터를 괴롭히지 맙시다.");
			p.setCurrentExp(p.getCurrentExp() + 0);
			p.setGold(p.getGold() + 0);
			System.out.println("경험치와 골드를 얻지 못했습니다.");
			p.checkLevelUp();

		} else {
			p.setGold(p.getGold() + m.getGoldWorth());
			p.setCurrentExp(p.getCurrentExp() + m.getExpWorth());
			System.out.println(m.getGoldWorth() + " 골드와 경험치" + m.getExpWorth() + " 을(를) 획득했습니다.");
			p.checkLevelUp();

		}

	}

	// 패배 시
	void penaltyOfDeath(Player p) {

		System.out.println("플레이어의 체력이 0이 되어 쓰러졌습니다.");
		System.out.println("쓰러져있던 플레이어를 마을로 이송합니다. : 이송 비용 발생");

		// 패널티를 지불할 충분한 골드가 있을 시
//		if ((p.getGold() - (p.getCurrentLevel() * 100)) > 0) {
		p.setGold(p.getGold() - (p.getCurrentLevel() * 100));
		p.setCurrentHealth(p.getMaxHealth());
		System.out.println("이송 비용으로 " + (p.getCurrentLevel() * 100) + " Gold가 청구됩니다.");
		System.out.println("남은 골드 : " + p.getGold());
		System.out.println("모든 체력이 회복되었습니다.");

		// 패널티를 지불할 충분한 골드가 없을 시
//		} else if ((p.getGold() - (p.getCurrentLevel() * 100)) < 0) {
//			System.out.println("이송 비용을 지불할 소지금이 부족합니다.");
//		}
//
	}

//계속 진행하시겠습니까?
	public boolean takeDie(Player p) {
		
		if (p.getCurrentHealth() <= 0) {
			// 새로운 쓰레드
			Thread death = new Thread() {
				@Override
				public void run() {
					for (int i = 10; i > 0; i--) {
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
			String choice = JOptionPane.showInputDialog(("1.마을로 돌아가기 2.게임 종료"));// 메인 쓰레드
			int n = Integer.parseInt(choice);
			if (n == 1 || n == 2)
				death.stop();
			switch (n) {

			case 1:
				penaltyOfDeath(p);
				// true = 마을로 돌아가는 선택
				result = true;
				break;

			case 2:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("10초동안 입력이 없어 종료합니다.");
				System.exit(0);
			}

			try {
				death.join();
			} catch (InterruptedException e) {

				// e.printStackTrace();
			} // stageChoice();

		}
		return result;
	}

}

// 패널티를 지불할 충분한 골드가 있을 시
//			if ((p.getGold() - (p.getCurrentLevel() * 100)) > 0) {
//				p.setGold(p.getGold() - (p.getCurrentLevel() * 100));
//				System.out.println("이송 비용으로 " + (p.getCurrentLevel() * 100) + " 이(가) 청구됩니다.");
//				System.out.println("남은 골드 : " + p.getGold());
//
//				// 패널티를 지불할 충분한 골드가 없을 시
//			} else if ((p.getGold() - (p.getCurrentLevel() * 100)) < 0) {
//				System.out.println("이송 비용을 지불할 소지금이 부족합니다.");
//			}
//
//		}
//
//	}
