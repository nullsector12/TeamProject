package enemies;
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
import game.Monster;
import game.BasicInfo;

public class Rat extends Monster {//should be resistant to physical attacks!

    public Rat() {
    	super.setStage(1);//stage 1
        super.setName("쥐");
       super.setBaseHealth(getStage());
        super.setBaseStrength(5);
        super.setGoldWorth(300);
        super.setExpWorth(25);
        super.setWeakness(2); //See Monster class for list of types
        
        super.initCurrentStats();
        
    }

    public void showData() {
    	super.showData();
    	System.out.println("쥐 선택");
    }
}