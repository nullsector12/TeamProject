//Need to make quests and have objects associated in here n such ya know

package game;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Entity{

	// 변수선언
	private String name;
	private int currentLevel;
	private int currentHealth;
	private int maxHealth;
	private int gold;
	private int attackPower;
	private float evasion;
	private ArrayList<String> inventory;
	private int currentExp;
	private int levelUpExp;
	private Scanner sc;
	private int itemAttackPower;

	Player() {
		super.setName("");
		currentLevel = BasicInfo.BASIC_LEVEL;
		super.setCurrentHealth(BasicInfo.BASIC_HEALTH);
		super.setMaxHealth(BasicInfo.BASIC_HEALTH);
		super.setCurrentStrength(BasicInfo.BASIC_POWER);
		evasion = 0.00f;
		gold = BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
	}

	// 캐릭터의 이름을 받는 메서드
	void addName() {

		System.out.println("캐릭터의 이름을 입력해주세요.");
		name = sc.nextLine();
		setName(name);
		name=getName();
		
		System.out.println("-------"+getName());

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

		currentExp = currentExp + Exp;

		// return currentExp;
	}

	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	int checkLevelUp() {
		while (true) {
			if (currentExp >= levelUpExp) {

				currentExp = currentExp - levelUpExp;

				currentLevel++;

				levelUpExp = (int) (levelUpExp * 1.3f);
				maxHealth = (int) (maxHealth * 1.3f) / 1;
				currentHealth = (int) maxHealth;
				attackPower = (int) (attackPower * 1.3f);
				evasion = evasion + 1.0f;

				System.out.println("레벨업 하였습니다!\n");

				System.out.println("레벨 : " + currentLevel + " UP↑");
				System.out.println("HP : " + currentHealth + "/" + maxHealth);
				System.out.println("공격력 : " + attackPower);
				System.out.println("회피율 : " + evasion + "%");
				System.out.println("EXP : " + currentExp + "/" + levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");
				if (currentExp < levelUpExp) {
					break;
				}

			}
		}

		return currentLevel;
	}

	// 골드 변화 메서드
	void getGold(Monster m) {
		this.gold = this.gold +m.getGoldWorth();

		System.out.println();
		// return gold;
	}

	void showStatus() {
		System.out.println("================================");
		System.out.println("레벨 : " + currentLevel);
		System.out.println("HP : " + currentHealth + "/" + maxHealth);
		System.out.println("공격력 : " + attackPower);
		System.out.println("회피율 : " + evasion + "%");
		System.out.println("EXP : " + currentExp + "/" + levelUpExp);

	}



}