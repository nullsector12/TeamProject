package game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 앞으로 추가 할 사항 :
 * 
 * 보스 사냥 성공 후 다음 스테이지 도전 or 마을 복귀 선택지 장비 탈착 기능
 * 
 *
 */
public class Town implements Serializable {

	private static final long serialVersionUID = 1L;
	Scanner input = new Scanner(System.in);
	Dungeon d = new Dungeon();
	Player p = new Player();
	/*
	 * System.out.println("이름 : " + this.name); System.out.println("레벨 : " +
	 * this.currentLevel + " UP↑"); System.out.println("최대 HP : " +
	 * getCurrentHealth() +"/"+ this.getMaxHealth()); System.out.println("공격력 : " +
	 * this.getCurrentStrength()); System.out.println("회피율 : " + this.getEvasion() +
	 * "%"); System.out.println("EXP : " + this
	 */

	String name;
	int currentLevel;
	int currentHealth;
	int currentEvasion;
	int currentExp;
//	private static void readObj(Player p){
//		FileInputStream f=null;
//		ObjectInputStream oos=null;
//		try {
//			f=new FileInputStream("data.ser");
//			oos = new ObjectInputStream(f);
//			Player load=(Player)oos.readObject();
//			p.showStatus();
//			oos.close();
//
//		} catch (Exception e) {
//
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}finally{
//			if(f != null) try{f.close();}catch(IOException e){}
//			if(oos != null) try{oos.close();}catch(IOException e){}
//		}
//
//
//
//	}

	void town() {

		while (true) {
			System.out.println("무엇을 하시겠습니까  >>> 1. 던전 가기  2. 캐릭터 정보창  3. 상점 이용  4. 여관 이용(체력회복) 5. 저장  6.불러오기  7.게임종료	");

			int choiceMenu = input.nextInt();
			input.nextLine();

			switch (choiceMenu) {

			case 1: // 던전 들어가기
				if (d.stage(d.p)) {// d.p객체 정보 확인
					continue;
				}
				break;

			case 2: // 현재 정보 확인
				d.p.showStatus();
				break;

			case 3: // 상점 이용
				break;

			case 4: // 여관 이용 ( 골드 소모에 따라 플레이어 현재 체력 회복 )
				break;

			case 5://저장
				d.p.savePlayer();
				break;
			case 6://불러오기
				d.p.loadPlayer();
				break;
			case 7: // 게임 완전 종료
				System.out.println("게임을 정말 종료하시겠습니까? 종료하면 지금까지의 플레이 기록은 삭제됩니다. y or n");
				String exit = input.nextLine();
				if (exit.equals("y")) {
					System.out.println("게임을 종료합니다. 안녕히 가세요!");
					System.exit(0);
					break;
				} else if (exit.equals("n")) {
					System.out.println("마을로 돌아갑니다.");
					break;
				}
				// 불러오기
				// 저장 불러오기 둘다
//			case 6:// 게임 이어서 하기
//				FileInputStream f = null;
//				ObjectInputStream oos = null;
////				Player load = new Player();
//				String name;
//				int currentLevel, currentHealth, currentStrength,evasion,exp;
//				try {
//					f = new FileInputStream("data.ser");
//					oos = new ObjectInputStream(f);
////					Player load=(Player)oos.readObject();
////					load.showStatus();
//					name = ((String) oos.readObject());
//					System.out.println(name);
//					currentLevel = ((Integer) oos.readObject());
//					System.out.println(currentLevel);
//					currentHealth = ((Integer) oos.readObject());
//					System.out.println(currentHealth);
////					load.setCurrentStrength((Integer) oos.readObject());
//					currentStrength=((Integer) oos.readObject());
//					System.out.println(currentStrength);
////					load.setCurrentStrength((Integer) oos.readObject());
//					evasion=((Integer) oos.readObject());
//					System.out.println(evasion);
////					load.setEvasion((Integer) oos.readObject());
//					exp = ((Integer) oos.readObject());
//					System.out.println(exp);//최대 체력도 저장해야됨
////					System.out.println("이름: "+load.name);
////					System.out.println("레벨 : " + load.getCurrentLevel() );
////					System.out.println("최대 HP : " + load.getCurrentHealth());
////					System.yut.println("공격력 : " + load.getCurrentStrength());
////					System.out.println("회피율 : " + load.getEvasion());
////					System.out.println("EXP : " + load.getExpWorth());
//					System.out.println("경험치확인(불러오기 전)====="+d.p.expWorth);
//					d.p.setName(name);// 이름밖에 안불러와짐
//					d.p.setCurrentLevel(currentLevel);
//					d.p.setCurrentHealth(currentHealth);
////					d.p.setCurrentStrength(load.getCurrentStrength());
//					d.p.setCurrentStrength(currentStrength);
//					d.p.setEvasion(evasion);
//					d.p.setExpWorth(exp);
//					System.out.println("경험치확인(불러온 후)====="+d.p.expWorth);
//					System.out.println("불러온 후======");
//					d.p.showStatus();
//					// 값 추가해야됨
//					// 불러오기 전의 정보를 불러온 정보로 교체
//
//					oos.close();
//					System.out.println("불러옴");
//				} catch (Exception e) {
//
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//
//				} finally {
//					if (f != null)
//						try {
//							f.close();
//						} catch (IOException e) {
//						}
//					if (oos != null)
//						try {
//							oos.close();
//						} catch (IOException e) {
//						}
//				}
//				readObj(p);
//				ObjectInputStream ois;
//				try {
//					ois=new ObjectInputStream(new FileInputStream("data.ser"));
//					Player load=(Player) ois.readObject();
////					name=load.getName();
////					currentLevel=load.getCurrentLevel();
////					load.showStatus();
//					ois.close();
////					this.currentLevel=
//					/*		String name;
//	int currentLevel;
//	int currentHealth;
//	int currentEvasion;
//	int currentExp;*/
//					
//				}catch (FileNotFoundException e) {
//                    System.out.println("예외:"+e);   
//                    continue;
//                } catch (IOException e) {
//                } catch (ClassNotFoundException e) {                       
//                }
				break;
			}
			return;

		}

	}
}