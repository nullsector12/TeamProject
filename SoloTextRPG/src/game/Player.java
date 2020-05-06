package game;

public class Player {
	
	public String playerName;
	public int currentHealth, maxHealth; // 현재체력 최대체력
	public int attackPower; // 공격력
	public int gold; // 소유 골드
	public int currentExp, nextLevelExp; // 현재경험치 최대경험치
	public int evasion; // 회피율
	public int level; // 현재 레벨
	
	
	void player(String playerName){
		
		this.playerName = playerName;
		level = PlayerBasicStats.BASIC_LEVEL;
		maxHealth = PlayerBasicStats.BASIC_MAXHEALTH;
		currentHealth = maxHealth;
		attackPower = PlayerBasicStats.BASIC_ATTACKPOWER;
		gold = PlayerBasicStats.BASIC_GOLD;
		nextLevelExp = PlayerBasicStats.BASIC_MAXEXP;
		currentExp = 0;
		evasion = PlayerBasicStats.BASIC_EVASION;
		
	}

	
	void showPlayerInfo() {
		player(playerName);
		System.out.println("플레이어 이름 : " + playerName);
		System.out.println("레벨 : " + getLevel());
		System.out.println("체력 :" + currentHealth +"/" + maxHealth);
		System.out.println("공격력 : " + attackPower);
		System.out.println("회피율 : " + evasion);
		System.out.println("경험치 : " + currentExp + "/" + nextLevelExp);
		System.out.println("소유 골드 : " + gold +" Gold");
		System.out.println("============================");
	}
	
	
	void canLevelUp(){
		while(true)
		if(this.currentExp > this.nextLevelExp) {
			this.level += 1;
			maxHealth = (int)(maxHealth*1.1);
			attackPower = (int)(attackPower*1.2);
			nextLevelExp = (int)(nextLevelExp*1.2)+(getLevel()*10);
			System.out.println("레벨이 올랐습니다!");
			System.out.println("레벨 : " + level);
			System.out.println("최대 체력 : " + maxHealth);
			System.out.println("공격력 : " + attackPower);
			System.out.println("============================");
//			System.out.println("필요 경험치 : " + nextLevelExp);
		}else {
			break;
		}	
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}
	
	
//	public void acceptQuest(String monsterName, String stage, int numOfRequest) {
//		
//		
//	}


	
	
	
//	void LevelUp() {
//		level += 1;
//		maxHealth = (int)(maxHealth*1.2);
//		attackPower = (int)(attackPower*1.2);
//		evasion += 5;
//		nextLevelExp = (int)(nextLevelExp*1.2);
//		currentHealth = this.maxHealth;
//		
//	}
	
	
}
