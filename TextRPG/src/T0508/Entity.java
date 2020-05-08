package T0508;

public class Entity {//상속할 때 상위클래스에 private 처리하지 말 것
	 String name;
	 //멤버변수 추가===================================
	 int evasion;
	 int goldWorth;
	 int expWorth;
	 //==================================================
	 
	 int baseHealth, currentHealth, maxHealth;// 기본, 현재, 최대 체력
//	 int baseMana, currentMana, maxMana;// 기본, 현재, 최대 마나
	 int baseStrength, currentStrength;// 기본, 현재 힘
//	 int baseMagic, currentMagic;// 기본, 현재 마력
//	 int baseAgility, currentAgility;// 기본, 현재 민첩성
	 int baseDefense, currentDefense;// 기본, 현재 방어력
//	 int baseMagicDefense, currentMagicDefense;// 기본, 현재 마법 방어력
	int currentExp;
	int currentLevel;
	int gold;


	 
	 
	public String getName() {
		return name;	
	}// 이름 반환

	public int getEvasion() {
		return evasion;
	}

	public int setEvasion(int evasion) {
		return this.evasion = evasion;
	}

	public int getGoldWorth() {
		return goldWorth;
	}

	public void setGoldWorth(int goldWorth) {
		this.goldWorth = goldWorth;
	}

	public int getExpWorth() {
		return expWorth;
	}

	public void setExpWorth(int expWorth) {
		this.expWorth = expWorth;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	public int getCurrentDefense() {
		return currentDefense;
	}

	public void setCurrentDefense(int currentDefense) {
		this.currentDefense = currentDefense;
	}

	public void setName(String input) {
		name = input;
	}

	public int getCurrentHealth() {// 현재 체력 반환
		if (currentHealth < 0) {
			return 0;
		}
		return currentHealth;
	}

	public int setCurrentHealth(int input) {
		return currentHealth = input;
	}

	public int getBaseHealth() {
		return baseHealth;
	}

	public void setBaseHealth(int input) {
		baseHealth = input;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int input) {
		 maxHealth = input;
	}

	public int getCurrentStrength() {
		if (currentStrength < 0) {
			return 0;
		}
		return currentStrength;
	}

	public void setCurrentStrength(int input) {
		 currentStrength = input;
	}

	public int getBaseStrength() {
		return baseStrength;
	}

	public void setBaseStrength(int input) {
		baseStrength = input;
	}


	public void initCurrentStats() {// 현재 스탯 초기화
		currentHealth = baseHealth;
		currentStrength = baseStrength;
		currentDefense = baseDefense;
	}
}