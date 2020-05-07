package dungeon;

import player.*;
import monster.*;
import java.util.Scanner;

public class Battle {
	
	Player p;
	Monster m;
	Scanner sc;
	
	
	int battle(Monster m, Player p){

		
		int result = 0;
		
		
		
		while(!(result<0)) {
			
			result = p.getCurrentHealth()-m.getDmg();
			p.setCurrentHealth(result);
			System.out.println(result);
		}
		return 1;
	}
}