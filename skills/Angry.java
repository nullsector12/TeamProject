package skills;

public class Angry extends Skill {

	public Angry(String skillName, int numOfChance, int multiple, int gold) {

		super(skillName, numOfChance, multiple, gold);

		this.skillName = "화내기";

		this.numOfChance = 3;

		this.multiple = 2;

		this.gold = 5000;

	}

	@Override
	public String toString() {
		return "Skill [" + skillName + ", 횟수=" + numOfChance + ", 배수=" + multiple + ", 가격=" + gold + "]";
	}

}
