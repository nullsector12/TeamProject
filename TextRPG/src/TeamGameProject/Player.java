//Need to make quests and have objects associated in here n such ya know

package TeamGameProject;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Player extends Entity{
	

	// 변수선언
	//private String name;
	//private int currentStrength;;
	//private int currentHealth;
	//private int maxHealth;
	//private float evasion;

	private int levelUpExp;
	private int currentLevel;
	private int maxHealth;
	private int currentHealth;
	private int attackPower;
	private int evasion;
	private int gold;
	private int currentExp;
	private Scanner sc;
	
	ArrayList<Player> levelSave;
	private static Player player= 	new Player();
	public static Player getInstance() {
		return player;
	}

	public Player() {
		setName("");
		currentLevel = BasicInfo.BASIC_LEVEL; //BasicInfo.BASIC_LEVEL;
		maxHealth = BasicInfo.BASIC_HEALTH;
		currentHealth = maxHealth; //BasicInfo.BASIC_HEALTH
		attackPower = BasicInfo.BASIC_POWER; // BasicInfo.BASIC_POWER
		evasion = setEvasion(0);
		gold = BasicInfo.BASIC_GOLD; //BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP; //BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
		
		
		levelSave = new ArrayList<Player>();
	
	}
	
	//배열에 플레이어 레벨정보저장
	void addlevel(Player p1) {
		
		levelSave.add(p1);
	}

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
		// return name;

	}

	
	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	void checkLevelUp(Player p) {
		
		//양
		Player p1 = null;
		
		while (true) {
			if (getCurrentExp() >= levelUpExp) {

				setCurrentExp(getCurrentExp() - levelUpExp);
				levelUpExp = (int) (levelUpExp * 1.3f);
				
				setCurrentLevel(getCurrentLevel()+1);
				setMaxHealth((int) (getMaxHealth() * 1.3f) / 1);
//				setCurrentHealth((int)getMaxHealth());
				super.setCurrentStrength((int) (super.getCurrentStrength() * 1.3f));
				super.setEvasion(getEvasion() + 1);
				initCurrentStats();

				System.out.println("레벨업 하였습니다!\n");
				System.out.println("레벨 : " + getCurrentLevel() + " UP↑");
				System.out.println("HP : " + getCurrentHealth() + "/" + getMaxHealth());
				System.out.println("공격력 : " + getCurrentStrength());
				System.out.println("회피율 : " + getEvasion() + "%");
				System.out.println("EXP : " + getCurrentExp() + "/" + levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");
				if (getCurrentExp() < levelUpExp) {
					break;
				}
			}
		}addlevel(p1);
	}


	void showStatus() {
		System.out.println("================================");
		System.out.println("레벨 : " + getCurrentLevel());
		System.out.println("HP : " + super.getCurrentHealth() + "/" + super.getMaxHealth());
		System.out.println("공격력 : " + super.getCurrentStrength());
		System.out.println("회피율 : " + super.getEvasion() + "%");
		System.out.println("EXP : " + getCurrentExp() + "/" + levelUpExp);
	
	}

	public int getGold() {
		return gold;
	}

	public int setGold(int gold) {
		return this.gold = gold;
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