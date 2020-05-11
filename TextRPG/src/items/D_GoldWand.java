package items;

public class D_GoldWand extends Item {

	public D_GoldWand(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "브로드 소드";

		this.equipmentType = 4;

		this.attackPower = 100;

		this.health = 50;

		this.evasion = 1;

		this.gold = 1000;

	}

	@Override
	public String toString() {
		return "	브로드 소드 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
