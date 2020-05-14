package inventory;

import TeamGameProject.Player;

public class Inventory {

	public void Inventory(Player p) {

		p.getInven().showInventory();
		System.out.println("=============================================");
		p.showPotion();
		p.getInven().showEquip();
		p.getInven().equipItem(p);

	}

}