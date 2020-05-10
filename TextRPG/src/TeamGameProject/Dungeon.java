package TeamGameProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import enemies.*;

/* 
 * 스테이지별 몬스터 불러오기
 * 보스입장 묻기
 * 보스잡아야 다음스테이지 입장가능
 */
public class Dungeon {

	int boss1Count; // 보스입장가능 카운트
	int boss2Count;
	int boss3Count;
	int stage2Count; // 스테이지 입장가능 카운트
	int stage3Count;
	Scanner sc;
	Monster m = new Monster();
	Player p = new Player();
	Battle b = new Battle();
	Events e = new Events();

	boolean result;

	boolean win;

	public Dungeon() {
		this.boss1Count = 0;
		this.boss2Count = 0;
		this.boss3Count = 0;
		this.stage2Count = 0;
		this.stage3Count = 0;
		sc = new Scanner(System.in);

	}

	// 스테이지 선택
	boolean stage(Player p) {
		int num = stageChoice();
		switch (num) {
		case DungeonIf.EASY:
			result = stageEasy(p);
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

		}
		return result;
	}

	void bossStage(Player p, int num) {
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
			e.rewordsOfVictory(p, m);
			if (result == 1) {// result==1(몬스터 체력0이하일때=몬스터 죽었을 때)로 변경
				switch (num) {
				case 1:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage2Count++;
					win = true;
					break;
				case 2:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage3Count++;
					win = true;
					break;
				case 3:
					System.out.println("마지막보스를 처치하셨습니다.");
					win = true;
					break;
				}
			}
		} else {

		}
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
		e.rewordsOfVictory(p, m);
		if (num == 3 && win == 0) {
			boss1Count++;
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p,1);
			result = true;
		} else if (win == 1) {
			result = e.takeDie(p);

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
			boss2Count++;
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p,2);
			result = true;
		} else if (win == 1) {
			result = e.takeDie(p);

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
			boss3Count++;
			System.out.println("스테이지를 모두 클리어 하셨습니다.");
			bossStage(p,3);
			result = true;
		} else if (win == 1) {
			result = e.takeDie(p);

		}
		return result;
	}

	// 스테이지 선택
	int stageChoice() {
		System.out.println("=====================");
		System.out.println("스테이지를 선택해주세요");
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
		} else {
			result = true;
		}
		return result;
	}

	boolean stage3Check() {

		boolean result = false;
		if (stage3Count == 0) {
			System.out.println("입장하실수 없습니다.");
		} else {
			result = true;
		}
		return result;
	}

	// 보스 입장가능 불가능할경우
	boolean boss1Check() {
		boolean result = false;
		if (boss1Count == 0) {
			System.out.println("입장하실수 없습니다.");
			result = true;
		}
		return result;
	}

	boolean boss2Check() {
		boolean result = false;
		if (boss2Count == 0) {
			System.out.println("입장하실수 없습니다.");
			result = true;
		}
		return result;
	}

	boolean boss3Check() {
		boolean result = false;
		if (boss3Count == 0) {
			System.out.println("입장하실수 없습니다.");
			result = true;
		}
		return result;
	}

	// 보스선택
	int bossChoice() {
		System.out.println("보스를 선택해주세요");
		System.out.println("1. 1단계 2. 2단계 3. 3단계");
		int num = sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:
			if (boss1Check()) {
				num = 4;
			}
			break;
		case 2:
			if (boss2Check()) {
				num = 4;
			}
			break;
		case 3:
			if (boss3Check()) {
				num = 4;
			}
			break;
		}

		return num;
	}

	// 진행여부 선택
	boolean playCheck() {

		boolean result = false;
		System.out.println("더 진행하시겠습니까? 1. yes 2.no");
		int num = sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:
			System.out.println("다음 스테이지로 진행합니다.");
			result = true;
			break;
		case 2:
			System.out.println("마을로 돌아갑니다.");
			break;
		}
		return result;
	}

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

		int randIndex = rand.nextInt(numOfMonsters);// 랜덤 인덱스

		for (int i = 0; i < numOfMonsters; i++) {// 이름, 능력치 다른 같은 종류의 여러마리의 몬스터 생성
			m = m.makeMonster(stage);
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
