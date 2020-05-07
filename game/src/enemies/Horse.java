package enemies;
//3-1
import game.Monster;

public class Horse extends Monster {//should be resistant to physical attacks!

    public Horse() {
    	setStage(9);
        setName("말");
        setBaseHealth(getStage());
        setBaseStrength(EnemyBasics.BASE_STRENGTH);
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(2); //See Monster class for list of types
        
        setEvasion();//이건 그냥 랜덤 확률

        initCurrentStats();
    }
    
}