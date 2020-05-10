package items;




public class D_GoldWand extends Item {

	public D_GoldWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "D_GoldWand";
		
		this.equipmentType =4;
		
		this.attackPower = 100;
				
		this.health = 50;
		
		this.evasion = 1;
		
		this.gold = 1000;
		
	}

	@Override
	public String toString() {
		return "D_GoldWand [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}
	
	
	
	

	
	

}
