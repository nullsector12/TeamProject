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

	int boss1Count;
	int boss2Count;
	int boss3Count;
	int stage1;
	int stage2;
	Scanner sc;
	Monster m = new Monster();
	Player p = new Player();
	Battle b = new Battle();
	Events e = new Events();
	
	
	boolean win;
	boolean stageFailed;

	public Dungeon() {
		this.boss1Count = 0;
		this.boss2Count = 0;
		this.boss3Count = 0;
		this.stage1 = 0;
		this.stage2 = 0;
		sc = new Scanner(System.in);

		win = false;

	}

	// 스테이지 선택
	boolean stage(Player p) {
		int num = stageChoice();
			switch (num) {
			case DungeonIf.EASY:
				stageFailed = stageEasy(p);
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
				stageNomal(p);
				if(bossStage(m, p, 2)) {
					stageHard(p);
					if(bossStage(m,p,3)) {
						System.out.println("플레이어 최종 승리");
					}else {
						break;//일단 break
					}
				}
				break;
			case DungeonIf.HARD:
				stageHard(p);
				bossStage(m, p, 3);
				break;
	
			}
			return stageFailed;
		}

	// 초급스테이지
	boolean stageEasy(Player p) {
		System.out.println("난이도 : 쉬움");
		for (int i = 1; i < 4; i++) {
			if(!stage1(p, i)) {
				System.out.println(i + "단계");
		}else {
			stageFailed = true;
			break;
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");
		}
		return stageFailed;
	}

	// 중급스테이지
	void stageNomal(Player p) {

		System.out.println("난이도 : 보통");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage2(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");

	}

	// 상급스테이지
	void stageHard(Player p) {

		System.out.println("난이도 : 어려움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage3(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");

	}

	boolean stage1(Player p, int num) {// 스테이지 별 같은 종류/다른 능력치 몬스터 여러마리 생성

		switch (num) {
		case 1:

//			numOfMonsters=rand.nextInt(5)+1;
//			monsters=new ArrayList<>(numOfMonsters);
//			
//			
//			for (int i = 0; i < numOfMonsters; i++) {
//				m = new Rat();
//				monsters.add(m);
//				monsters.get(i).showData();
//				System.out.println("===================================");
//			}
//			
//			System.out.println(numOfMonsters+"마리의 "+m.getName()+"을/를 만났습니다");

//			m=new Rat();
//			makeMonsters(m);
			m = makeMonsters(num);
			break;
		case 2:
//			m = new Chicken();
//			makeMonsters(m);
			m = makeMonsters(num);
			break;
		case 3:
//			m = new Rabbit();
//			makeMonsters(m);
			m = makeMonsters(num);
			break;
		}
		
		b.choicePlayerMovement(m, p);
		if(e.takeDie(p)) { // 플레이어 사망 시 마을로 돌아간다고 선택했을 때
			stageFailed = true;
		}else {
			e.rewordsOfVictory(p, m);
		}
		// System.out.println(result);
		return stageFailed;
	}

	void stage2(Player p, int num) {

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
		
		b.choicePlayerMovement(m, p);
	}

	void stage3(Player p, int num) {

		switch (num) {
		case 1:
//			m = new Horse();
			m = makeMonsters(num + 8);
			break;
		case 2:
//			m = new Cow();
			m = makeMonsters(num + 8);
			break;
		case 3:
//			m = new Tiger();
			m = makeMonsters(num + 8);
			break;
		}
		
		b.choicePlayerMovement(m, p);

	}

	int stageChoice() {
		System.out.println("=====================");
		System.out.println("스테이지를 선택해주세요");
		System.out.println("1. Easy 2. Nomal 3. Hard");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	int bossChoice() {
		System.out.println("====================");
		System.out.println("보스를 선택해주세요");
		System.out.println("1. 1단계 2. 2단계 3. 3단계");
		int num = sc.nextInt();
		sc.nextLine();

		return num;
	}

	// ===============================================================보스 스테이지
	boolean bossStage(Monster m, Player p, int num) {
		win=false;
		System.out.println("보스에 도전하시겠습니까?");
		System.out.println("1. Yes 2. No");
		int select = sc.nextInt();
		sc.nextLine();
		if (select == 1) {
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
			if (result == 1) {//result==1(몬스터 체력0이하일때=몬스터 죽었을 때)로 변경
				switch (num) {
				case 1:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage1++;
					win = true;
					break;
				case 2:
					System.out.println(num + "단계 보스를 처치 하셨습니다.");
					System.out.println("다음스테이지 입장이 가능합니다.");
					stage2++;
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
		return win;
	}

	// ===============================================================몬스터 랜덤으로 생성 후
	// 소환하는 메서드

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

//	void makeMonsters(Monster mon) {//여러마리 중 한마리만 나오게
//		Random rand=new Random();
//		int numOfMonsters=rand.nextInt(5)+1;
//		ArrayList<Monster> monsters=new ArrayList<>(numOfMonsters);
//		
//		for (int i = 0; i < numOfMonsters; i++) {
//			monsters.add(mon);
//			monsters.get(i).showData();
//		}
//		
//		System.out.println(numOfMonsters+"마리의 "+m.getName()+"을/를 만났습니다");
//	}
}