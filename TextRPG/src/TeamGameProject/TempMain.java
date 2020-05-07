package TeamGameProject;

import java.util.Random;

public class TempMain {
	Random rand = new Random();
	static int result;

	public static void main(String[] args) {
		Battle b = new Battle();
		Player p = new Player();
		Monster m = new Monster();

		m.makeMonster((int)(Math.random()*13)+1);//랜덤 라운드 몬스터
		m.showData();
		System.out.println("----------------------------------");

		p.addName();
		m.makeMonster((int)(Math.random()*13)+1);
		b.choicePlayerMovement(m, p);
		
	}

}
