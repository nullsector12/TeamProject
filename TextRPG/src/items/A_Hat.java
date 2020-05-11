package items;

public class A_Hat extends Item {

	public A_Hat(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "철 투구";

		this.equipmentType = 1;

		this.attackPower = 10;

		this.health = 50;

		this.evasion = 0;

		this.gold = 100;

	}

	@Override
	public String toString() {
		return "	철 투구 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
