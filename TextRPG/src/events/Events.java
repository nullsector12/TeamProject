package events;

public abstract class Events implements EventsInterface{

	int currentGold;
	int currentExp;
	int lossGold;
	
	@Override
	// 전투 결과에 따른 
	public int playerGetRewords(int addGold, int addExp) {

		if(battleResult == true) {
			currentGold += monster.goldWorth;
			currentExp = monster.expWorth; 
			return addGold = currentGold;
			return addExp = currentExp; 
		}else {
			// 패널티를 정해야함
			
		}	
	}// end of playerGetGold
	
	@Override
	public int playerGetPenalty(int lossGold) {
		lossGold = (player.currentGold) - 100*player.currentLevel;
		return lossGold;
		
	}
	
}

	

