package enemies;
//3-4
import TeamGameProject.Monster;

//import items.*;

public class Dragon extends Monster {//should be resistant to physical attacks!

    public Dragon() {

    	setStage(12);
        setName("용");
        setBaseHealth(getStage()+380);
        setBaseStrength();
        setExpWorth(getStage());//메서드 인자 stage로 바꿈
        setGoldWorth(getExpWorth());
        setWeakness(30); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        
        initCurrentStats();

    }
    
}
