package skills;

public class DoubleAngry extends Skill {

	public DoubleAngry(String skillName, int numOfChance, int multiple, int gold) {

		super(skillName, numOfChance, multiple, gold);

		this.skillName = "두배화내기";

		this.numOfChance = 3;

		this.multiple = 3;

		this.gold = 8000;

	}

	@Override
	public String toString() {
		return "Skill [" + skillName + ", 횟수=" + numOfChance + ", 배수=" + multiple + ", 가격=" + gold + "]";
	}

}
