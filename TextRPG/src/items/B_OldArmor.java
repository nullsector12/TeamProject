package items;

public class B_OldArmor extends Item {

	public B_OldArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "낡은 흉갑";

		this.equipmentType = 2;

		this.attackPower = 10;

		this.health = 200;

		this.evasion = 0;

		this.gold = 400;

	}

	@Override
	public String toString() {
		return "	낡은 흉갑 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
