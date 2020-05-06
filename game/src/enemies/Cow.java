package enemies;
//3-2
import game.Monster;

//import items.*;

public class Cow extends Monster {//should be resistant to physical attacks!

    public Cow() {
    	super.setStage(10);
        super.setName("소");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}