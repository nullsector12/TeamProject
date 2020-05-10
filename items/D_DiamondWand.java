package items;




public class D_DiamondWand extends Item {

	public D_DiamondWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "D_DiamondWand";
		
		this.equipmentType =4;
		
		this.attackPower = 300;
				
		this.health = 200;
		
		this.evasion = 2;
		
		this.gold = 3000;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "D_DiamondWand [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
