package items;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

	ArrayList<Item> item = new ArrayList<Item>(30);
	
	
	
	public void addEquipment (Item info) {
		
		item.add(info);
		
		
	}

	
	
	//Iterator<Item> list = item.iterator();
	
	
	
	public void showInventory() {
		while(true) {
			System.out.println(item.get(0).toString());
			break;
		}

	}
	
	
	
	
	
	
	

}
