package player;

public class Player{
	int currentHealth;
	int dmg;
	
	public Player(){
		this.currentHealth = 100;
		this.dmg = 10;
	}
	
	public void showData() {
		System.out.println(currentHealth);
		System.out.println(dmg);
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


}