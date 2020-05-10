package items;




public class B_DiamondArmor extends Item {

	public B_DiamondArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "B_DiamondArmor";
		
		this.equipmentType =2;
		
		this.attackPower = 10;
				
		this.health = 500;
		
		this.evasion = 2;
		
		this.gold = 1000;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "B_DiamondArmor [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
