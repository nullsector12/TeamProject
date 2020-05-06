package enemies;
//2-3
import game.Monster;

public class Pig extends Monster {//should be resistant to physical attacks!

    public Pig() {
    	super.setStage(7);
        super.setName("돼지");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}