//Need to make quests and have objects associated in here n such ya know

package TeamGameProject;


import java.util.Scanner;
import javax.swing.JOptionPane;

public class Player extends Entity{
	

	// 변수선언
	//private String name;
	//private int currentStrength;;
	//private int currentHealth;
	//private int maxHealth;
	//private float evasion;
	private int gold;
	private int currentLevel;
	private int currentExp;
	private int levelUpExp;
	private Scanner sc;

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
		super.setCurrentHealth(BasicInfo.BASIC_HEALTH);
		super.setMaxHealth(BasicInfo.BASIC_HEALTH);
		super.setCurrentStrength(BasicInfo.BASIC_POWER);
		super.setEvasion(0);
		gold = BasicInfo.BASIC_GOLD;
		currentExp = 0;
		levelUpExp = BasicInfo.BASIC_EXP;
		sc = new Scanner(System.in);
	}


	// 체력의 변화를 반환하는 메서드
	void getCurrnetHeatlh(int health) {
		
		super.setCurrentHealth(super.getCurrentHealth()+ health); 
		if (super.getCurrentHealth()>super.getMaxHealth()) {
		super.setCurrentHealth(super.getMaxHealth());
		}
		
		
		if (super.getCurrentHealth()<=0) {
			super.setCurrentHealth(0);
			System.out.println(super.getName()+"님이 사망하셨습니다.");
		}
	}
		
	
	// 경험치 값을 확인해 레벨업 및 스테이터스 업데이트를 하는 메서드
	void checkLevelUp() {
		while (true) {
			if (getCurrentExp() >= levelUpExp) {

				currentExp = currentExp - levelUpExp;

				currentLevel += 1;
 
				levelUpExp = (int) (levelUpExp * 1.3f);
			super.setMaxHealth((int) (super.getMaxHealth() * 1.3f) / 1);
			super.setCurrentHealth((int) super.getMaxHealth());
				super.setCurrentStrength((int) (super.getCurrentStrength() * 1.3f));
				super.setEvasion(super.getEvasion() + 1);

				System.out.println("레벨업 하였습니다!\n");
				System.out.println("이름 : " + this.name);
				System.out.println("레벨 : " + this.currentLevel + " UP↑");
				System.out.println("최대 HP : " + getCurrentHealth() +"/"+ this.getMaxHealth());
				System.out.println("공격력 : " + this.getCurrentStrength());
				System.out.println("회피율 : " + this.getEvasion() + "%");
				System.out.println("EXP : " + this.currentExp + "/" + this.levelUpExp);
				System.out.println("+++++++++++++++++++++++++++++++++");
				
				if (getCurrentExp() < levelUpExp) {
					break;
				}
			}else {
				break;
			}
		}
	}

	void showStatus() {
		System.out.println("================================");
		System.out.println("플레이어 이름 : " + getName());
		System.out.println("레벨 : " + currentLevel);
		System.out.println("HP : " + getCurrentHealth() + "/" + getMaxHealth());
		System.out.println("공격력 : " + getCurrentStrength());
		System.out.println("회피율 : " + getEvasion() + "%");
		System.out.println("EXP : " + currentExp + "/" + levelUpExp);
		System.out.println("소지금 : " + gold + " Gold");
	
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