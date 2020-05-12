package items;

public class C_InvisibilityCloak extends Item {

	public C_InvisibilityCloak(String equipmentName, int equipmentType, int attackPower, int health, int evasion,
			int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "C_InvisibilityCloak";

		this.equipmentType = 3;

		this.attackPower = 100;

		this.health = 500;

		this.evasion = 4;

		this.gold = 2000;

	}

	@Override
	public String toString() {
		return "C_InvisibilityCloak [equipmentName=" + equipmentName + ", equipmentType=" + equipmentType
				+ ", attackPower=" + attackPower + ", health=" + health + ", evasion=" + evasion + ", gold=" + gold
				+ "]";
	}

}
