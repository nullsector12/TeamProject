package ex;

import java.util.Scanner;

/* 
 * 스테이지별 몬스터 불러오기
 * 보스입장 묻기
 * 보스잡아야 다음스테이지 입장가능
 */
public class Dungeon {

	int bossCount;
	int boss1Count;
	int boss2Count;
	int stage;
	Scanner sc;
	Monster m;
	Player p;
	Battle b;

	public Dungeon() {
		this.bossCount = 0;
		this.boss1Count = 0;
		this.boss2Count = 0;
		this.stage = 0;
		sc = new Scanner(System.in);

	}
	
	//스테이지 선택
	void stage(Player p) {
		int num = stageChoice();
		switch (num) {
		case DGIF.EASY:
			stageEasy(p);
			break;
		case DGIF.NOMAL:
			stageNomal(p);
			break;
		case DGIF.HARD:
			stageHard(p);
			break;
		}
	}
	
	//초급스테이지
	void stageEasy(Player p) {

		stage = 1;
		System.out.println("Easy스테이지에 입장하셨습니다");
		room1_1(p);
		room1_2(p);
		room1_3(p);
		System.out.println("보스를 도전 하시겠습니까? 1.Yes 2.No");
		int n = sc.nextInt();
		if (n == 1) {
			bossChoice(n, p);
		} else {

		}
	}
	
	//중급스테이지
	void stageNomal(Player p) {

		stage = 5;
		room2_1(p);
		room2_2(p);
		room2_3(p);
		System.out.println("보스를 도전 하시겠습니까? 1.Yes 2.No");
		int num = sc.nextInt();
		if (num == 1) {
			num = 2;
			bossChoice(num, p);
		} else {

		}

	}

	//상급스테이지
	void stageHard(Player p) {

		stage = 9;
		room3_1(p);
		room3_2(p);
		room3_3(p);
		System.out.println("보스를 도전 하시겠습니까? 1.Yes 2.No");
		int num = sc.nextInt();
		if (num == 1) {
			num = 3;
			bossChoice(num, p);
		} else {

		}
	}

	void room1_1(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room1_2(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room1_3(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
		bossCount++;
	}

	void bossRoom1(Player p) {
		if (bossCount < 1) {
			System.out.println("입장하실수 없습니다");
		}
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room2_1(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room2_2(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room2_3(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
		boss1Count++;
	}

	void bossRoom2(Player p) {
		if (boss1Count < 1) {
			System.out.println("아직 입장하실수 없습니다");
		}
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room3_1(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room3_2(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}

	void room3_3(Player p) {
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
		boss2Count++;
	}

	void bossRoom3(Player p) {
		if (boss2Count < 1) {
			System.out.println("아직 입장하실수 없습니다");
			return;
		}
		m = m.makeMonster(stage);
		b.choicePlayerMovement(m, p);
		stage++;
	}
	
	//보스선택
	void bossChoice(int n, Player p) {
		switch (n) {
		case 1:
			bossRoom1(p);
			break;
		case 2:
			bossRoom2(p);
			break;
		case 3:
			bossRoom3(p);
			break;
		}
	}

	int stageChoice() {
		System.out.println("=====================");
		System.out.println("스테이지를 선택해주세요");
		System.out.println("1. Easy 2. Nomal 3. Hard");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}
}