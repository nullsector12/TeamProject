package game;

import java.util.Random;

import enemies.Chicken;
import enemies.Cow;
import enemies.Dog;
import enemies.Dragon;
import enemies.EnemyBasics;
import enemies.Horse;
import enemies.Monkey;
import enemies.Pig;
import enemies.Rabbit;
import enemies.Rat;
import enemies.Sheep;
import enemies.Snake;
import enemies.Tiger;
public class Monster extends Entity {//이름 랜덤하게 나오도록
	
	// 회피 확률->공격 무효화 기능
//	private int evasion;
//	private int goldWorth;// 골드
//	private int expWorth;// 경험치
	// ==================================================05/07 추가 멤버변수
	int defense;

	// ==================================================
	private int weakness;// 몬스터가 가진 기본 약점
	private int stage;
	Random rand;

	protected Monster() {
		rand = new Random();

//		stage=1;
//		baseHealth=BasicInfo.BASIC_HEALTH;
//		baseStrength=BasicInfo.BASIC_POWER;
//		
//		goldWorth=BasicInfo.BASIC_GOLD;
//		expWorth=BasicInfo.BASIC_EXP;
//		weakness=0;
//		evasion=0;

		weakness = 0;
		// ==================================================05/07 추가 멤버변수 초기화
		defense = EnemyBasics.BASE_DEFENSE;
	}

//	Monster(){//얘는 몬스터별로 값이 다 다르기 때문에 필요없음
//		setCurrentHealth(BasicInfo.BASIC_HEALTH);
//	}
	// singleton
//	private Monster(int evasion, int goldWorth, int expWorth, int weakness) {
//		this.evasion = evasion;
//		this.goldWorth = goldWorth;
//		this.expWorth = expWorth;
//		this.weakness = weakness;
//	}
//
//	private static Monster monster = new Monster(evasion, goldWorth, expWorth, weakness);
//
//	public static Monster getInstance() {
//		return monster;
//	}
	public void setBaseHealth(int stage) {// 메서드 오버라이딩
		// 체력 증가 비율 설정해야 함
		super.setBaseHealth(EnemyBasics.BASE_HEALTH + stage * 10);// 스테이지별 몬스터마다 기본 체력 다름
//		System.out.println("기본 체력: "+super.getBaseHealth());
//		super.setBaseHealth(500);
	}

//	setBaseStrength(BasicInfo.BASIC_POWER+stage*10);
//	setExpWorth(BasicInfo.BASIC_EXP+stage*10);
//	setGoldWorth(getExpWorth());

