package enemies;

//1-3
import TeamGameProject.Monster;

//import items.*;

public class Rabbit extends Monster {//should be resistant to physical attacks!

    public Rabbit() {

    	setStage(3);//stage 3
        setName("토끼");
        setBaseHealth(getStage()+4);
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(6); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

    }
    
}