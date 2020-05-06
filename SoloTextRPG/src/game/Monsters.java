package game;

public class Monsters {
	
	public String monsterName;
	int currentHealth, maxHealth; // 현재체력 최대체력
	int attackPower; // 공격력
	int goldWorth; // 소유 골드
	int expWorth; // 현재경험치 최대경험치
	int evasion; // 회피율
	int level; // 현재 레벨
	int weakness; // 몬스터의 강함수치

	public String rat(String monsterName){
		monsterName = "쥐쉑";
		this.monsterName = monsterName;
		level = 1;
		maxHealth = 120;
		currentHealth = maxHealth;
		attackPower = 20;
		goldWorth = 5;
		expWorth = 25;
		evasion = 0;
		weakness = 1;
		return monsterName;
		
	}
	
	public void showMonsterInfo() {
		System.out.println("몬스터 이름 : " + rat(monsterName));
		System.out.println("레벨 : " + level);
		System.out.println("체력 :" + currentHealth +"/" + maxHealth);
		System.out.println("공격력 : " + attackPower);
		System.out.println("회피율 : " + evasion);
		System.out.println("============================");

	}

}
