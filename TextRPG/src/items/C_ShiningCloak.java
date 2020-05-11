package items;

public class C_ShiningCloak extends Item {

	public C_ShiningCloak(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "사슬 견장";

		this.equipmentType = 3;

		this.attackPower = 50;

		this.health = 200;

		this.evasion = 1;

		this.gold = 800;

	}

	@Override
	public String toString() {
		return "	사슬 견장 [추가 공격력 + " + attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold
				+ "]";
	}

}
