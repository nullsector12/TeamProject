package TeamGameProject;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Battle {

	Scanner bt = new Scanner(System.in);
//플레이어 몬스터 모두 불러온다.

	int turns;
	boolean pass;
	int mdmg;
	int wns;
	int dmg;
	Random rand = new Random();
	int battleResult;
	int pdf;

	private int depenseDmg;

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

	void monsterAttack(Player p, Monster m) {

		this.mdmg = m.getCurrentStrength();

		if (playerEvasion(p)) {
			System.out.println("플레이어가 몬스터의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			mdmg = 0;
		}

		p.invenCurrentHealth = p.invenCurrentHealth - mdmg;

		if (p.invenCurrentHealth < 0) {
			p.invenCurrentHealth = 0;
			System.out.println(mdmg + " 만큼 가격!   " + p.getName() + " 플레이어님의 체력은:" + p.invenCurrentHealth);
		}
		
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


//방어를 정의 한다.
	//mdmg =(int) ((((int)(Math.random()*Player.attackPower())+5)* 최대값 몬스터 공격력, 최소값 플레이어레벨
	//Player.weakness)-m.attackPower());
	//mdmg - 몬스터가 때리는 데미지
	//pdf - 방어값
	//depenseDmg - 몬스터가 날때리는거에서 방어값을 빼서 내가 실제로 맞는값
	void playerDefense(Player p, Monster m) {
		
		mdmg = m.getCurrentStrength();
		pdf=(int)((Math.random()*m.getCurrentStrength())+p.getCurrentLevel());
		depenseDmg = mdmg - pdf;
		p.invenCurrentHealth=p.invenCurrentHealth - depenseDmg;
		
		System.out.println(depenseDmg + " 만큼 가격!   " + p.getName() + " 플레이어님의 체력은:" + p.invenCurrentHealth);
	}

	
	//사용자의 입력에 따른 공격
	int choicePlayerMovement(Monster m, Player p) {
		int result = 0;
		this.battleResult = result;

		System.out.println("====== 전투 시작 ======");
		int choice;
		while (true) {
			
			try {
			System.out.println("1.공격 2.스킬 3. 방어 4.포션 5.도망");
			choice = Integer.parseInt(bt.nextLine());
			if(!(choice>0 && choice<5)) {
				System.out.println("정상적인 메뉴 선택이 아닙니다.\n 메뉴를 다시 선택해 주세요.");
			continue;
			}
			}catch (NumberFormatException e){
				System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
				continue;
			}catch (InputMismatchException e){
				System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
				continue;
			}break;
		}
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

				}
			
			case 3:
				playerAttack(p, m);//몬스터는 그대로 맞고
				playerDefense( p, m);//나만 들맞고
				if (p.invenCurrentHealth == 0) {

					// 패배 시 resul t = 1;
					result = 1;
					break;

				} else if (m.getCurrentHealth() <= 0) {

					// 승리 시 reuslt = 0;

					p.showStatus();
					break;

				} 
				

			case 4:
				System.out.println("사용할 포션을 골라주세요");
				if (p.potion.size() == 0) {
					p.potion.add(p.sp);
					p.potion.add(p.np);
					p.potion.add(p.bp);
				}
				
				int select;
				
				while(true) {
				p.showPotion();
				
					try {
						
						
						select = bt.nextInt();
						
					}catch (NumberFormatException e){
						System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
						continue;
					}catch (InputMismatchException e){
						System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
						continue;
					}finally{
						bt.nextLine();
					}
					
					if (select == 0) {//포션은 무조건 사야함. 0누르면 케이스 4로 돌아감.
						break;
						}
					
					
					
					
					
					
					p.usePotion(select);
					if (!(select > 0 && select < 2)) {
						System.out.println("잘못입력하셨습니다. 다시 선택해 주세요.");
						continue;
					}
				}
						
						
						
					
					
			}return result;//스위치초이스시작할때 반환값.
				}
				}
			
			
			
		


