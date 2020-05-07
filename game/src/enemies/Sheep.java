package enemies;
//2-2
import game.Monster;

public class Sheep extends Monster {//should be resistant to physical attacks!

    public Sheep() {
    	setStage(6);
        setName("양");
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