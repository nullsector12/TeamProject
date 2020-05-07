package TeamGameProject;

import java.util.Random;

public class TempMain {
	Random rand = new Random();
	static int result;
	public static void main(String[] args) {
		
		Monster m = new Monster();
//		m.setCurrentHealth(100);
		m=m.makeMonster((int)(Math.random()*13)+1);//랜덤 라운드 몬스터
		m.showData();
		System.out.println("----------------------------------");
//		Monster m=Monster.getInstance();
//		m = m.makeMonster(1);
////		System.out.println(m);
//		System.out.println(m.getBaseHealth());
//		System.out.println(m.getBaseStrength());
//		System.out.println("----------------------------------");
//		m.showData();
//		m.encounterMonster();
//
//		m = m.makeMonster(2);
////		System.out.println(m);
//		System.out.println(m.getBaseHealth());
//		System.out.println(m.getBaseStrength());
//		System.out.println("----------------------------------");
//		m.showData();
//		m.encounterMonster();
//
		Player p = new Player();
		Battle b = new Battle();
		Events e = new Events();
//		p.setCurrentHealth(100);
//		System.out.println(p);
//
//		m = m.makeMonster(3);
//		m.showData();
//		m.encounterMonster();
//		m.attack(p, 20);
//		System.out.println("----------------------------------");
//		System.out.println(p);

		p.addName();
		while(true) {
//		System.out.println(p.getName());
			m=m.makeMonster((int)(Math.random()*13)+1);
			result = b.choicePlayerMovement(m, p);
			p.showStatus();
			e.rewordsOrPenalty(result);
			p.showStatus();
			
		}
		
		
//		System.out.println("=============================");
//		m=m.makeMonster(1);//1라운드 몬스터
//		b.choicePlayerMovement(m, p);
	}

}
