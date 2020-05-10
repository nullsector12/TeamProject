package enemies;
//2-2
import TeamGameProject.Monster;

//import items.*;

public class Sheep extends Monster {//should be resistant to physical attacks!

    public Sheep() {

    	setStage(6);
        setName("양");
        setBaseHealth(getStage()+42);
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(12); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

    }
    
}
