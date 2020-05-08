package T0508;

import java.util.Random;

public class Monster extends Entity {

	// 회피 확률->공격 무효화 기능
//	private int evasion;
//	private int goldWorth;// 골드
//	private int expWorth;// 경험치
	// ==================================================05/07 추가 멤버변수
	int defense;

	// ==================================================
	private int weakness;// 몬스터가 가진 기본 약점
	// 1 = physical, 2 = fire, 3 = water, 4 = lightning, 5 = ice, more?!
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
		super.setBaseHealth(BasicInfo.BASIC_HEALTH + stage * 10);// 스테이지별 몬스터마다 기본 체력 다름
//		System.out.println("기본 체력: "+super.getBaseHealth());
//		super.setBaseHealth(500);
	}


	public void setBaseStrength(int stage) {
		baseStrength = BasicInfo.BASIC_POWER + stage * 10;
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

	public int setEvasion(int evasion) {// 이건 함수 인자나 고려할 다른 값 필요 없이 그냥 랜덤
		// 회피율 게임 턴마다 바뀌어야 함(고정값 x)
		 return this.evasion = evasion;
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

	public void setWeakness(int i) {
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
		switch (stage) {
		case Rounds.first:
			monster = new Rat();// 자동 형변환
			System.out.println(monster);
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


	public void showData() {
		System.out.println("현재 스테이지: " + this.getStage());// 1-1 형식으로 바꿔야됨
		System.out.println("몬스터 이름: " + this.getName());
		System.out.println("현재 체력: " + this.getCurrentHealth());
		System.out.println("현재 보유 경험치: " + this.getExpWorth());
		System.out.println("현재 보유 골드: " + this.getGoldWorth());
		System.out.println("현재 보유 약점: " + this.getWeakness());
		System.out.println("회피율: " + this.getEvasion() + "%");
		System.out.println("방어력: " + this.getDefense());
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

	public int getDefense() {
		return defense;
	}

	public void setDefense(Player p) {// 플레이어(로부터 받는 공격양=받은 데미지) 메서드 인자로 받아야 함
//		if (defense >= p.getCurrentStrength())// 플레이어로부터 받은 데미지보다 방어력이 큰 경우
//			setCurrentHealth(getCurrentHealth());// 현재 체력 유지
//		else///플레이어로부터 받은 데미지가 방어력보다 큰 경우
		if (defense < p.getCurrentStrength())
			setCurrentHealth(getCurrentHealth() + (defense - p.getCurrentStrength()));// 현재 체력+=(방어력-받은 데미지)

		// 기본적으로 방어력은 체력에 더해지는 값(체력 증가 효과) 거기에 데미지 빼서 체력값 재정의
	}

}