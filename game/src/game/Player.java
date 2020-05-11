//Need to make quests and have objects associated in here n such ya know

package game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Player extends Entity implements Serializable{
	

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
		System.out.println("레벨 : " + this.getCurrentLevel());
		System.out.println("HP : " + this.getCurrentHealth() + "/" + super.getMaxHealth());
		System.out.println("공격력 : " + this.getCurrentStrength());
		System.out.println("회피율 : " + this.getEvasion() + "%");
		System.out.println("EXP : " + this.getExpWorth() + "/" + levelUpExp);
//		System.out.println("확인========="+this.getExpWorth());//인벤토리로 출력
	
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
	
	//플레이어 상태 저장/불러오기 메서드
	public void loadPlayer() {//불러오기
		FileInputStream f = null;
		ObjectInputStream oos = null;
//		Player load = new Player();
		String name;
		int currentLevel, currentHealth, currentStrength,evasion,exp;
		try {
			f = new FileInputStream("data.ser");
			oos = new ObjectInputStream(f);
//			Player load=(Player)oos.readObject();
//			load.showStatus();
			name = ((String) oos.readObject());
			currentLevel = ((Integer) oos.readObject());
			currentHealth = ((Integer) oos.readObject());
//			load.setCurrentStrength((Integer) oos.readObject());
			currentStrength=((Integer) oos.readObject());
//			load.setCurrentStrength((Integer) oos.readObject());
			evasion=((Integer) oos.readObject());
//			load.setEvasion((Integer) oos.readObject());
			exp = ((Integer) oos.readObject());
//			System.out.println("이름: "+load.name);
//			System.out.println("레벨 : " + load.getCurrentLevel() );
//			System.out.println("최대 HP : " + load.getCurrentHealth());
//			System.yut.println("공격력 : " + load.getCurrentStrength());
//			System.out.println("회피율 : " + load.getEvasion());
//			System.out.println("EXP : " + load.getExpWorth());
//			System.out.println("경험치확인(불러오기 전)====="+this.expWorth);
			this.setName(name);// 이름밖에 안불러와짐
			this.setCurrentLevel(currentLevel);
			this.setCurrentHealth(currentHealth);
//			d.p.setCurrentStrength(load.getCurrentStrength());
			this.setCurrentStrength(currentStrength);
			this.setEvasion(evasion);
			this.setExpWorth(exp);
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
	
	public void savePlayer() {//저장
		FileOutputStream f=null;
		ObjectOutputStream oos=null;
		try {
//			Player Save=p;
			this.showStatus();
//			System.out.println("==========확인");
			f=new FileOutputStream("data.ser");
			oos = new ObjectOutputStream(f);
			oos.writeObject(this.getName());
//			System.out.println("=====이름:"+this.getName());
			oos.writeObject(this.getCurrentLevel());
//			System.out.println("=====레벨:"+this.getCurrentLevel());
			oos.writeObject(this.getCurrentHealth());
			oos.writeObject(this.getCurrentStrength());
			oos.writeObject(this.getEvasion());
			oos.writeObject(this.getCurrentExp());
//			System.out.println("=====exp:"+this.getCurrentExp());
//			oos.writeObject(Save);
			
			
			
			f.close();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(f != null) try{f.close();}catch(IOException e){}
			if(oos != null) try{oos.close();}catch(IOException e){}	

		}
		System.out.println("플레이어 정보가 저장되었습니다");
	}
}