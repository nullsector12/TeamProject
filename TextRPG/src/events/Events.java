package events;

public abstract class Events implements EventsInterface{

	int currentGold;
	int currentExp;
	int lossGold;
	
	@Override
	// 전투 결과에 따른 Gold와 Exp의 획득
	public int playerGetRewords(int addGold, int addExp) {

		if(battleResult == true) {
			Player.currentGold += Monster.setgoldWorth;
			Player.currentExp += Monster.setexpWorth;
			return currentGold = addGold;
			return currentExp = addExp; 
		}else {
			// 패널티를 정해야함
			playerGetPenalty();
		}	
	}// end of playerGetGold
	
	// 패배로 인한 골드의 감소
	@Override
	public void playerGetPenalty() {
		currentGold = (Player.currentGold) - (100*Player.currentLevel);
		
	}
	
}

	

