package enemies;
//2-1
import TeamGameProject.Monster;

//import items.*;

public class Monkey extends Monster {//should be resistant to physical attacks!

    public Monkey() {

    	setStage(5);
        setName("원숭이");
        setBaseHealth(getStage());
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(2); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

    }
    
}