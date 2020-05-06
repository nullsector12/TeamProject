package enemies;
import game.BasicInfo;
//1-2
import game.Monster;

public class Chicken extends Monster {//should be resistant to physical attacks!

    public Chicken() {
    	super.setStage(2);
        super.setName("닭");
        super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(30);
        super.setExpWorth(25);
        super.setWeakness(1); //See Monster class for list of types
        
        super.initCurrentStats();
    }
    public void showData() {
    	super.showData();
    	System.out.println("닭 선택");
    }
    
}