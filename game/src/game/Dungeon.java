
package game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* 
 * 스테이지별 몬스터 불러오기
 * 보스입장 묻기
 * 보스잡아야 다음스테이지 입장가능
 */
public class Dungeon implements Serializable{
	private static final long serialVersionUID = 1L; 

	int bossCount; // 보스입장가능 카운트
	int stage2Count; // 스테이지 입장가능 카운트
	int stage3Count;
	Scanner sc;
	Monster m = new Monster();
	Player p = new Player();
	Battle b = new Battle();
	Events e = new Events();

	boolean result;

	public Dungeon() {
		this.bossCount = 0;
		this.stage2Count = 0;
		this.stage3Count = 0;
		sc = new Scanner(System.in);

	}

//	private static void writeObj() {
//		FileOutputStream f=null;
//		ObjectOutputStream oos=null;
//		try {
//			f=new FileOutputStream("data.ser");
//			oos = new ObjectOutputStream(f);
//			oos.writeObject(p);
//			System.out.println("플레이어 정보를 저장했습니다");
//			f.close();
//			oos.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			if(f != null) try{f.close();}catch(IOException e){}
//			if(oos != null) try{oos.close();}catch(IOException e){}	
//
//		}
//
//
//
//	}

	String save = null;

	// 스테이지 선택
	boolean stage(Player p) {//함수 인자인 Player객체가 제대로 된 데이터 갖고 있는지 확인
		int num = stageChoice();
		switch (num) {
		case DungeonIf.EASY:
			result = stageEasy(p);
			System.out.println("현재 플레이어 정보를 저장하시겠습니까?");
			save = sc.nextLine();
			if (save.equals("y") || save.equals("Y")) {// 저장
//				try {
//					ObjectOutputStream obs=new ObjectOutputStream(new FileOutputStream("data.ser"));
////					obs.writeObject(p.getName());
//					obs.writeObject(p);
////					obs.writeObject(p.getCurrentLevel());
//					obs.close();
//				} catch (IOException e) {
//                    e.printStackTrace();
//                }
				FileOutputStream f=null;
				ObjectOutputStream oos=null;
				try {
//					Player Save=p;
					this.p.showStatus();
					System.out.println("==========확인");
					f=new FileOutputStream("data.ser");
					oos = new ObjectOutputStream(f);
					oos.writeObject(p.getName());
					System.out.println("=====이름:"+p.getName());
					oos.writeObject(p.getCurrentLevel());
					System.out.println("=====레벨:"+p.getCurrentLevel());
					oos.writeObject(p.getCurrentHealth());
					oos.writeObject(p.getCurrentStrength());
					oos.writeObject(p.getEvasion());
					oos.writeObject(p.getCurrentExp());
					System.out.println("=====exp:"+p.getCurrentExp());
//					oos.writeObject(Save);
					
					
					
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
//				break;
//				if ((bossStage(m, p, 1))) {//bossStage메서드 승패 여부를 나타내기 위해서 boolean값 반환하도록 변경함
//					stageNomal(p);
//					if(bossStage(m, p, 2)) {
//						stageHard(p);
//					}
//				}
//				else {
//					
//				}
			break;
		case DungeonIf.NOMAL:
			result = stageNomal(p);
//			if (bossStage(m, p, 2)) {
//				stageHard(p);
//				if (bossStage(m, p, 3)) {
//					System.out.println("플레이어 최종 승리");
//				} else {
//					break;// 일단 break
//				}
//			}
			break;
		case DungeonIf.HARD:
			result = stageHard(p);
//			bossStage(m, p, 3);
			break;
		case 4:
			result = true;
			break;
		}

		return result;
	}

	boolean bossStage(Player p, int num) {
		boolean win = false;
		System.out.println("보스에 도전하시겠습니까? y or n");
		String select = sc.nextLine();
		if (select.equals("y")) {
			switch (num) {
			case 1:
				m = makeMonsters(num + 3);
				break;
			case 2:
				m = makeMonsters(num + 6);
				break;
			case 3:
				m = makeMonsters(num + 9);
				break;
			}
			int result = b.choicePlayerMovement(m, p);
			if (result == 0) {// result==1(몬스터 체력0이하일때=몬스터 죽었을 때)로 변경
				switch (num) {
				case 1:
					System.out.println("------------------------");
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");

					stage2Count++;
					e.rewordsOfVictory(p, m);
					win = true;
					break;
				case 2:
					System.out.println("------------------------");
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage3Count++;
					e.rewordsOfVictory(p, m);
					win = true;
					break;
				case 3:
					System.out.println("------------------------");
					System.out.println("마지막보스를 처치하셨습니다.");
					e.rewordsOfVictory(p, m);
					win = true;
					break;
				}
			} else if (result == 2) {
				win = true;
			} else {
				System.out.println("패배하셨습니다.");
				win = false;
			}
		} else {

		}
		return win;
	}

	// 초급스테이지
	boolean stageEasy(Player p) {
		System.out.println("난이도 : 쉬움");
		for (int i = 1; i < 4; i++) {
			result = stage1(p, i);
			if (result) {
				break;
			}
		}
		return result;
	}

	// 중급스테이지
	boolean stageNomal(Player p) {
		System.out.println("난이도 : 보통");
		for (int i = 1; i < 4; i++) {
			result = stage2(p, i);
			if (result) {
				break;
			}
		}
		return result;
	}

	// 상급스테이지
	boolean stageHard(Player p) {
		System.out.println("난이도 : 어려움");
		for (int i = 1; i < 4; i++) {
			result = stage3(p, i);
			if (result) {
				break;
			}
		}
		return result;
	}

	boolean stage1(Player p, int num) {
		result = false;
		switch (num) {
		case 1:
//			m = new Monkey();
			m = makeMonsters(num);// 1 5 9
			break;
		case 2:
//			m = new Sheep();
			m = makeMonsters(num);
			break;
		case 3:
//			m = new Pig();
			m = makeMonsters(num);
			break;
		}
		int win = b.choicePlayerMovement(m, p);
		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);
			bossCount++;
			System.out.println("------------------------");
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p, 1);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("축하합니다. 전투에서 승리하였습니다!");
		} else if (win == 1) {
			result = e.takeDie(p);

		} else if (win == 2) {
			result = true;
		}
		return result;
	}

	boolean stage2(Player p, int num) {
		result = false;
		switch (num) {
		case 1:
//			m = new Monkey();
			m = makeMonsters(num + 4);// 1 5 9
			break;
		case 2:
//			m = new Sheep();
			m = makeMonsters(num + 4);
			break;
		case 3:
//			m = new Pig();
			m = makeMonsters(num + 4);
			break;
		}
		int win = b.choicePlayerMovement(m, p);

		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);
			bossCount++;
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p, 2);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("축하합니다. 전투에서 승리하였습니다!");
		} else if (win == 1) {
			result = e.takeDie(p);

		} else if (win == 2) {
			result = true;
		}
		return result;
	}

	boolean stage3(Player p, int num) {

		switch (num) {
		case 1:
//			m = new Monkey();
			m = makeMonsters(num + 8);// 1 5 9
			break;
		case 2:
//			m = new Sheep();
			m = makeMonsters(num + 8);
			break;
		case 3:
//			m = new Pig();
			m = makeMonsters(num + 8);
			break;
		}
		int win = b.choicePlayerMovement(m, p);

		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);
			bossCount++;
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p, 3);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("축하합니다. 전투에서 승리하였습니다!");
		} else if (win == 1) {
			result = e.takeDie(p);

		} else if (win == 2) {
			result = true;
		}
		return result;
	}

	// 스테이지 선택
	int stageChoice() {
		System.out.println("====================");
		System.out.println("스테이지를 선택해주세요.");
		System.out.println("1. Easy 2. Nomal 3. Hard");
		int num = sc.nextInt();
		sc.nextLine();
		if (num == 2 && stage2Check()) {
			num = 4;
			return num;
		} else if (num == 3 && stage3Check()) {
			num = 4;
			return num;
		}
		return num;

	}

	// 스테이지 입장가능?
	boolean stage2Check() {

		boolean result = false;
		if (stage2Count == 0) {
			System.out.println("입장하실수 없습니다.");
			result = true;

		}
		return result;
	}

	boolean stage3Check() {

		boolean result = false;
		if (stage3Count == 0) {
			System.out.println("입장하실수 없습니다.");

			result = true;
		}
		return result;
	}

