package items;

public class B_DiamondArmor extends Item {

	public B_DiamondArmor(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "지휘관의 흉갑";

		this.equipmentType = 2;

		this.attackPower = 10;

		this.health = 500;

		this.evasion = 2;

		this.gold = 1000;

	}

	@Override
	public String toString() {
		return "	지휘관의 흉갑 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
