package game;

public class TempMain {

	public static void main(String[] args) {
		Monster m = new Monster();
//		m.setCurrentHealth(100);
		m=m.makeMonster(3);
		m.showData();
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

		Battle b = new Battle();
		p.addName();
		System.out.println(p.getName());
		b.choicePlayerMovement(m,p);
	}

}