//	// 보스 입장가능 불가능할경우
//	boolean boss1Check() {
//		boolean result = false;
//		if (boss1Count == 0) {
//			System.out.println("입장하실수 없습니다.");
//			result = true;
//		}
//		return result;
//	}
//
//	boolean boss2Check() {
//		boolean result = false;
//		if (boss2Count == 0) {
//			System.out.println("입장하실수 없습니다.");
//			result = true;
//		}
//		return result;
//	}
//
//	boolean boss3Check() {
//		boolean result = false;
//		if (boss3Count == 0) {
//			System.out.println("입장하실수 없습니다.");
//			result = true;
//		}
//		return result;
//	}
//
//	// 보스선택
//	int bossChoice() {
//		System.out.println("보스를 선택해주세요");
//		System.out.println("1. 1단계 2. 2단계 3. 3단계");
//		int num = sc.nextInt();
//		sc.nextLine();
//		switch (num) {
//		case 1:
//			if (boss1Check()) {
//				num = 4;
//			}
//			break;
//		case 2:
//			if (boss2Check()) {
//				num = 4;
//			}
//			break;
//		case 3:
//			if (boss3Check()) {
//				num = 4;
//			}
//			break;
//		}
//
//		return num;
//	}
//
//	// 진행여부 선택
//	boolean playCheck() {
//
//		boolean result = false;
//		System.out.println("더 진행하시겠습니까? 1. yes 2.no");
//		int num = sc.nextInt();
//		sc.nextLine();
//		switch (num) {
//		case 1:
//			System.out.println("다음 스테이지로 진행합니다.");
//			result = true;
//			break;
//		case 2:
//			System.out.println("마을로 돌아갑니다.");
//			break;
//		}
//		return result;
//	}

	boolean playBoss() {
		boolean result = false;
		System.out.println("보스에 도전하시겠습니까? 1. yes 2.no");
		int num = sc.nextInt();
		sc.nextLine();
		if (num == 1) {
			System.out.println("보스도전");
			result = true;
		}
		return result;
	}

	Monster makeMonsters(int stage) {// 여러마리 중 한마리만 나오게
		Random rand = new Random();
		int numOfMonsters = rand.nextInt(5) + 1;// 몬스터 마리수
		ArrayList<Monster> monsters = new ArrayList<>(numOfMonsters);

		Monster randMonster = new Monster();
		try {
			if (!(stage >= Rounds.first) && (stage <= Rounds.twelveth)) {// 스테이지 예외처리
				OutOfStage o = new OutOfStage();
				throw o;
			}
		} catch (OutOfStage o) {
			System.out.println("올바른 스테이지 범위가 아닙니다");
		} catch (Exception e) {

		} finally {

		}
		int randIndex = rand.nextInt(numOfMonsters);// 랜덤 인덱스
		int randValue = rand.nextInt(20) + 10;
		for (int i = 0; i < numOfMonsters; i++) {// 이름, 능력치 다른 같은 종류의 여러마리의 몬스터 생성
			m = m.makeMonster(stage);
			if (m.title.equals("날쏀 ")) {// 종류가 '날쎈'일 경우에 evasion값 랜덤으로 증가시킴
				m.setEvasion(m.getEvasion() + randValue);
			} else if (m.title.equals("덩치가 큰 ")) {// 종류가 '덩치가 큰'일 경우에 health값 랜덤으로 증가시킴
				m.setCurrentHealth(m.getCurrentHealth() + randValue);
			} else if (m.title.equals("이빨이 날카로운 ")) {// 종류가 '이빨이 날카로운'일 경우에 strength값 랜덤으로 증가시킴
				m.setCurrentStrength(m.getCurrentStrength() + randValue);
			} else if (m.title.equals("알 수 없는 ")) {// 종류가 '알 수 없는'일 경우에 evasion/health/strength값 랜덤으로 증가시킴
				m.setEvasion(m.getEvasion() + randValue);
				m.setCurrentHealth(m.getCurrentHealth() + randValue);
				m.setCurrentStrength(m.getCurrentStrength() + randValue);
			}

			monsters.add(m);
//			monsters.get(i).showData();
		}

//		System.out.println(numOfMonsters+"마리의 "+m.getName()+"을/를 만났습니다");
		randMonster = monsters.get(randIndex);
		System.out.println(m.getName() + "을/를 만났습니다");
		m.showData();
		return randMonster;

	}

}

//	void bossRoom(Player p, int num) {
//
//		System.out.println(num + "단계 보스");
//		switch (num) {
//		case 1:
//			m = new Dog();
//			break;
//		case 2:
//			m = new Snake();
//			break;
//		case 3:
//			m = new Dragon();
//			break;
//		}
//		int result = b.choicePlayerMovement(m, p);
//		if (result == 0) {
//			System.out.println("다음스테이지 입장이 가능합니다.");
//			stage++;
//		} else {
//
//		}
//	}