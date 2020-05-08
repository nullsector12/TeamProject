package TeamGameProject;

import java.util.Scanner;

import enemies.*;

/* 
 * 스테이지별 몬스터 불러오기
 * 보스입장 묻기
 * 보스잡아야 다음스테이지 입장가능
 */
public class Dungeon {

	int boss1Count;
	int boss2Count;
	int boss3Count;
	int stage1;
	int stage2;
	Scanner sc;
	Monster m = new Monster();
	Player p = new Player();
	Battle b = new Battle();

	public Dungeon() {
		this.boss1Count = 0;
		this.boss2Count = 0;
		this.boss3Count = 0;
		this.stage1 = 0;
		this.stage2 = 0;
		sc = new Scanner(System.in);

	}

	// 스테이지 선택
	void stage(Player p) {
		this.p = p;
		int num = stageChoice();
		switch (num) {
		case DungeonIf.EASY:
			stageEasy(p, num);
			break;
		case DungeonIf.NOMAL:
			stageNomal(p, num);
			break;
		case DungeonIf.HARD:
			stageHard(p, num);
			break;
		}
	}

	void bossStage(Monster m, Player p, int num) {
		System.out.println("보스에 도전하시겠습니까?");
		System.out.println("1. Yes 2. No");
		int select = sc.nextInt();
		sc.nextLine();
		if (select == 1) {
			switch (num) {
			case 1:
				m = new Dog();
				break;
			case 2:
				m = new Snake();
				break;
			case 3:
				m = new Dragon();
				break;
			}
			System.out.println(m.getName());
			int result = b.choicePlayerMovement(m, p);
			if (result == 0) {
				switch (num) {
				case 1:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage1++;
					break;
				case 2:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage2++;
					break;
				case 3:
					System.out.println("마지막보스를 처치하셨습니다.");
					break;
				}
			}
		} else {

		}
	}

	// 초급스테이지
	void stageEasy(Player p, int num) {
		System.out.println("난이도 : 쉬움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage1(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");
		bossStage(m, p, num);

	}

	// 중급스테이지
	void stageNomal(Player p, int num) {

		System.out.println("난이도 : 보통");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage2(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");
		bossStage(m, p, num);

	}

	// 상급스테이지
	void stageHard(Player p, int num) {

		System.out.println("난이도 : 어려움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage3(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");
		bossStage(m, p, num);

	}

	void stage1(Player p, int num) {

		switch (num) {
		case 1:
			m = new Rat();

			break;
		case 2:
			m = new Chicken();
			break;
		case 3:
			m = new Rabbit();
			break;
		}
		System.out.println(m.getName());
		int result = b.choicePlayerMovement(m, p);
		if (num == 3 && result == 0) {
			boss1Count++;
		}

	}

	void stage2(Player p, int num) {

		switch (num) {
		case 1:
			m = new Monkey();
			break;
		case 2:
			m = new Sheep();
			break;
		case 3:
			m = new Pig();
			break;
		}
		System.out.println(m.getName());
		int result = b.choicePlayerMovement(m, p);
		if (num == 3 && result == 0) {
			boss2Count++;
		}
	}

	void stage3(Player p, int num) {

		switch (num) {
		case 1:
			m = new Horse();
			break;
		case 2:
			m = new Cow();
			break;
		case 3:
			m = new Tiger();
			break;
		}
		System.out.println(m.getName());
		int result = b.choicePlayerMovement(m, p);
		if (num == 3 && result == 0) {
			boss3Count++;
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

	int stageChoice() {
		System.out.println("=====================");
		System.out.println("스테이지를 선택해주세요");
		System.out.println("1. Easy 2. Nomal 3. Hard");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

//	int bossChoice() {
//		if(bossCount < 1) {
//			System.out.println("입장하실수 없습니다.");
//		}
//		System.out.println("====================");
//		System.out.println("보스를 선택해주세요");
//		System.out.println("1. 1단계 2. 2단계 3. 3단계");
//		int num = sc.nextInt();
//		sc.nextLine();
//
//		return num;
//	}
}