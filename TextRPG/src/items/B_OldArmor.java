package items;




public class B_OldArmor extends Item {

	public B_OldArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "B_OldArmor";
		
		this.equipmentType =2;
		
		this.attackPower = 10;
				
		this.health = 200;
		
		this.evasion = 0;
		
		this.gold = 400;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "B_OldArmor [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
