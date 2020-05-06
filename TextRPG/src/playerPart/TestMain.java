package playerPart;

import items.*;


public class TestMain {

	public static void main(String[] args) {

		
		Player player = new Player();
		
		player.addName();
		
		player.getExp(5000);
		
		player.checkLevelUp();
		
		player.showStatus();
		
		
		BrokenSword bs = new BrokenSword("", 0, 0, 0, 0, 0);
		
		
		
		
		
		Inventory iv = new Inventory();
		
		
		
		iv.addEquipment(bs);
			
		iv.showInventory();
		
		
		
		
	}

}
