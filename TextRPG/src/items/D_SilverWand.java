package items;




public class D_SilverWand extends Item {

	public D_SilverWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "D_SilverWand";
		
		this.equipmentType =4;
		
		this.attackPower = 50;
				
		this.health = 100;
		
		this.evasion = 1;
		
		this.gold = 300;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "D_SilverWand [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
