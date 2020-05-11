package game;
import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

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
		dmg = p.getCurrentStrength() * 10;
dmg=1000;
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
		int count = 0;
		this.battleResult = result;

		System.out.println("====== 전투 시작 ======");
		while (true) {

			System.out.println("5초 안에 공격하세요");
			Thread t1 = new Thread() {
				@Override
				public void run() {
					for (int i = 5; i >= 0; i--) {
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
			t1.start();
			System.out.println("1.공격");
			int choice = Integer.parseInt(bt.nextLine());
			int cnt=0;
			switch (choice) {
			case 1:
				t1.stop();
				playerAttack(p, m);//입력 못하게 예외처리해야 함
				System.out.println("===== 몬스터 공격중=====");//입력 못하게 예외처리
//				while(true) {
//					
//				Thread t2 = new Thread() {
//					@Override
//					public void run() {
////						for (int i = 5; i >= 0; i--) {
//							System.out.print(".");
//							
//							// super.
//
//							try {
//								sleep(1000);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
////						}
//					}
//				};
//				cnt++;
//				t2.start();
//				if(cnt==5) {t2.stop();break;}
//				try {
//					t2.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				}
//				System.out.println();
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
			}
			try {
				t1.join();

			} catch (InterruptedException e) {

				// e.printStackTrace();
			}
			return result;

		}

	}
}