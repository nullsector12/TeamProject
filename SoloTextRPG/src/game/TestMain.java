package game;

import java.util.Scanner;

public class TestMain {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String choice;
		TestManager game = new TestManager();
		
		game.createPlayer();
		game.printCave();
		
		while(true) {
			System.out.println("행동을 결정해주세요. command : 전진 / 정보");
			choice = input.nextLine();
//			game.makeEvents();
			
			switch(choice) {
		
				case "전진" :
					game.battle();
					break;
					
				case "정보":
					game.showPlayerInfo();
					break;
			}
		}
	}	
}
