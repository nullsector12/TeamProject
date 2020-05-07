package TeamGameProject;


import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;

public class Battle {
	
	Scanner bt = new Scanner(System.in);
//플레이어 몬스터 모두 불러온다.
	Player p = new Player();
	Monster m = new Monster();
	Dungeon d = new Dungeon();
	int turns;
	boolean pass;
	int pdmg;
	int mdmg;
	int wns;
	int dmg;
	Random rand = new Random();
	int battleResult;
	
	
//던전을 불러온다.
	
	//적중 확률 = ((정확도-회피 확률)/정확도) * 100 (%)
//공격을 정의한다.
	void playerAttack(Monster m, int dmg) {
		dmg = 1000;
		
		if(monsterEvasion(m)) {
			System.out.println("몬스터가 플레이어의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			dmg = 0;
		}
		m.setCurrentHealth(m.getCurrentHealth() - dmg);
        System.out.println(dmg + " 만큼 가격! 몬스터의 체력은:" + (m.getCurrentHealth()));
    }
	
	void monsterAttack(Player p, int mdmg) {
		mdmg =((int)(Math.random()*10)+5);
		
		if(playerEvasion()) {
			System.out.println("플레이어가 몬스터의 공격을 회피했습니다! 데미지가 0이 됩니다.");
			mdmg = 0;
		}
		p.setCurrentHealth(p.getCurrentHealth() - mdmg);
	    System.out.println(mdmg + " 만큼 가격!   "+p.getName()+" 플레이어님의 체력은:" + (p.getCurrentHealth()));
	}
	
//회피를 정의 한다.	
	 boolean playerEvasion() {
		 
            if ((rand.nextInt(100) + 1) <= p.getEvasion()) {
            	return pass = true;       
            }else {
            	return pass = false;
            }
	 }
	 
	 boolean monsterEvasion(Monster m) {
		 
         if ((rand.nextInt(100) + 1) <= m.getEvasion()) {
         	return pass = true;       
         }else {
         	return pass = false;
         }
	 }
  

//사용자의 입력에 따른 공격
	int choicePlayerMovement(Monster m, Player p) {
		int result = 0;
		this.battleResult = result;
		
		System.out.println("====== 전투 시작 ======");
		
		while(true) {
		System.out.println("1.공격");
		int choice = Integer.parseInt(bt.nextLine());
		
		switch(choice) {
		case 1:
			
			playerAttack(m, dmg);
			monsterAttack(p, dmg);
			  if(p.getCurrentHealth() <= 0) {
				  // 전투 패배 시 int 0 반환
		        	result = 0;
		        	break;
		        	
		        }else if(m.getCurrentHealth()<=0) {
		        	// 전투 승리 시 int 1 반환
		        	result = 1;
		        	break;
		        	
		        }else {
		        	continue;
		        	// 추가 메뉴 반환값 구상해보기
		        }
			
			// 전투 메뉴 추가 생각해보기
//		case 2:
//			
//			playerAttack(m, pdmg);
//			break;
		}return result;
		

//		  if(p.getCurrentHealth()<=0) {
//	        	System.out.println("죽었습니다.");
//	        	p.showStatus();
//	        	break;
//	        }else if(m.getCurrentHealth()<=0) {
//	        	System.out.println("승리하셨습니다.");
//	        	p.showStatus();
//	        	//리워드호출
//	        	break;
//	        }
		
		  }
	}
}

////회피를 정의 한다.
//void playerWeakness(Monster m, int wns) {
//	wns = (int) (mdmg-(Math.random()*m.getCurrentHealth()));
//	//p.getCurrentHealth() = (p.getCurrentHealth() - wns);  
//    System.out.println(wns + " 만큼 회피!:" + (p.getCurrentHealth()-wns));
// 
//}
//
//void monsterWeakness(Player p, int wns) {
//	wns = (int) (mdmg-(Math.random()*p.getCurrentHealth()));
//	//p.getCurrentHealth() = (p.getCurrentHealth() - wns);  
//    System.out.println(wns + " 만큼 회피!:" + (m.getCurrentHealth()-wns));
// 
//}

////서로 턴을 주고 받는다.
//void PlayerTurn(Player p, Monster m) { 
//
//	//플레이어턴
////	System.out.println(p.getName() + " - " + "HP: " + p.getCurrentHealth() + "/" + p.getMaxHealth());
////    System.out.println(m.getName() + " - " + "HP: " + m.getCurrentHealth());
//}
//
//void MonsterTurn() {
//	
////    //몬스터턴
////    System.out.println(m.getName() + "의 공격!!!");
////    //monster.getSkills(); blah stuff
////    System.out.println("화가난" + m.getName() + "!!!!");
//    
//}