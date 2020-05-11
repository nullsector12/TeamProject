package items;

public class A_HeadPiece extends Item {

	public A_HeadPiece(String equipmentName, int equipmentType, int attackPower, int health, int evasion, int gold) {
		super(equipmentName, equipmentType, attackPower, health, evasion, gold);

		this.equipmentName = "지휘관의 투구";

		this.equipmentType = 1;

		this.attackPower = 10;

		this.health = 200;

		this.evasion = 1;

		this.gold = 200;

	}

	@Override
	public String toString() {
		return "	지휘관의 투구 [추가 공격력 + "+ attackPower + "/ 추가 체력 + " + health + "/ 추가 회피율 + " + evasion + "/ 가격 : " + gold + "]";
	}

}
