package inventory;

import TeamGameProject.Player;

public class Inventory {

	
	
	public void Inventory(Player p) {
		
		p.inven.showInventory();
		System.out.println("=============================================");
		p.showPotion();
		p.inven.showEquip();
		p.inven.equipItem();
		
		
		
	}
	
	
	
	
	
	
	
}
