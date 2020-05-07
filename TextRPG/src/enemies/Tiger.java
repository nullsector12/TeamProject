  
package enemies;
//3-3
import TeamGameProject.Monster;

//import items.*;

public class Tiger extends Monster {//should be resistant to physical attacks!

    public Tiger() {
    	setStage(11);
        setName("호랑이");
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