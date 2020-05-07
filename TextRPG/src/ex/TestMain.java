package ex;

//import items.*;


public class TestMain {

	public static void main(String[] args) {
		Dungeon d = new Dungeon();
		
		Player p = new Player();
		
		Monster m = new Monster();
		p.addName();
		
		p.getExp(5000);
		
		p.checkLevelUp();
		
		p.showStatus();
		
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