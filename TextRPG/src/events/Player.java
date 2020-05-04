package events;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	// 변수선언
	private String name;
	private static int currentLevel;
	private int currentHealth;
	private int maxHealth;
	private static int currentGold;
	private int attackPower;
	private float evasion;
	private ArrayList<String> inventory;
	private static int currentExp;
	private int levelUpExp;
	private Scanner sc;
	private int itemAttackPower;

	Player() {
		name = "";
		setCurrentLevel(BasicInfo.BASIC_LEVEL);
		currentHealth = BasicInfo.BASIC_HEALTH;
		maxHealth = BasicInfo.BASIC_HEALTH;
		attackPower = BasicInfo.BASIC_POWER;
		evasion = 0;
		inventory = new ArrayList<String>();
		setCurrentExp(0);
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		currentGold = BasicInfo.BASIC_GOLD;
		itemAttackPower = 0;
	}

	// 캐릭터의 이름을 받는 메서드
	void addName() {

		System.out.println("캐릭터의 이름을 입력해주세요.");
		name = sc.nextLine();

		while (true) {
			System.out.println("입력하신 이름이 " + name + "이 맞습니까? 맞으면 y 틀리면n");
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
		// return name;

	}

	// 경험치 획득 메서드
	void getExp(int Exp) {

		setCurrentExp(getCurrentExp() + Exp);

		// return currentExp;
	}

	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	int checkLevelUp() {
		while (true) {
			if (getCurrentExp() >= levelUpExp) {

				setCurrentExp(getCurrentExp() - levelUpExp);

				setCurrentLevel(getCurrentLevel() + 1);

				levelUpExp = (int) (levelUpExp * 1.3f);
				maxHealth = (int) (maxHealth * 1.3f) / 1;
				currentHealth = (int) maxHealth;
				attackPower = (int) (attackPower * 1.3f);
				evasion = evasion + 1.0f;

				System.out.println("레벨업 하였습니다!\n");

				System.out.println("레벨 : " + getCurrentLevel() + " UP↑");
				System.out.println("HP : " + currentHealth + "/" + maxHealth);
				System.out.println("공격력 : " + attackPower);
				System.out.println("회피율 : " + evasion + "%");
				System.out.println("EXP : " + getCurrentExp() + "/" + levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");
				if (getCurrentExp() < levelUpExp) {
					break;
				}

			}
		}

		return getCurrentLevel();
	}

	// 골드 변화 메서드
	void getGold(int gold) {
		this.gold = this.gold + gold;

		System.out.println();
		// return gold;
	}

	void showStatus() {
		System.out.println("================================");
		System.out.println("레벨 : " + getCurrentLevel());
		System.out.println("HP : " + currentHealth + "/" + maxHealth);
		System.out.println("공격력 : " + attackPower);
		System.out.println("회피율 : " + evasion + "%");
		System.out.println("EXP : " + getCurrentExp() + "/" + levelUpExp);

	}

	void checkItem() {
		int check1 = 0;
		int check2 = 0;
		int check3 = 0;
		int check4 = 0;
		int check5 = 0;
		int check6 = 0;
		int check7 = 0;
		int check8 = 0;
		int check9 = 0;
		int check10 = 0;
		int check11 = 0;
		int check12 = 0;

		if (check1 == 1) {
		}
		if (check2 == 1) {
		}
		if (check3 == 1) {
		}
		if (check4 == 1) {
		}
		if (check5 == 1) {
		}
		if (check6 == 1) {
		}
		if (check7 == 1) {
		}
		if (check8 == 1) {
		}
		if (check9 == 1) {
		}
		if (check10 == 1) {
		}
		if (check11 == 1) {
		}
		if (check12 == 1) {
		}

	}

	public static int getCurrentGold() {
		return currentGold;
	}

	public void setCurrentGold(int currentGold) {
		Player.currentGold = currentGold;
	}

	public static int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		Player.currentLevel = currentLevel;
	}

	public static int getCurrentExp() {
		return currentExp;
	}

	public void setCurrentExp(int currentExp) {
		Player.currentExp = currentExp;
	}

}
