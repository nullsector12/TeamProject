//Need to make quests and have objects associated in here n such ya know

package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
import skills.Angry;
import skills.DoubleAngry;
import skills.SkillInven;
import skills.TripleAngry;

public class Player extends Entity {

	public Inven inven = new Inven();
	public A_Hat A1 = new A_Hat("", 0, 0, 0, 0, 0);
	public A_HeadPiece A2 = new A_HeadPiece("", 0, 0, 0, 0, 0);
	public B_OldArmor B1 = new B_OldArmor("", 0, 0, 0, 0, 0);
	public B_ShiningArmor B2 = new B_ShiningArmor("", 0, 0, 0, 0, 0);
	public B_DiamondArmor B3 = new B_DiamondArmor("", 0, 0, 0, 0, 0);
	public C_OldCloak C1 = new C_OldCloak("", 0, 0, 0, 0, 0);
	public C_ShiningCloak C2 = new C_ShiningCloak("", 0, 0, 0, 0, 0);
	public C_InvisibilityCloak C3 = new C_InvisibilityCloak("", 0, 0, 0, 0, 0);
	public D_SilverWand D1 = new D_SilverWand("", 0, 0, 0, 0, 0);
	public D_GoldWand D2 = new D_GoldWand("", 0, 0, 0, 0, 0);
	public D_DiamondWand D3 = new D_DiamondWand("", 0, 0, 0, 0, 0);

	public ArrayList<Potion> potion = new ArrayList<Potion>(3);

	public int invenMaxHealth;
	public int invenCurrentHealth;
	public int invenCurrentEvasion;
	public int invenCurrentStrength;

	private int gold;
	private int currentLevel;
	private int currentExp;
	private int levelUpExp;

	private Scanner sc;
	// S M L
	public Potion sp = new Potion("Small Potion", 30, 0, 20);
	public Potion np = new Potion("Normal Potion", 60, 0, 30);
	public Potion bp = new Potion("Big Potion", 150, 0, 60);

	public SkillInven skill = new SkillInven();

	public Angry Skill1 = new Angry("", 0, 0, 0);
	public DoubleAngry Skill2 = new DoubleAngry("", 0, 0, 0);
	public TripleAngry Skill3 = new TripleAngry("", 0, 0, 0);

	public int bossCount;//저장해야됨
	public int stage2Count;
	public int stage3Count;

	// 캐릭터의 이름을 받는 메서드
	void addName() {
//
//		System.out.println("캐릭터의 이름을 입력해주세요.");
//		name = sc.nextLine();

		super.setName(JOptionPane.showInputDialog("캐릭터의 이름을 입력해주세요."));

		while (true) {
			System.out.println("입력하신 이름이 " + super.getName() + "님이 맞습니까? \n> 맞으면 y 틀리면n");

			String check = sc.nextLine();

			if (check.equals("y") || check.equals("Y")) {
				System.out.println("캐릭터가 생성되었습니다!");
				break;

			} else if (check.equals("n") || check.equals("N")) {
				addName();
				break;
			} else {
				System.out.println("잘못 누르셨습니다.");
				continue;
			}
		}
	}

	public Player() {

		setName("");
		currentLevel = BasicInfo.BASIC_LEVEL;
		super.setCurrentHealth(BasicInfo.BASIC_HEALTH);
		super.setMaxHealth(BasicInfo.BASIC_HEALTH);
		super.setCurrentStrength(BasicInfo.BASIC_POWER);
		super.setEvasion(0);
		setGold(BasicInfo.BASIC_GOLD);// BasicInfo.BASIC_GOLD;
		setCurrentExp(0);
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		invenMaxHealth = maxHealth + inven.equipHealth;
		invenCurrentHealth = currentHealth + inven.equipHealth;
		invenCurrentStrength = currentStrength + inven.equipPower;
		invenCurrentEvasion = getEvasion() + inven.equipEvasion;
	}

	// 체력의 변화를 반환하는 메서드
	void getCurrnetHeatlh(int health) {

		super.setCurrentHealth(super.getCurrentHealth() + health);
		if (super.getCurrentHealth() > super.getMaxHealth()) {
			super.setCurrentHealth(super.getMaxHealth());
		}

		if (super.getCurrentHealth() <= 0) {
			super.setCurrentHealth(0);
			System.out.println(super.getName() + "님이 사망하셨습니다.");
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
				super.setMaxHealth((int) (super.getMaxHealth() * 1.3f) / 1);
				super.setCurrentHealth((int) super.getMaxHealth());
				super.setCurrentStrength((int) (super.getCurrentStrength() * 1.3f));
				super.setEvasion(super.getEvasion() + 1);
				invenCurrentStrength = currentStrength + inven.equipPower;
				invenMaxHealth = maxHealth + inven.equipHealth;
				invenCurrentHealth = currentHealth + inven.equipHealth;
				invenCurrentEvasion = getEvasion() + inven.equipEvasion;

				System.out.println("레벨업 하였습니다!\n");
				System.out.println("이름 : " + this.name);
				System.out.println("레벨 : " + this.currentLevel + " UP↑");
				System.out.println("HP : " + invenCurrentHealth + "/" + invenMaxHealth);
				System.out.println("공격력 : " + invenCurrentStrength);
				System.out.println("회피율 : " + invenCurrentEvasion + "%");
				System.out.println("EXP : " + this.currentExp + "/" + this.levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");

				if (getCurrentExp() < levelUpExp) {
					break;
				}
			} else {
				break;
			}
		}
	}

