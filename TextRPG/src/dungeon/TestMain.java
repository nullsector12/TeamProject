package dungeon;

import monster.*;

import player.*;


//import items.*;


public class TestMain {

	public static void main(String[] args) {
		Dungeon d = new Dungeon();
		
		Player p = new Player();
		
		Monster m = new Monster();
		
		p.showData();
		
		d.stage(p);
		
		
//		A_Hat bs = new A_Hat("", 0, 0, 0, 0, 0);
//		
//		
//		
//		
//		
//		Inventory iv = new Inventory();
//		
//		
//		
//		iv.addEquipment(bs);
//			
//		iv.showInventory();
//		
//		
		
		
	}

}