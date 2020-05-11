package skills;



public class TripleAngry extends Skill {

	

	public TripleAngry(String skillName, int numOfChance, int multiple, int gold){
		
		super(skillName, numOfChance, multiple, gold);
		
		this.skillName = "세배화내기";
		
		this.numOfChance = 3;
	
		this.multiple = 4;
		
		this.gold = 15000;
		
		
	}
	
	
	
	@Override
	public String toString() {
		return "Skill ["+ skillName + ", 횟수=" + numOfChance + ", 배수=" + multiple + ", 가격="
				+ gold + "]";
	}
	
	
	
	
	
	
	
}
