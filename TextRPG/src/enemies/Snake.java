package enemies;
//2-4
import TeamGameProject.Monster;

//import items.*;

public class Snake extends Monster {//should be resistant to physical attacks!

    public Snake() {

    	setStage(8);
        setName("뱀");
        setBaseHealth(getStage()+50);
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(17); //See Monster class for list of types
        
        setEvasion(25);//이건 그냥 랜덤 확률
        initCurrentStats();

    }
    
}