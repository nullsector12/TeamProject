package game;
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
	
//던전을 불러온다.
	
//체력을 비교하여 턴체크를 한다.
//	public boolean moveFirst() {
//		return p.getCurrentHealth() > m.getCurrentHealth();
//	}
//	public void TurnCheck(Player p, Monster m) {
//		//턴을 정해주는 변수
//		turns =1;
//		
//		//몬스터와 플레이어의 체력을 비교하여 누가 먼저할지 결정
//		if(moveFirst()) {
//			PlayerTurn();
//		}else {
//			MonsterTurn();
//			turns = 2;
//		}
//	}
//	
//	
//공격을 정의한다.
	void playerAttack(Monster m, int dmg) {//파워가 없어 힐쓰로 대체
		dmg =((int)(Math.random()*10)+5);
       //pdmg = m.getCurrentHealth() - dmg;
       // m.getCurrentHealth(m.getCurrentHealth() - pdmg);
        System.out.println(dmg + " 만큼 가격! 몬스터의 체력은:" + (m.getCurrentHealth() - dmg));
       
    }
	
	void monsterAttack(Player p, int dmg) {
		dmg =((int)(Math.random()*10)+5);
   // mdmg = p.getCurrentHealth() - dmg;
   // Player.CurrentHealth(p.getCurrentHealth() - mdmg);
   // System.out.println(dmg + " 만큼 가격! " +p.getName()+"님의 체력은:" + (100 - dmg));
	    System.out.println(dmg + " 만큼 가격!"+p.getName()+" 플레이어님의 체력은:" + (p.getCurrentHealth() - dmg));

		pass = true;
	
	}
//서로 턴을 주고 받는다.
	void PlayerTurn(Player p, Monster m) { 
    
		//플레이어턴
//		System.out.println(p.getName() + " - " + "HP: " + p.getCurrentHealth() + "/" + p.getMaxHealth());
//        System.out.println(m.getName() + " - " + "HP: " + m.getCurrentHealth());
	}
	
	void MonsterTurn() {
		
//        //몬스터턴
//        System.out.println(m.getName() + "의 공격!!!");
//        //monster.getSkills(); blah stuff
//        System.out.println("화가난" + m.getName() + "!!!!");
        
	}
      
//회피를 정의 한다.???근데.... 몬스터가 먼저때리고 그데미지에서 빼서 회피하는게 맞죠??
	void playerWeakness(Monster m, int wns) {
		wns = (int) (mdmg-(Math.random()*m.getCurrentHealth()));
		//p.getCurrentHealth() = (p.getCurrentHealth() - wns);  
        System.out.println(wns + " 만큼 회피!:" + (p.getCurrentHealth()-wns));
     
	}


//사용자의 입력에 따른 공격
	void choicePlayerMovement(Monster m, Player p) {
		
		
		System.out.println("Battle Start!!!");
		System.out.println("1.공격 2.회피");
		int choice = Integer.parseInt(bt.nextLine());
		
		switch(choice) {
		case 1:
			//PlayerTurn(p,m);
			playerAttack(m, dmg);
			//MonsterTurn();
			monsterAttack(p, dmg);
			break;
		case 2:
			//PlayerTurn(p,m);
			playerAttack(m, pdmg);
			playerWeakness(m, mdmg);
			break;
		}
		  if(p.getCurrentHealth()<=0) {
	        	System.out.println("죽었습니다.");
	        	p.showStatus();
	        
	        }else if(m.getCurrentHealth()<=0) {
	        	System.out.println("승리하셨습니다.");
	        	//리워드호출
	        
	        }
}
}