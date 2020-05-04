package game;

public class TempMain {

	public static void main(String[] args) {
		Monster m=new Monster();
//		Monster m=Monster.getInstance();
		m=m.makeMonster(1);
//		System.out.println(m);
		System.out.println(m.getBaseHealth());
		System.out.println(m.getBaseStrength());
		System.out.println("----------------------------------");
		m.showData();
		m.encounterMonster();
		
		m=m.makeMonster(2);
//		System.out.println(m);
		System.out.println(m.getBaseHealth());
		System.out.println(m.getBaseStrength());
		System.out.println("----------------------------------");
		m.showData();
		m.encounterMonster();
		
		
		Player p=new Player();
		System.out.println(p);
		
		m=m.makeMonster(3);
		m.showData();
		m.encounterMonster();
		m.attack(p, 20);
		System.out.println("----------------------------------");
		System.out.println(p);
		
	}

}
