package enemies;

//1-2
import TeamGameProject.Monster;

//int STAGE = 1, BASE_HEALTH = 100, BASE_STRENGTH = 10, BESE_EVASION = 20,
//BASE_GOLD_WORTH=100,BASE_EXP_WORTH=20;
public class Chicken extends Monster {// should be resistant to physical attacks!

	public Chicken() {

		setStage(2);
		setName("닭");
		setBaseHealth(getStage()+2);
		setBaseStrength();
//      setExpWorth(EnemyBasics.BASE_EXP_WORTH);
		setExpWorth(getStage());// 메서드 인자 stage로 바꿈

		setGoldWorth(getExpWorth());
		setWeakness(4); // See Monster class for list of types

		setEvasion(3);// 이건 그냥 랜덤 확률
		initCurrentStats();
	}
//  public void showData() {
//  	super.showData();
//  	System.out.println("닭 선택");
//  }

}