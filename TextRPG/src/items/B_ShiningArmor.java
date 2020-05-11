package items;

public class B_ShiningArmor extends Item {

	public B_ShiningArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "사슬 흉갑";

		this.equipmentType = 2;

		this.attackPower = 10;

		this.health = 300;

		this.evasion = 1;

		this.gold = 600;

	}

	@Override
	public String toString() {
		return "	사슬 흉갑 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
