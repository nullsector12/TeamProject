package enemies;
//3-1
import game.Monster;

//import items.*;

public class Horse extends Monster {//should be resistant to physical attacks!

    public Horse() {
    	super.setStage(9);
        super.setName("말");
//        super.setBaseHealth(200);
        super.setBaseHealth(getStage());
//        super.setBaseMana(10);
        super.setBaseStrength(5);
//        super.setBaseMagic(2);
//        super.setBaseDefense(6);
//        super.setBaseMagicDefense(2);
        
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        super.setEscapable(true);
        
//        Item slimeE = new SlimeExtract();
//        super.getLoot().add(slimeE);
        
//        int[] chance = {80};//needs to map to same index
//        super.setLootChance(chance);
        
//        super.setRandomLoot();
        
        super.initCurrentStats();
    }
    
    /*public int slash() {
        return (int)(super.getBaseStrength() * 0.5) + 10;
    }*/
}