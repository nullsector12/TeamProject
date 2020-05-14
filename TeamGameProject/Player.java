package TeamGameProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;//maxExp
import items.A_Hat;
import items.A_HeadPiece;
import items.B_DiamondArmor;
import items.B_OldArmor;
import items.B_ShiningArmor;
import items.C_InvisibilityCloak;
import items.C_OldCloak;
import items.C_ShiningCloak;
import items.D_DiamondWand;
import items.D_GoldWand;
import items.D_SilverWand;
import items.Inven;
import potionStore.Potion;
import skills.Bash;
import skills.Brandish;
import skills.EdgeStrike;
import skills.SkillInven;

public class Player extends Entity {

	private Scanner sc;

	private A_Hat A1;
	private A_HeadPiece A2;
	private B_OldArmor B1;
	private B_ShiningArmor B2;
	private B_DiamondArmor B3;
	private C_OldCloak C1;
	private C_ShiningCloak C2;
	private C_InvisibilityCloak C3;
	private D_SilverWand D1;
	private D_GoldWand D2;
	private D_DiamondWand D3;

	private Inven inven;

	private int invenMaxHealth;
	private int invenCurrentHealth;
	private int invenCurrentEvasion;
	private int invenCurrentStrength;

	private int gold;
	private int currentLevel;
	private int currentExp;
	private int levelUpExp;

	private ArrayList<Potion> potion;

	private SkillInven skillInven;

	private Bash skill1;
	private EdgeStrike skill2;
	private Brandish skill3;

	private int bossCount;
	private int stage2Count;
	private int stage3Count;

	// S M L
	private Potion sp;
	private Potion np;
	private Potion bp;

	public Player() {

		setName("");
		currentLevel = BasicInfo.BASIC_LEVEL;
		setCurrentHealth(BasicInfo.BASIC_HEALTH);
		setMaxHealth(BasicInfo.BASIC_HEALTH);
		setCurrentStrength(BasicInfo.BASIC_POWER);
		setEvasion(0);
		setGold(BasicInfo.BASIC_GOLD);// BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		inven = new Inven();

		invenMaxHealth = getMaxHealth() + inven.equipHealth;
		invenCurrentHealth = getCurrentHealth() + inven.equipHealth;
		invenCurrentStrength = getCurrentStrength() + inven.equipPower;
		invenCurrentEvasion = getEvasion() + inven.equipEvasion;

		A1 = new A_Hat("", 0, 0, 0, 0, 0);
		A2 = new A_HeadPiece("", 0, 0, 0, 0, 0);
		B1 = new B_OldArmor("", 0, 0, 0, 0, 0);
		B2 = new B_ShiningArmor("", 0, 0, 0, 0, 0);
		B3 = new B_DiamondArmor("", 0, 0, 0, 0, 0);
		C1 = new C_OldCloak("", 0, 0, 0, 0, 0);
		C2 = new C_ShiningCloak("", 0, 0, 0, 0, 0);
		C3 = new C_InvisibilityCloak("", 0, 0, 0, 0, 0);
		D1 = new D_SilverWand("", 0, 0, 0, 0, 0);
		D2 = new D_GoldWand("", 0, 0, 0, 0, 0);
		D3 = new D_DiamondWand("", 0, 0, 0, 0, 0);

		skillInven = new SkillInven();
		skill1 = new Bash("", 0, 0, 0);
		skill2 = new EdgeStrike("", 0, 0, 0);
		skill3 = new Brandish("", 0, 0, 0);

		potion = new ArrayList<Potion>(3);

		sp = new Potion("소형 체력 포션", 30, 0, 20);
		np = new Potion("중형 체력 포션", 60, 0, 30);
		bp = new Potion("대형 체력 포션", 150, 0, 60);

	}

