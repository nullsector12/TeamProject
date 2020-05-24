package potionStore;

public class Potion {

	public String pName;

	public int pAddHealth;

	public int pNum;

	public int price;

	public Potion(String pName, int pAddHealth, int pNum, int price) {

		this.pName = pName;
		this.pAddHealth = pAddHealth;
		this.pNum = pNum;
		this.price = price;

	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "[" + pName + ", 회복량 : " + pAddHealth + ", 개수 : " + pNum + "]";
=======
		return "	[" + pName + " / 회복량 : " + pAddHealth + " / 개수 : " + pNum + " / 가격 : " + price + "]";
>>>>>>> branch 'events' of https://github.com/nullsector12/TeamProject.git
	}

}
