package game;

public class Dungeon {
	
	public String dungeonName;
	public String stage;
	public int stageNumber;
	
	
	public String cave1(String stage){
		dungeonName = "망겜던전";
		stageNumber = 1;
		stage = dungeonName + " - " + stageNumber;
		System.out.println("============================");
		return stage;
	}

	
	
}
