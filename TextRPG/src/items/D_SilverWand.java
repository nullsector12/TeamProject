package items;

public class D_SilverWand extends Item {

	public D_SilverWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "수련용 철검";

		this.equipmentType = 4;

		this.attackPower = 50;

		this.health = 100;

		this.evasion = 1;

		this.gold = 300;

	}

	@Override
	public String toString() {
		return "	수련용 철검 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
