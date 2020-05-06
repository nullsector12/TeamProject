package enemies;
//3-3
import game.Monster;

public class Tiger extends Monster {//should be resistant to physical attacks!

    public Tiger() {
    	super.setStage(11);
        super.setName("호랑이");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
}