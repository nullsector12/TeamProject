package skills;

public class Skill {

	public String skillName;
	public int numOfChance;
	public int multiple;
	public int gold;

	public Skill(String skillName, int numOfChance, int multiple, int gold) {

		this.skillName = skillName;

		this.numOfChance = numOfChance;

		this.multiple = multiple;

		this.gold = gold;

	}

	@Override
	public String toString() {
		return "Skill ["+ skillName + ", 횟수=" + numOfChance + ", 배수=" + multiple + ", 가격="
				+ gold + "]";
	}

}
