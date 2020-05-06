package enemies;
//1-4
import game.Monster;

//import items.*;

public class Dog extends Monster {//should be resistant to physical attacks!

    public Dog() {
    	super.setStage(4);
        super.setName("개");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    
}