	public void equipItem() {

		System.out.println("=======================================");
		System.out.println("장착할 장비를 골라주세요.");
		System.out.println("=======================================");

		System.out.println("0. 마을로 돌아가기");

		int select = 0;
		try {
			select = sc.nextInt();
		} catch (Exception e) {
			System.out.println("잘못누르셨습니다.");
			return;
		} finally {

			sc.nextLine();

		}

		if (select == 0) {
			return;
		}
		try {
			inven.checkType(inven.inven.get((select - 1)).equipmentType); // 장비 타입 비교해서 중복된 타입일 시 장비 반환
		} catch (IndexOutOfBoundsException e) {
			System.out.println("해당칸에 장비가 없습니다.");
			return;
		}
		inven.equip.add(inven.inven.get((select - 1)));

		System.out.println(inven.inven.get((select - 1)).equipmentName + "장착");

		inven.inven.remove((select - 1));

		int dmg = invenMaxHealth - invenCurrentHealth;

		calEquipStat();
		System.out.println("장비공격력 : " + inven.equipPower + ", " + "장비체력 : " + inven.equipHealth + ", " + "장비회피율 : "
				+ inven.equipEvasion);
		invenCurrentStrength = currentStrength + inven.equipPower;
		invenMaxHealth = maxHealth + inven.equipHealth;
		invenCurrentHealth = currentHealth + inven.equipHealth - dmg;
		invenCurrentEvasion = getEvasion() + inven.equipEvasion;

		inven.showInventory();
		inven.showEquip();

	}

	void showStatus() {

		calEquipStat();

		System.out.println("================================");
		System.out.println("플레이어 이름 : " + getName());
		System.out.println("레벨 : " + currentLevel);
		System.out.println("HP : " + invenCurrentHealth + "/" + invenMaxHealth);
		System.out.println("공격력 : " + invenCurrentStrength);
		System.out.println("회피율 : " + invenCurrentEvasion + "%");
		System.out.println("EXP : " + currentExp + "/" + levelUpExp);
		System.out.println("소지금 : " + gold + " Gold");

	}

