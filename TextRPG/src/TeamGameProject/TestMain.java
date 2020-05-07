package TeamGameProject;

import java.util.Random;

public class TestMain {
	Random rand = new Random();
	static int result;

	public static void main(String[] args) {

		Dungeon d = new Dungeon();
		
		System.out.println("----------------------------------");

		d.p.addName();
//		m.makeMonster((int)(Math.random()*13)+1);
		d.stage(d.p);
		
	}

}