	// 캐릭터의 이름을 받는 메서드
	void addName() {
		int num;

		while (true) {
//			System.out.println("입력하신 이름이 \" + super.getName() + \"님이 맞습니까? 맞으면 y 틀리면n");
//			String check = sc.nextLine();

//			if (check.equals("y") || check.equals("Y")) {
//				System.out.println("	캐릭터가 생성되었습니다!");
//				break;
//
//			} else if (check.equals("n") || check.equals("N")) {
//				addName();
//				break;
//			} else {
//				System.out.println("	잘못 누르셨습니다.");
//				continue;
//			}

			super.setName(JOptionPane.showInputDialog("	캐릭터의 이름을 입력해주세요."));

			num = JOptionPane.showConfirmDialog(null, "입력하신 이름이 " + super.getName() + "님이 맞습니까?");

			if (num == 0) {
				System.out.println("	캐릭터가 생성되었습니다!");
				break;

			} else if (num == 1) {
				addName();
				break;
			} else {
				System.out.println("	취소를 누르셨습니다.");
				continue;
			}
		}
	}

	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	void checkLevelUp() {
		calEquipStat();
		while (true) {
			if (getCurrentExp() >= levelUpExp) {

				currentExp = currentExp - levelUpExp;

				currentLevel += 1;

				levelUpExp = (int) (levelUpExp * 1.3f);
				setMaxHealth((int) (getMaxHealth() * 1.3f) / 1);
				setCurrentHealth(getMaxHealth());
				setCurrentStrength((int) (getCurrentStrength() * 1.3f));
				setEvasion(getEvasion() + 1);
				invenCurrentStrength = currentStrength + inven.equipPower;
				invenMaxHealth = maxHealth + inven.equipHealth;
				invenCurrentHealth = currentHealth + inven.equipHealth;
				invenCurrentEvasion = getEvasion() + inven.equipEvasion;
				System.out.println("	┏━━━━━Congraturations!!!!━━━━━┓");
				System.out.println("	┃	 레벨업 하였습니다!	      ┃");
				System.out.println("	┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				System.out.println("		> 레벨 : " + this.currentLevel + " UP↑	<");
				System.out.println("		> HP : " + invenCurrentHealth + "/" + invenMaxHealth + "<");
				System.out.println("		> 공격력 : " + invenCurrentStrength + "	<");
				System.out.println("		> 회피율 : " + invenCurrentEvasion + "%	<");
				System.out.println("		> EXP : " + this.currentExp + "/" + this.levelUpExp + "	<");
				System.out.println("	┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

				if (getCurrentExp() < levelUpExp) {
					break;
				}
			} else {
				break;
			}
		}
	}

	void showStatus() {

		calEquipStat();
		System.out.println("	┏━━━━━━━━Player Status━━━━━━━━┓");
		System.out.println("	┃	 	      	      ┃");
		System.out.println("	>	플레이어 이름 : " + getName() + "	<");
		System.out.println("	>	레벨 : " + currentLevel + "		<");
		System.out.println("	>	HP : " + invenCurrentHealth + "/" + invenMaxHealth + "	<");
		System.out.println("	>	공격력 : " + invenCurrentStrength + "	<");
		System.out.println("	>	회피율 : " + invenCurrentEvasion + "%	<");
		System.out.println("	>	EXP : " + currentExp + "/" + levelUpExp + "	<");
		System.out.println("	>	소지금 : " + gold + " Gold<");
		System.out.println("	┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	// 포션구매 메서드
	public void buyPotion(int i, int num) {

		// 처음에만 포션틀을 추가
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}
		
		if (potion.get(i-1).price * num > gold) {
			System.out.println("골드가 부족하여 구매할수없습니다.");
			return;
		}
		potion.set(i-1, new Potion(potion.get(i).pName, potion.get(i).pAddHealth, (potion.get(0).pNum) + num, potion.get(i).price));
		setGold(getGold()-potion.get(i).price);
		
		System.out.println(potion.get(i - 1).pName + ", " + potion.get(i - 1).pNum);

		System.out.println(potion.toString());
		System.out.println("포션을 구매하였습니다.");


	}

	// 포션 사용 메서드
	public void usePotion(int i) {
		if (potion.get(i - 1).pNum == 0) {
			System.out.println("해당 포션이 없어서 사용할 수 없습니다.");
			return;
		}
		potion.set(i - 1,
				new Potion(potion.get(i - 1).pName, 30, (potion.get(i - 1).pNum) - 1, potion.get(i - 1).price));

		invenCurrentHealth = invenCurrentHealth + 30;

		if (invenCurrentHealth > invenMaxHealth) {
			invenCurrentHealth = invenMaxHealth;
		}

	}

	public void showPotion() {
		// 처음에만 포션틀을 추가
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}
		System.out.println("	==========보유 포션==========");
		System.out.println("	" + potion.toString());

	}

	// 장비의 스탯 계산
	public void calEquipStat() {
		inven.equipHealth = 0;
		inven.equipPower = 0;
		inven.equipEvasion = 0;
		for (int i = 0; i < inven.equip.size(); i++) {

			inven.equipPower += inven.equip.get(i).attackPower;
			inven.equipHealth += inven.equip.get(i).health;
			inven.equipEvasion += inven.equip.get(i).evasion;

		}

	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getCurrentExp() {// levelUpExp
		return currentExp;
	}

	public int setCurrentExp(int currentExp) {
		return this.currentExp = currentExp;
	}

	public int getLevelUpExp() {// levelUpExp
		return levelUpExp;
	}

	public int setLevelUpExp(int levelUpExp) {
		return this.levelUpExp = levelUpExp;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public int setCurrentLevel(int currentLevel) {
		return this.currentLevel = currentLevel;
	}

	public int getBossCount() {
		return bossCount;
	}

	public void setBossCount(int bossCount) {
		this.bossCount = bossCount;
	}

	public int getStage2Count() {
		return stage2Count;
	}

	public void setStage2Count(int stage2Count) {
		this.stage2Count = stage2Count;
	}

	public int getStage3Count() {
		return stage3Count;
	}

	public void setStage3Count(int stage3Count) {
		this.stage3Count = stage3Count;
	}

	public int getInvenMaxHealth() {
		return invenMaxHealth;
	}

	public void setInvenMaxHealth(int invenMaxHealth) {
		this.invenMaxHealth = invenMaxHealth;
	}

	public int getInvenCurrentHealth() {
		return invenCurrentHealth;
	}

	public void setInvenCurrentHealth(int invenCurrentHealth) {
		this.invenCurrentHealth = invenCurrentHealth;
	}

	public int getInvenCurrentEvasion() {
		return invenCurrentEvasion;
	}

	public void setInvenCurrentEvasion(int invenCurrentEvasion) {
		this.invenCurrentEvasion = invenCurrentEvasion;
	}

	public int getInvenCurrentStrength() {
		return invenCurrentStrength;
	}

	public void setInvenCurrentStrength(int invenCurrentStrength) {
		this.invenCurrentStrength = invenCurrentStrength;
	}

	public SkillInven getSkillInven() {
		return skillInven;
	}

	public void setSkillInven(SkillInven skillInven) {
		this.skillInven = skillInven;
	}

	public Inven getInven() {
		return inven;
	}

	public void setInven(Inven inven) {
		this.inven = inven;
	}

	public Bash getSkill1() {
		return skill1;
	}

	public void setSkill1(Bash skill1) {
		this.skill1 = skill1;
	}

	public EdgeStrike getSkill2() {
		return skill2;
	}

	public void setSkill2(EdgeStrike skill2) {
		this.skill2 = skill2;
	}

	public Brandish getSkill3() {
		return skill3;
	}

	public void setSkill3(Brandish skill3) {
		this.skill3 = skill3;
	}

	public A_Hat getA1() {
		return A1;
	}

	public void setA1(A_Hat a1) {
		A1 = a1;
	}

	public A_HeadPiece getA2() {
		return A2;
	}

	public void setA2(A_HeadPiece a2) {
		A2 = a2;
	}

	public B_OldArmor getB1() {
		return B1;
	}

	public void setB1(B_OldArmor b1) {
		B1 = b1;
	}

	public B_ShiningArmor getB2() {
		return B2;
	}

	public void setB2(B_ShiningArmor b2) {
		B2 = b2;
	}

	public B_DiamondArmor getB3() {
		return B3;
	}

	public void setB3(B_DiamondArmor b3) {
		B3 = b3;
	}

	public C_OldCloak getC1() {
		return C1;
	}

	public void setC1(C_OldCloak c1) {
		C1 = c1;
	}

	public C_ShiningCloak getC2() {
		return C2;
	}

	public void setC2(C_ShiningCloak c2) {
		C2 = c2;
	}

	public C_InvisibilityCloak getC3() {
		return C3;
	}

	public void setC3(C_InvisibilityCloak c3) {
		C3 = c3;
	}

	public D_SilverWand getD1() {
		return D1;
	}

	public void setD1(D_SilverWand d1) {
		D1 = d1;
	}

	public D_GoldWand getD2() {
		return D2;
	}

	public void setD2(D_GoldWand d2) {
		D2 = d2;
	}

	public D_DiamondWand getD3() {
		return D3;
	}

	public void setD3(D_DiamondWand d3) {
		D3 = d3;
	}

	// 플레이어 상태 저장/불러오기 메서드
	public void loadPlayer() {// 불러오기
		FileInputStream f = null;
		ObjectInputStream oos = null;
		// ByteArrayInputStream oas = null;

//		Player load = new Player();
		String name;
		int currentLevel, currentHealth, maxHealth, currentStrength, evasion, exp, gold, levelUpExp;
		/*
		 * invenMaxHealth = maxHealth + inven.equipHealth; invenCurrentHealth =
		 * currentHealth + inven.equipHealth; invenCurrentStrength = currentStrength +
		 * inven.equipPower; invenCurrentEvasion = getEvasion() + inven.equipEvasion;
		 */

		int invenCurrentHealth, invenMaxHealth, invenCurrentStrength, invenCurrentEvasion;
		/*
		 * public int bossCount;//저장해야됨 public int stage2Count; public int stage3Count;
		 */

		int bossCount, stage2Count, stage3Count;
		try {
			f = new FileInputStream("data.ser");
			oos = new ObjectInputStream(f);
//			Player load=(Player)oos.readObject();
//			load.showStatus();
			name = ((String) oos.readObject());
			currentLevel = ((Integer) oos.readObject());
			currentHealth = ((Integer) oos.readObject());
			maxHealth = ((Integer) oos.readObject());
//			load.setCurrentStrength((Integer) oos.readObject());
			currentStrength = ((Integer) oos.readObject());
//			load.setCurrentStrength((Integer) oos.readObject());
			evasion = ((Integer) oos.readObject());
//			load.setEvasion((Integer) oos.readObject());

			exp = ((Integer) oos.readObject());
			levelUpExp = ((Integer) oos.readObject());// 추가
			// ============================================================== 추가사항
			gold = ((Integer) oos.readObject());
			// ============================================================== 수정사항
			invenCurrentHealth = ((Integer) oos.readObject());
			invenMaxHealth = ((Integer) oos.readObject());
			invenCurrentStrength = ((Integer) oos.readObject());
			invenCurrentEvasion = ((Integer) oos.readObject());
			// ============================================================== 수정사항
			bossCount = ((Integer) oos.readObject());
			stage2Count = ((Integer) oos.readObject());
			stage3Count = ((Integer) oos.readObject());
			// ============================================================== 수정사항
			/*
			 * System.out.println("이름 : " + this.name); System.out.println("레벨 : " +
			 * this.currentLevel + " UP↑"); System.out.println("HP : " + invenCurrentHealth
			 * + "/" + invenMaxHealth); System.out.println("공격력 : " + invenCurrentStrength);
			 * System.out.println("회피율 : " + invenCurrentEvasion + "%");
			 * System.out.println("EXP : " + this.currentExp + "/" + this.levelUpExp);
			 */
			// ============================================================== 수정사항

//			System.out.println("이름: "+load.name);
//			System.out.println("레벨 : " + load.getCurrentLevel() );
//			System.out.println("최대 HP : " + load.getCurrentHealth());
//			System.yut.println("공격력 : " + load.getCurrentStrength());
//			System.out.println("회피율 : " + load.getEvasion());
//			System.out.println("EXP : " + load.getExpWorth());
//			System.out.println("경험치확인(불러오기 전)====="+this.expWorth);
			this.setName(name);// 이름밖에 안불러와짐
			this.setCurrentLevel(currentLevel);

			/*
			 * oos.writeObject(this.invenCurrentHealth);
			 * System.out.println("현재 체력"+this.invenCurrentHealth);
			 * oos.writeObject(this.getMaxHealth());//최대체력도 저장
			 * System.out.println("최대 체력:"+this.getMaxHealth());
			 * oos.writeObject(this.getCurrentStrength());
			 * System.out.println("저장 공격력:"+this.getCurrentStrength());
			 * oos.writeObject(this.getEvasion());
			 * System.out.println("저장 회피율:"+this.getEvasion());
			 */

			this.setCurrentHealth(currentHealth);
//			System.out.println("현재 체력 확인!:" + currentHealth);
			this.setMaxHealth(maxHealth);
			this.setCurrentStrength(currentStrength);
			this.setEvasion(evasion);

			this.setCurrentExp(exp);
			this.setLevelUpExp(levelUpExp);
			this.setGold(gold);

//			System.out.println("=======================================인벤토리");
			this.invenCurrentHealth = invenCurrentHealth; // 변수 필요없음
			this.invenMaxHealth = invenMaxHealth;
			this.invenCurrentStrength = invenCurrentStrength;
			this.invenCurrentEvasion = invenCurrentEvasion;
//			System.out.println("=======================================카운트");
			this.bossCount = bossCount;
			this.stage2Count = stage2Count;
			this.stage3Count = stage3Count;
			System.out.println("=======================================장비리스트");

			/*
			 * invenCurrentStrength = currentStrength + inven.equipPower; invenMaxHealth =
			 * maxHealth + inven.equipHealth; invenCurrentHealth = currentHealth +
			 * inven.equipHealth - dmg; invenCurrentEvasion = getEvasion() +
			 * inven.equipEvasion;
			 */

//			System.out.println("경험치확인(불러온 후)====="+this.expWorth);
//			System.out.println("불러온 후======");
//			this.showStatus();
			// 값 추가해야됨
			// 불러오기 전의 정보를 불러온 정보로 교체

			oos.close();
			System.out.println("플레이어 정보를 불러왔습니다");
		} catch (Exception e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
				}
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
				}
		}
	}

	public void savePlayer() {// 저장
		FileOutputStream f = null;
		ObjectOutputStream oos = null;
//		ByteArrayOutputStream baos = null;
//		byte[] serializedMember;

		try {
//			Player Save=p;
			this.showStatus();
//			System.out.println("==========확인");
			f = new FileOutputStream("data.ser");
			oos = new ObjectOutputStream(f);
			// baos = new ByteArrayOutputStream();

			// ============================================================== 수정사항
			/*
			 * System.out.println("이름 : " + this.name); System.out.println("레벨 : " +
			 * this.currentLevel + " UP↑"); System.out.println("HP : " + invenCurrentHealth
			 * + "/" + invenMaxHealth); System.out.println("공격력 : " + invenCurrentStrength);
			 * System.out.println("회피율 : " + invenCurrentEvasion + "%");
			 * System.out.println("EXP : " + this.currentExp + "/" + this.levelUpExp);
			 */
			// ============================================================== 수정사항

			// ============================================================== 수정사항
			oos.writeObject(this.getName());
//			System.out.println("=====이름:"+this.getName());
			oos.writeObject(this.getCurrentLevel());
//			System.out.println("=====레벨:"+this.getCurrentLevel());
//			oos.writeObject(this.invenCurrentHealth);//최대체력도 저장

			oos.writeObject(this.invenCurrentHealth);
//			System.out.println("현재 체력" + this.invenCurrentHealth);
			oos.writeObject(this.getMaxHealth());// 최대체력도 저장
//			System.out.println("최대 체력:" + this.getMaxHealth());
			oos.writeObject(this.getCurrentStrength());
//			System.out.println("저장 공격력:" + this.getCurrentStrength());
			oos.writeObject(this.getEvasion());
//			System.out.println("저장 회피율:" + this.getEvasion());

			oos.writeObject(this.getCurrentExp());
			oos.writeObject(this.getLevelUpExp());
			oos.writeObject(this.getGold());
			// ============================================================== 추가사항
			oos.writeObject(this.invenCurrentHealth);
			oos.writeObject(this.invenMaxHealth);
			oos.writeObject(this.invenCurrentStrength);
			oos.writeObject(this.invenCurrentEvasion);
			// ============================================================== 추가사항
			oos.writeObject(this.bossCount);
			oos.writeObject(this.stage2Count);
			oos.writeObject(this.stage3Count);

//			oos = new ObjectOutputStream(baos);
//			oos.writeObject(this.inven.equip);
//			oos.writeObject(this.inven.inven);

			f.close();
			oos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException e) {
				}
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
				}

		}
		System.out.println("플레이어 정보가 저장되었습니다");
	}
}