	// 포션구매 메서드
	public void buyPotion(int i, int num) throws Exception {

		// 처음에만 포션틀을 추가
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) + num, 20));

			gold = gold - 20 * num;

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) + num, 30));

			gold = gold - 30 * num;

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 150, (potion.get(2).pNum) + num, 60));

			gold = gold - 60 * num;

			break;

		}

		System.out.println(potion.get(i - 1).pName + ", " + potion.get(i - 1).pNum);

		System.out.println(potion.toString());
		System.out.println("포션을 구매하였습니다.");
	}

	// 포션 사용 메서드
	public void usePotion(int i) throws Exception {
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}
		switch (i) {

		case 1:

			if (potion.get(0).pNum == 0) {
				System.out.println("포션이 없으므로 돌아갑니다.");
				break;
			}

			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) - 1, 20));

			System.out.println("포션을 사용하였습니다.");

			invenCurrentHealth = invenCurrentHealth + 30;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}

			break;

		case 2:
			if (potion.get(1).pNum == 0) {
				System.out.println("포션이 없으므로 돌아갑니다.");
				break;
			}
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) - 1, 30));
			System.out.println("포션을 사용하였습니다.");

			invenCurrentHealth = invenCurrentHealth + 60;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}

			break;
		case 3:
			if (potion.get(2).pNum == 0) {
				System.out.println("포션이 없으므로 돌아갑니다.");
				break;
			}
			potion.set(2, new Potion("Big Potion", 150, (potion.get(2).pNum) - 1, 60));

			System.out.println("포션을 사용하였습니다.");

			invenCurrentHealth = invenCurrentHealth + 150;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}
			break;

		}

	}

	public void showPotion() {
		if (potion.size() == 0) {
			potion.add(sp);
			potion.add(np);
			potion.add(bp);
		}
		System.out.println("==========보유 포션==========");
		System.out.println(potion.toString());

	}

	public void buyEquipment(int select) {
		switch (select) {
		case 1:

			if (A1.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - A1.gold;
			inven.addEquipment(A1);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 2:

			if (A2.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - A2.gold;

			inven.addEquipment(A2);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 3:
			if (B1.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - B1.gold;

			inven.addEquipment(B1);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 4:
			if (B2.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - B2.gold;

			inven.addEquipment(B2);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 5:
			if (B3.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - B3.gold;

			inven.addEquipment(B3);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 6:
			if (C1.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - C1.gold;

			inven.addEquipment(C1);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 7:
			if (C2.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - C2.gold;

			inven.addEquipment(C2);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 8:

			if (C3.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");

				break;
			}
			gold = gold - C3.gold;

			inven.addEquipment(C3);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 9:
			if (D1.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - D1.gold;

			inven.addEquipment(D1);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 10:
			if (D2.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - D2.gold;

			inven.addEquipment(D2);
			System.out.println("장비를 구매하였습니다.");

			break;

		case 11:
			if (D3.gold > gold) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			gold = gold - D3.gold;

			inven.addEquipment(D3);
			System.out.println("장비를 구매하였습니다.");

			break;
		default:
			System.out.println("잘못 선택하셨습니다. 돌아갑니다.");
			break;

		}

	}

	public void sellItem() {

		System.out.println("=======================================");
		System.out.println("판매할 장비를 골라주세요.");
		System.out.println("=======================================");

		System.out.println("0. 마을로 돌아가기");

		int select = 0;
		try {
			select = sc.nextInt();
		} catch (Exception e) {
			System.out.println("잘못 누르셨습니다.");
			return;
		} finally {
			sc.nextLine();
		}
		if (select == 0) {
			return;
		}
		try {
			setGold(getGold() + inven.inven.get(select - 1).gold);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("해당칸에 장비가 없습니다.");
			return;
		}

		inven.inven.remove(select - 1);

		System.out.println("판매 되었습니다.");

	}

	// 장비의 스탯 계산
	public void calEquipStat() {

		for (int i = 0; i < inven.equip.size(); i++) {

			inven.equipPower = inven.equipPower + inven.equip.get(i).attackPower;
			inven.equipHealth = inven.equipHealth + inven.equip.get(i).health;
			inven.equipEvasion = inven.equipEvasion + inven.equip.get(i).evasion;

		}

	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getCurrentExp() {
		return currentExp;
	}

	public int setCurrentExp(int currentExp) {
		return this.currentExp = currentExp;
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

	// 플레이어 상태 저장/불러오기 메서드
	public void loadPlayer() {// 불러오기
		FileInputStream f = null;
		ObjectInputStream oos = null;
//		Player load = new Player();
		String name;
		int currentLevel, currentHealth, maxHealth, currentStrength, evasion, exp, gold;
		/*		invenMaxHealth = maxHealth + inven.equipHealth;
		invenCurrentHealth = currentHealth + inven.equipHealth;
		invenCurrentStrength = currentStrength + inven.equipPower;
		invenCurrentEvasion = getEvasion() + inven.equipEvasion;*/
		
		int invenCurrentHealth,invenMaxHealth,invenCurrentStrength,invenCurrentEvasion;
		
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
			// ============================================================== 추가사항
			gold = ((Integer) oos.readObject());
			// ============================================================== 수정사항
			invenCurrentHealth = ((Integer) oos.readObject());
			invenMaxHealth = ((Integer) oos.readObject());
			invenCurrentStrength = ((Integer) oos.readObject());
			invenCurrentEvasion = ((Integer) oos.readObject());
			
			
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
			System.out.println("현재 체력 확인!:" + currentHealth);
			this.setMaxHealth(maxHealth);
			this.setCurrentStrength(currentStrength);
			this.setEvasion(evasion);

			this.setCurrentExp(exp);
			this.setGold(gold);

			System.out.println("=======================================인벤토리");
			this.invenCurrentHealth =invenCurrentHealth; //변수 필요없음
			this.invenMaxHealth = invenMaxHealth;
			this.invenCurrentStrength =invenCurrentStrength;
			this.invenCurrentEvasion =invenCurrentEvasion;
			
			/*invenCurrentStrength = currentStrength + inven.equipPower;
			invenMaxHealth = maxHealth + inven.equipHealth;
			invenCurrentHealth = currentHealth + inven.equipHealth - dmg;
			invenCurrentEvasion = getEvasion() + inven.equipEvasion;*/

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
		try {
//			Player Save=p;
			this.showStatus();
//			System.out.println("==========확인");
			f = new FileOutputStream("data.ser");
			oos = new ObjectOutputStream(f);
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
			System.out.println("현재 체력" + this.invenCurrentHealth);
			oos.writeObject(this.getMaxHealth());// 최대체력도 저장
			System.out.println("최대 체력:" + this.getMaxHealth());
			oos.writeObject(this.getCurrentStrength());
			System.out.println("저장 공격력:" + this.getCurrentStrength());
			oos.writeObject(this.getEvasion());
			System.out.println("저장 회피율:" + this.getEvasion());

			oos.writeObject(this.getCurrentExp());
			oos.writeObject(this.getGold());
			// ============================================================== 추가사항
			oos.writeObject(this.invenCurrentHealth);
			oos.writeObject(this.invenMaxHealth);
			oos.writeObject(this.invenCurrentStrength);
			oos.writeObject(this.invenCurrentEvasion);
			
//			System.out.println("=====exp:"+this.getCurrentExp());
//			oos.writeObject(Save);

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