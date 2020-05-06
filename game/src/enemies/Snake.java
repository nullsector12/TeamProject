package enemies;
//2-4
import game.Monster;

public class Snake extends Monster {//should be resistant to physical attacks!

    public Snake() {
    	super.setStage(8);
        super.setName("뱀");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}