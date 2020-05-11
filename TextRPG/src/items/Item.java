package items;

public class Item {

	public String equipmentName;
	public int equipmentType; // 1 - 투구 2 - 갑옷 3 - 망토 4 - 지팡이
	public int attackPower;
	public int health;
	public int evasion;
	public int gold;

	public Item(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {

	}

	public Item() {

	}

	@Override
	public String toString() {
		return "Item [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

}
