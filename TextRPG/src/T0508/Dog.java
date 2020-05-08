package T0508;
//1-4
import T0508.BasicInfo;
import T0508.Monster;
//import items.*;

public class Dog extends Monster {//should be resistant to physical attacks!

	public Dog() {

    	setStage(4);
        setName("개");
        setBaseHealth(getStage());
        setBaseStrength(EnemyBasics.BASE_STRENGTH);
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(2); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

        
    }
    
}
