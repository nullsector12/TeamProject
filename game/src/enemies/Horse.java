package enemies;
//3-1
import game.Monster;

public class Horse extends Monster {//should be resistant to physical attacks!

    public Horse() {
    	super.setStage(9);
        super.setName("말");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}