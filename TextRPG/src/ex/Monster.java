package ex;

public class Monster extends Entity {

	// 회피 확률->공격 무효화 기능
	private  int evasion;

	private  int goldWorth;// 골드
	private  int expWorth;// 경험치
	private  int weakness;// 몬스터가 가진 기본 약점
	// 1 = physical, 2 = fire, 3 = water, 4 = lightning, 5 = ice, more?!
	private boolean escapable;// 탈출(도망) 가능 여부->도망 가능 true/ 도망 불가 false
	
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
	
	
	// evasion 계산식 정의해야 함
	public int getEvasion() {
		return evasion;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getGoldWorth() {
		return goldWorth;
	}// 랜덤 십진수로 곱해지는 statement에서 일반적으로 호출됨 //usually called in a statement multiplied
		// by a random decimal

	public void setGoldWorth(int g) {
//        Random rand = new Random();
//        int gMin = (int)(g*.7);
//        int gMax = (int)(g*1.2);
//        goldWorth = rand.nextInt(gMax - gMin +1) + gMin; //generates a number from g*.7 - g*1.2 (70% - 120% of g)
	}

//battle/ event에서 gold/exp 관련 정보 처리
	public int getExpWorth() {
		return expWorth;
	}

	public void setExpWorth(int i) {
		expWorth = i;
	}

	public int getWeakness() {
		return weakness;
	}

	public void setWeakness(int i) {
		weakness = i;
	}

	public boolean isEscapable() {
		return escapable;
	}

	public void setEscapable(boolean i) {
		escapable = i;
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
		System.out.println("---------------------------함수 실행 종료");
		return monster;
	}

	public void encounterMonster() {
		printName();
	}

	/*	private  int evasion;
	private  int goldWorth;// 골드
	private  int expWorth;// 경험치
	private  int weakness;// 몬스터가 가진 기본 약점
	// 1 = physical, 2 = fire, 3 = water, 4 = lightning, 5 = ice, more?!
	private boolean escapable;// 탈출(도망) 가능 여부->도망 가능 true/ 도망 불가 false*/
	
	 
	
	public void showData() {
		System.out.println("현재 보유 골드: "+this.goldWorth);
		System.out.println("현재 보유 경험치: "+this.expWorth);
		System.out.println("현재 보유 약점: "+this.weakness);
		System.out.println("도망 가능 여부: "+this.escapable);
		System.out.println("회피 가능성: "+this.evasion);
		
	}
	@Override
	public String toString() {
		return "Monster [evasion=" + evasion + ", goldWorth=" + goldWorth + ", expWorth=" + expWorth + ", weakness="
				+ weakness + ", escapable=" + escapable + "]";
	}
	
	void printName() {
		System.out.println(getName()+"을(를) 만났습니다");
	}
	
	public void  attack(Player player, int hit) {//Player에 가하는 공격의 양
		System.out.println(getName()+"이(가) 공격합니다");
		player.setCurrentHealth(player.getCurrentHealth()-hit);//공격받은 만큼 Player의 hp차감
		if(player.getCurrentHealth()<0) {
			System.out.println("끝");
		}else {
			
		}
	}
	/*
	abstract void printName() ;
*/
	// public Skill[] getSkills(){return blahhh;}
}