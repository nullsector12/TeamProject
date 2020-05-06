package items;




public class B_DiamondArmor extends Item {

	public B_DiamondArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "BrokenSword";
		
		this.equipmentType =2;
		
		this.attackPower = 10;
				
		this.health = 50;
		
		this.evasion = 1;
		
		this.gold = 20;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "BrokenSword [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
