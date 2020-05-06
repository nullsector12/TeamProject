package enemies;
//3-4
import game.Monster;

public class Dragon extends Monster {//should be resistant to physical attacks!

    public Dragon() {
    	super.setStage(12);
        super.setName("용");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setWeakness(2); //See Monster class for list of types
        super.setEvasion(1000);
        
        super.initCurrentStats();
    }
    
}