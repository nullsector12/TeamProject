package monster;

public class Monster {
	int currentHealth;
	int dmg;
	
	public Monster(){
		this.currentHealth = 100;
		this.dmg = 10;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	void showData() {
		System.out.println(currentHealth);
		System.out.println(dmg);
	}
}
