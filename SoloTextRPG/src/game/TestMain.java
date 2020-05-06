package game;


public class TestMain {
	
	public static void main(String[] args) {
		
		TestManager game = new TestManager();
		
		game.createPlayer();
		game.createMonster();
		game.printCave();
		game.levelUp();
	}


}
