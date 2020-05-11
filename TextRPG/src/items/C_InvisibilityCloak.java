package items;

public class C_InvisibilityCloak extends Item {

	public C_InvisibilityCloak(String equipmentName, int equipmentType, int attackPower, int health, int evasion,
			int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "지휘관의 견장";

		this.equipmentType = 3;

		this.attackPower = 100;

		this.health = 500;

		this.evasion = 4;

		this.gold = 2000;

	}

	@Override
	public String toString() {
		return "	지휘관의 견장 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
