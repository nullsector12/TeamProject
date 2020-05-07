package dungeon;

import player.*;

import monster.*;

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
		b = new Battle();

	}

	// 스테이지 선택
	void stage(Player p) {
		this.p = p;
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

	// 초급스테이지
	void stageEasy(Player p) {
		System.out.println("난이도 : 쉬움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i+"단계");
			stage1(p, i);
			
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");
	}

	// 중급스테이지
	void stageNomal(Player p) {

		System.out.println("난이도 : 보통");
		for (int i = 1; i < 4; i++) {
			System.out.println(i+"단계");
			stage2(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");

	}

	// 상급스테이지
	void stageHard(Player p) {

		System.out.println("난이도 : 어려움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i+"단계");
			stage3(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");

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
		b.battle(m, p);

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
		b.battle(m, p);

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
		b.battle(m, p);

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