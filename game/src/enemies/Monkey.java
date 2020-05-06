package enemies;
//2-1
import game.Monster;

public class Monkey extends Monster {//should be resistant to physical attacks!

    public Monkey() {
    	super.setStage(5);
        super.setName("원숭이");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}