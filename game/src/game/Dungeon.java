package game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import enemies.Chicken;
import enemies.Cow;
import enemies.Dog;
import enemies.Dragon;
import enemies.Horse;
import enemies.Monkey;
import enemies.Pig;
import enemies.Rabbit;
import enemies.Rat;
import enemies.Sheep;
import enemies.Snake;
import enemies.Tiger;

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
			stageEasy(p);
			break;
		case DungeonIf.NOMAL:
			stageNomal(p);
			break;
		case DungeonIf.HARD:
			stageHard(p);
			break;
		}
	}

	// 초급스테이지
	void stageEasy(Player p) {
		System.out.println("난이도 : 쉬움");
		for (int i = 1; i < 4; i++) {
			System.out.println(i + "단계");
			stage1(p, i);
		}
		System.out.println("스테이지를 모두 클리어 하셨습니다.");

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

	void stage1(Player p, int num) {// 스테이지 별 같은 종류/다른 능력치 몬스터 여러마리 생성
		Random rand = new Random();
		int numOfMonsters = 0;// 스테이지마다 랜덤하게 나오는 몬스터 마리 수
		ArrayList<Monster> monsters;

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
			m=makeMonsters(num);
			break;
		case 3:
			m = new Rabbit();
//			makeMonsters(m);
			m=makeMonsters(num);
			break;
		}
		System.out.println(m.getName());
		b.choicePlayerMovement(m, p);
		// System.out.println(result);

	}

	void stage2(Player p, int num) {

		switch (num) {
		case 1:
//			m = new Monkey();
			m=makeMonsters(num+4);//1 5 9
			break;
		case 2:
//			m = new Sheep();
			m=makeMonsters(num+4);
			break;
		case 3:
//			m = new Pig();
			m=makeMonsters(num+4);
			break;
		}
		System.out.println(m.getName());
		b.choicePlayerMovement(m, p);
	}

	void stage3(Player p, int num) {

		switch (num) {
		case 1:
//			m = new Horse();
			m=makeMonsters(num+8);
			break;
		case 2:
//			m = new Cow();
			m=makeMonsters(num+8);
			break;
		case 3:
//			m = new Tiger();
			m=makeMonsters(num+8);
			break;
		}
		System.out.println(m.getName());
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
	//===============================================================보스 스테이지
	void bossStage(Monster m, Player p, int num) {
		System.out.println("보스에 도전하시겠습니까?");
		System.out.println("1. Yes 2. No");
		int select = sc.nextInt();
		sc.nextLine();
		if (select == 1) {
			switch (num) {
			case 1:
				m=makeMonsters(num+3);
				break;
			case 2:
				m=makeMonsters(num+6);
				break;
			case 3:
				m=makeMonsters(num+9);
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
	
	//===============================================================몬스터 랜덤으로 생성 후 소환하는 메서드
	
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
		System.out.println(m.getName()+"을/를 만났습니다");
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