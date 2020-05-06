package game;

import java.util.Scanner;

public class TestManager {
	
	Scanner input = new Scanner(System.in);
	Player hero = new Player();
	Monsters enemy = new Monsters();
	Dungeon cave = new Dungeon();
	
	
	void createPlayer() {
		System.out.println("플레이어 이름 입력 :");
		hero.playerName = input.nextLine();
		hero.showPlayerInfo();
		System.out.println();
	}

	void createMonster() {
		System.out.println("야생의 " + enemy.rat(null) + "이(가) 나타났다!");
		enemy.showMonsterInfo();
		System.out.println();
	}
	
	void printCave() {
		System.out.println(cave.cave1(null));
	}
	
	void levelUp() {
		hero.canLevelUp();

	}
	
	
}
