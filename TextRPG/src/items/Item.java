package items;

public class Item {

	String equipmentName;
	int equipmentType; //1 - 보호대 2 - 투구 3 - 방패  4 - 지팡이
	int attackPower;
	int health;
	int evasion;
	int gold;
	
	public Item (String equipmentName,	int equipmentType, int attackPower, int health, int evasion, int gold ){
		
		
	}
	
	
	
	public Item ()	{
		
	}
	
	
	
	@Override
	public String toString() {
		return "BrokenSword [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	
	
	
}
