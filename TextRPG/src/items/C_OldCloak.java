package items;

public class C_OldCloak extends Item {

	public C_OldCloak(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "낡은 견장";

		this.equipmentType = 3;

		this.attackPower = 10;

		this.health = 200;

		this.evasion = 1;

		this.gold = 200;

	}

	@Override
	public String toString() {
		return "	낡은 견장 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
