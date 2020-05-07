package game;

public class TempMain {

	public static void main(String[] args) {
		Monster m = new Monster();
//		m.setCurrentHealth(100);
//		m=m.makeMonster(1);//3라운드 몬스터
//		m.showData();
//		System.out.println("----------------------------------");
//		m=m.makeMonster(2);//3라운드 몬스터
//		m.showData();
//		System.out.println("----------------------------------");
//		m=m.makeMonster(12);//3라운드 몬스터
//		m.showData();
//		System.out.println("----------------------------------");
//		
//		
		for (int i = 1; i <=12; i++) {
			m=m.makeMonster(i);//3라운드 몬스터
			m.showData();
			System.out.println("----------------------------------");
		}
		
		
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
		Battle b = new Battle();
//		System.out.println(p.getName());
		b.choicePlayerMovement(m,p);
		
//		System.out.println("=============================");
//		m=m.makeMonster(1);//1라운드 몬스터
//		b.choicePlayerMovement(m, p);
	}

}
