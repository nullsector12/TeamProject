package TeamGameProject;

import java.util.Random;

public class TempMain {
	Random rand = new Random();
	static int result;
	public static void main(String[] args) {
		
		Battle b = new Battle();
		Player p = new Player();
		Monster m = new Monster();
		
		//		m.setCurrentHealth(100);
		m.makeMonster((int)(Math.random()*13)+1);//랜덤 라운드 몬스터
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
		
//		System.out.println(p.getName());

			m.makeMonster((int)(Math.random()*13)+1);
			b.choicePlayerMovement(m, p);
		
//		System.out.println("=============================");
//		m=m.makeMonster(1);//1라운드 몬스터
//		b.choicePlayerMovement(m, p);
	}

}
