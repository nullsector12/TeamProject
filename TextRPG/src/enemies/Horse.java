package enemies;
//3-1
import TeamGameProject.Monster;

//import items.*;

public class Horse extends Monster {//should be resistant to physical attacks!

    public Horse() {

    	setStage(9);
        setName("말");
        setBaseHealth(getStage()+141);
        setBaseStrength();
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈(

        setGoldWorth(getExpWorth());
        setWeakness(2); //See Monster class for list of types
        
        // 주어진 int 값 없으면 Monster 클래스의 Evasion 사용 =  랜덤 확률
        // int 값 주어지면 Entity 클래스의 Evasion 사용 = 확률계산
        setEvasion(20);
        
        initCurrentStats();

    }
    
}