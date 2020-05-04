package events;

public interface EventsInterface {
	
	int playerGetRewords(int addGold, int addExp);

	int playerGetPenalty(int lossGold);
	
	void createQuest();

	
}
