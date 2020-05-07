//All living things in the game (The Player, NPCs, and monsters) inherit this class
//모든 살아있는 객체들이 상속하는 클래스
//하위 클래스들이 공통적으로 갖는 기본값들 초기화
package game;

public class Entity {//상속할 때 상위클래스에 private 처리하지 말 것
	 String name;
	 //멤버변수 추가===================================
	 int evasion;
	 int goldWorth;
	 int expWorth;
	 //==================================================
	 
	 int baseHealth, currentHealth, maxHealth;// 기본, 현재, 최대 체력
	 int baseStrength, currentStrength;// 기본, 현재 힘
	 
	public String getName() {
		return name;	
	}// 이름 반환

	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
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

	public void setName(String input) {
		name = input;
	}

	public int getCurrentHealth() {// 현재 체력 반환
		if (currentHealth < 0) {
			return 0;
		}
		return currentHealth;
	}

	public void setCurrentHealth(int input) {
		currentHealth = input;
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
	}
}