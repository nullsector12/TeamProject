package skills;

public class Bash extends Skill {

	public Bash(String skillName, int numOfChance, int multiple, int gold) {

		super(skillName, numOfChance, multiple, gold);

		this.skillName = "배쉬";

		this.numOfChance = 3;

		this.multiple = 2;

		this.gold = 5000;

	}

	@Override
	public String toString() {
		return "	[" + skillName + " / 횟수 : " + numOfChance + " / 배수 : " + multiple + " / 가격 : " + gold + "]";
	}

}
