package enemies;
//2-2
import game.Monster;

public class Sheep extends Monster {//should be resistant to physical attacks!

    public Sheep() {
    	super.setStage(6);
        super.setName("양");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}