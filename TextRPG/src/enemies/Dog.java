package enemies;
//1-4
import TeamGameProject.*;

//import items.*;

public class Dog extends Monster {//should be resistant to physical attacks!

    public Dog() {

    	setStage(4);
        setName("개");
        setBaseHealth(getStage()+11);
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(9); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

        
    }
    
}