package items;

public class D_DiamondWand extends Item {

	public D_DiamondWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "지휘관의 검";

		this.equipmentType = 4;

		this.attackPower = 300;

		this.health = 200;

		this.evasion = 2;

		this.gold = 3000;

	}

	@Override
	public String toString() {
		return "	지휘관의 검 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
