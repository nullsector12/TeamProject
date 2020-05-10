package items;




public class C_ShiningCloak extends Item {

	public C_ShiningCloak(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "C_ShiningCloak";
		
		this.equipmentType =3;
		
		this.attackPower = 50;
				
		this.health = 200;
		
		this.evasion = 1;
		
		this.gold = 800;
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "C_ShiningCloak [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType + ", attackPower="
				+ attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold + "]";
	}

	

}
