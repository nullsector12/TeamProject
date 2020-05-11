package TeamGameProject;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import items.*;
import potionStore.Potion;

public class Player extends Entity {

	// 변수선언
	// private String name;
	// private int currentStrength;;
	// private int currentHealth;
	// private int maxHealth;
	// private float evasion;

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

	public Inven inven = new Inven();

	public int invenMaxHealth;
	public int invenCurrentHealth;
	public int invenCurrentEvasion;
	public int invenCurrentStrength;

	private int gold;
	private int currentLevel;
	private int currentExp;
	private int levelUpExp;
	private Scanner sc;
	public ArrayList<Potion> potion = new ArrayList<Potion>(3);

	// S M L
	public Potion sp = new Potion("Small Potion", 30, 0, 20);

	public Potion np = new Potion("Normal Potion", 60, 0, 30);

	public Potion bp = new Potion("Big Potion", 150, 0, 60);

	// 캐릭터의 이름을 받는 메서드
	void addName() {
//
//		System.out.println("캐릭터의 이름을 입력해주세요.");
//		name = sc.nextLine();

		super.setName(JOptionPane.showInputDialog("캐릭터의 이름을 입력해주세요."));

		while (true) {
			System.out.println("입력하신 이름이 " + super.getName() + "님이 맞습니까? 맞으면 y 틀리면n");
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
		setCurrentHealth(BasicInfo.BASIC_HEALTH);
		setMaxHealth(BasicInfo.BASIC_HEALTH);
		setCurrentStrength(BasicInfo.BASIC_POWER);
		setEvasion(0);
		gold = 80000;// BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		invenMaxHealth = getMaxHealth() + inven.equipHealth;
		invenCurrentHealth = getCurrentHealth() + inven.equipHealth;
		invenCurrentStrength = getCurrentStrength() + inven.equipPower;
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
				setMaxHealth((int) (getMaxHealth() * 1.3f) / 1);
				setCurrentHealth(getMaxHealth());
				setCurrentStrength((int) (getCurrentStrength() * 1.3f));
				setEvasion(getEvasion() + 1);
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

		int select = sc.nextInt();

		sc.nextLine();

		if (select == 0) {
			return;
		}

		inven.checkType(inven.inven.get((select - 1)).equipmentType); // 장비 타입 비교해서 중복된 타입일 시 장비 반환

		inven.equip.add(inven.inven.get((select - 1)));

		System.out.println(inven.inven.get((select - 1)).equipmentName + "장착");

		inven.inven.remove((select - 1));

		int dmg = invenMaxHealth - invenCurrentHealth;

		calEquipStat();
		invenCurrentStrength = getCurrentStrength() + inven.equipPower;
		invenMaxHealth = getMaxHealth() + inven.equipHealth;
		invenCurrentHealth = getCurrentHealth() + inven.equipHealth - dmg;
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
	public void buyPotion(int i, int num) {

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
	public void usePotion(int i) {

		switch (i) {
		case 1:
			potion.set(0, new Potion("Small Potion", 30, (potion.get(0).pNum) - 1, 20));

			// 체력 증가 세터
//
//			setCurrentHealth(getCurrentHealth() + 30);
//
//			if (getCurrentHealth() > getMaxHealth()) {
//				setCurrentHealth(getMaxHealth());
//			}

			invenCurrentHealth = invenCurrentHealth + 30;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}

			break;

		case 2:
			potion.set(1, new Potion("Normal Potion", 60, (potion.get(1).pNum) - 1, 30));

			// 체력 증가 세터
//			setCurrentHealth(getCurrentHealth() + 60);
//
//			if (getCurrentHealth() > getMaxHealth()) {
//				setCurrentHealth(getMaxHealth());
//			}

			invenCurrentHealth = invenCurrentHealth + 60;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}

			break;
		case 3:
			potion.set(2, new Potion("Big Potion", 150, (potion.get(2).pNum) - 1, 60));

			// 체력 증가 세터

//			setCurrentHealth(getCurrentHealth() + 150);
//
//			if (getCurrentHealth() > getMaxHealth()) {
//				setCurrentHealth(getMaxHealth());
//			}

			invenCurrentHealth = invenCurrentHealth + 150;

			if (invenCurrentHealth > invenMaxHealth) {
				invenCurrentHealth = invenMaxHealth;
			}
			break;

		}

	}

	public void showPotion() {
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

		int select = sc.nextInt();

		sc.nextLine();

		if (select == 0) {
			return;
		}
		setGold(getGold() + inven.inven.get(select - 1).gold);
		inven.inven.remove(select - 1);

		System.out.println("판매 되었습니다.");

	}

	// 장비의 스탯 계산
	public void calEquipStat() {

		for (int i = 0; i < inven.equip.size(); i++) {

			inven.equipPower = inven.equip.get(i).attackPower;
			inven.equipHealth = inven.equip.get(i).health;
			inven.equipEvasion = inven.equip.get(i).evasion;

		}

		System.out.println("장비공격력 : " + inven.equipPower + ", " + "장비체력 : " + inven.equipHealth + ", " + "장비회피율 : "
				+ inven.equipEvasion);

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

}