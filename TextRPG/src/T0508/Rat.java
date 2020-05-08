package T0508;
//1-1
//각 몬스터만의 고유 스킬이나 특화된 부분
//멤버변수/메서드로 추가
//showData 메서드 오버라이딩


//각 몬스터 별로 스테이지 값 저장

/*	int BASIC_HEALTH = 100;
	int BASIC_POWER = 15;
	int BASIC_GOLD = 100;
	int BASIC_EXP = 200;
	int BASIC_LEVEL = 1;*/
import T0508.BasicInfo;
import T0508.Monster;
//import items.*;

public class Rat extends Monster {//should be resistant to physical attacks!

	public Rat() {

    	setStage(EnemyBasics.STAGE);//stage 1
        setName("쥐");
       setBaseHealth(getStage());
        setBaseStrength(EnemyBasics.BASE_STRENGTH);
//        setExpWorth(EnemyBasics.BASE_EXP_WORTH);
        setExpWorth(getStage());//메서드 인자 stage로 바꿈

        setGoldWorth(getExpWorth());
        setWeakness(2); //See Monster class for list of types
        
        setEvasion(5);//이건 그냥 랜덤 확률
        initCurrentStats();

        
    }

    public void showData() {
    	super.showData();
    }
}