	public void setBaseStrength() {
		baseStrength = EnemyBasics.BASE_STRENGTH + stage * 10;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	// evasion 계산식 정의해야 함
	public int getEvasion() {
		return evasion;
	}

	public void setEvasion() {// 이건 함수 인자나 고려할 다른 값 필요 없이 그냥 랜덤
		// 회피율 게임 턴마다 바뀌어야 함(고정값 x)
		evasion = (rand.nextInt(100) + 1);
	}

	public int getGoldWorth() {
		return goldWorth;
	}// 랜덤 십진수로 곱해지는 statement에서 일반적으로 호출됨 //usually called in a statement multiplied
		// by a random decimal

	public void setGoldWorth(int exp) {
		goldWorth = exp;
		// 스테이지 별 몬스터 경험치의 10퍼센트를 골드로 반환(최대 10퍼센트까지 골드 받을 수 있음) or 랜덤 반환
		int gold_max = (int) (exp * 0.5);
		int gold_min = (int) (exp * 0.1);// 최소 골드
		goldWorth = rand.nextInt(gold_max - gold_min + 1) + gold_min;// 수식 변경
//        int gMin = (int)(g*.7);
//        int gMax = (int)(g*1.2);
//        goldWorth = rand.nextInt(gMax - gMin +1) + gMin; //generates a number from g*.7 - g*1.2 (70% - 120% of g)
	}

//battle/ event에서 gold/exp 관련 정보 처리
	public int getExpWorth() {
		return expWorth;
	}

	public void setExpWorth(int stage) {

//		exp*=(stage*(rand.nextInt(2)+1));

		int exp_max = (int) (stage * 10);
		int exp_min = (int) (stage * 2);
		expWorth = stage * 10 + rand.nextInt(exp_max - exp_min + 1) + exp_min;
	}

	public int getWeakness() {
		return weakness;
	}

	public void setWeakness(int i) {//몬스터 회피
		i*=rand.nextInt(10)+1;
		weakness = i;
	}

	// manage클래스에서 상위 클래스 타입의 인스턴스를 생성해놓고
	// 스테이지별로 몬스터 생성
	// 하위 클래스 타입으로 각 객체들을 형변환해서 사용
	/*
	 * 1-1 1-2 1-3 1-4 rat chiken rabbit dog
	 * 
	 * 2-1 2-2 2-3 2-4 monkey sheep pig snake
	 * 
	 * 3-1 3-2 3-3 3-4 horse cow tiger dragon
	 */

	public Monster makeMonster(int stage) {// 스테이지 별 몬스터 생성
		Monster monster = null;
		
		@SuppressWarnings("unused")
		int numOfMonsters =rand.nextInt(5)+1;//스테이지마다 랜덤하게 나오는 몬스터 마리 수
		
		switch (stage) {//스테이지 별 같은 종류/다른 능력치  몬스터 여러마리 생성
		case Rounds.first:
			monster = new Rat();// 자동 형변환
			break;
		case Rounds.second:
			monster = new Chicken();
			break;
		case Rounds.third:
			monster = new Rabbit();
			break;
		case Rounds.forth:
			monster = new Dog();
			break;
		case Rounds.fifth:
			monster = new Monkey();
			break;
		case Rounds.sixth:
			monster = new Sheep();
			break;
		case Rounds.seventh:
			monster = new Pig();
			break;
		case Rounds.eighth:
			monster = new Snake();
			break;
		case Rounds.nineth:
			monster = new Horse();
			break;
		case Rounds.tenth:
			monster = new Cow();
			break;
		case Rounds.eleventh:
			monster = new Tiger();
			break;
		case Rounds.twelveth:
			monster = new Dragon();
			break;
		}
		return monster;
	}

	public void encounterMonster() {
		printName();
	}

	/*
	 * private int evasion;
	 * 
	 * private int goldWorth;// 골드 private int expWorth;// 경험치 private int
	 * weakness;// 몬스터가 가진 기본 약점 // 1 = physical, 2 = fire, 3 = water, 4 =
	 * lightning, 5 = ice, more?! private boolean escapable;// 탈출(도망) 가능 여부->도망 가능
	 * true/ 도망 불가 false
	 */

	public void showData() {
		System.out.println("현재 스테이지: " + this.getStage());// 1-1 형식으로 바꿔야됨
		System.out.println("몬스터 이름: " + this.getName());
		System.out.println("공격력 : " + this.getCurrentStrength());
		System.out.println("체력: " + this.getCurrentHealth());
		System.out.println("획득 가능 경험치: " + this.getExpWorth());
		System.out.println("획득 가능 골드: " + this.getGoldWorth());
		System.out.println("회피율: " + this.getEvasion() + "%");
//		System.out.println("방어력: " + this.getDefense());
		System.out.println("약점 : " + this.getWeakness());

	}

	@Override
	public String toString() {
		return "Monster [evasion=" + evasion + ", goldWorth=" + goldWorth + ", expWorth=" + expWorth + ", weakness="
				+ weakness + ", escapable=" + "]";
	}

	void printName() {
		System.out.println(getName() + "을(를) 만났습니다");
	}

	// ==========================================================05/07 추가 메서드
	boolean isAlive() {// 몬스터 살아있는지 여부 알려주는 메서드
		if (getCurrentHealth() <= 0)
			return false;
		else
			return true;
	}
	// ==========================================================05/08 추가 메서드====05/10 메서드 수정
	String title;
	public void setName(String name) {//이름 랜덤하게 나오도록
		String[] kinds= {"기본 ","날쏀 ","덩치가 큰 ","이빨이 날카로운 ","알 수 없는 "};//알 수 없는(랜덤)
		Random rand=new Random();
		int randIndex=rand.nextInt(5);
		
		this.name=kinds[randIndex]+name;
		title=kinds[randIndex];
		

		
	}

//	public int getDefense() {
//		return this.defense;
//	}
//
//	public void setDefense(int dmg) {// 플레이어(로부터 받는 공격양=받은 데미지) 메서드 인자로 받아야 함
////		if (defense >= p.getCurrentStrength())// 플레이어로부터 받은 데미지보다 방어력이 큰 경우
////			setCurrentHealth(getCurrentHealth());// 현재 체력 유지
////		else///플레이어로부터 받은 데미지가 방어력보다 큰 경우
////		if (defense < dmg)
////			if(getCurrentHealth()+defense<getCurrentHealth())
////				setCurrentHealth(getCurrentHealth() + defense -dmg);// 현재 체력+=(방어력-받은 데미지)
//		this.defense = rand.nextInt(20) + 1;
////		if (defense > dmg) {
////			defense -= dmg;
////			setCurrentHealth(getCurrentHealth() + defense);
////		} else {
////			defense = 0;
////			return;
////		}
//		// 기본적으로 방어력은 체력에 더해지는 값(체력 증가 효과) 거기에 데미지 빼서 체력값 재정의
//	}
//	public void setDefense(Player p) {// 플레이어(로부터 받는 공격양=받은 데미지) 메서드 인자로 받아야 함
////		if (defense >= p.getCurrentStrength())// 플레이어로부터 받은 데미지보다 방어력이 큰 경우
////			setCurrentHealth(getCurrentHealth());// 현재 체력 유지
////		else///플레이어로부터 받은 데미지가 방어력보다 큰 경우
//		if (defense < p.getCurrentStrength())
//			if(getCurrentHealth()+defense<getCurrentHealth())
//				setCurrentHealth(getCurrentHealth() + defense -p.getCurrentStrength());// 현재 체력+=(방어력-받은 데미지)
//		
//		// 기본적으로 방어력은 체력에 더해지는 값(체력 증가 효과) 거기에 데미지 빼서 체력값 재정의
//	}

//	public void  attack(Player player, int hit) {//Player에 가하는 공격의 양
//		System.out.println(getName()+"이(가) 공격합니다");
//		player.setCurrentHealth(player.getCurrentHealth()-hit);//공격받은 만큼 Player의 hp차감
//		if(player.getCurrentHealth()<0) {
//			System.out.println("끝");
//		}else {
//			
//		}
//	}
	/*
	 * abstract void printName() ;
	 */
	// public Skill[] getSkills(){return blahhh;}
}