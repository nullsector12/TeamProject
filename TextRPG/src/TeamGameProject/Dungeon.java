package TeamGameProject;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/* 
 * 스테이지별 몬스터 불러오기
 * 보스입장 묻기
 * 보스잡아야 다음스테이지 입장가능
 */
public class Dungeon {

	Scanner sc;
	Monster m;
	Player p;
	Battle b;
	Events e;

	boolean result;

	boolean runCount;

	public Dungeon() {

		e = new Events();
		b = new Battle();
		p = new Player();
		m = new Monster();
		sc = new Scanner(System.in);
		runCount = false;

	}

	// 스테이지 선택
	boolean stage(Player p) throws InterruptedException {

		int num = stageChoice();

		switch (num) {
		case DungeonIf.EASY:
			result = stageEasy(p);
			p.skillInven.resetSkillChance();

			break;
		case DungeonIf.NOMAL:
			result = stageNomal(p);
			p.skillInven.resetSkillChance();

			break;
		case DungeonIf.HARD:
			result = stageHard(p);
			p.skillInven.resetSkillChance();

			break;
		case 4:
			result = true;
			break;
		}

		return result;
	}

	boolean bossStage(Player p, int num) throws InterruptedException {

		boolean win = false;

		if (playBoss()) {
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
					System.out.println("	-----------------------------------------");
					System.out.println("	│	     초급 던전 보스를 처치 하셨습니다.	│");
					System.out.println("	│	상위 난이도 던전 입장 권한이 생겼습니다.	│");
					System.out.println("	│	       추가 보상을 획득합니다.		│");
					System.out.println("	-----------------------------------------");
					p.setStage2Count(1);
					e.rewordsOfVictory(p, m);
					e.bonusRewordsKillBoss(p, m);
					win = true;
					break;

				case 2:
					System.out.println("	-----------------------------------------");
					System.out.println("	│	     중급 던전 보스를 처치 하셨습니다.	│");
					System.out.println("	│	상위 난이도 던전 입장 권한이 생겼습니다.	│");
					System.out.println("	│	       추가 보상을 획득합니다.		│");
					System.out.println("	-----------------------------------------");
					p.setStage3Count(1);
					e.rewordsOfVictory(p, m);
					e.bonusRewordsKillBoss(p, m);
					win = true;
					break;

				case 3:
					System.out.println("	------------------------");
					System.out.println("	축하합니다!");
					System.out.println("	마지막 보스를 클리어 하셨습니다!");
					System.out.println("	------------------------");
					e.rewordsOfVictory(p, m);
					e.bonusRewordsKillBoss(p, m);
					win = true;
					break;
				}
			} else if (result == 1) { // 보스전 패배 시
				e.morePenaltyDieBossBattle(p, m);
				win = e.takeDie(p);

			} else if (result == 2) {
				System.out.println("	========================= ");
				System.out.println("	│     마을로 돌아갑니다.	│");
				System.out.println("	=========================");
				win = true;

			} else {
				win = false;
			}
		}
		p.skillInven.resetSkillChance();
		return win;
	}

	// 초급스테이지
	boolean stageEasy(Player p) throws InterruptedException {

		System.out.println("	---------------------------");
		System.out.println("		★ 난이도 : 쉬움");
		System.out.println("	---------------------------");

		for (int i = 1; i < 4; i++) {

			result = stage1(p, i);

			if (result) {
				break;
			}
		}
		return result;
	}

	// 중급스테이지
	boolean stageNomal(Player p) throws InterruptedException {

		System.out.println("	---------------------------");
		System.out.println("		★ 난이도 : 보통");
		System.out.println("	---------------------------");

		for (int i = 1; i < 4; i++) {

			result = stage2(p, i);

			if (result) {
				break;
			}
		}
		return result;
	}

	// 상급스테이지
	boolean stageHard(Player p) throws InterruptedException {

		System.out.println("	---------------------------");
		System.out.println("		★ 난이도 : 어려움");
		System.out.println("	---------------------------");

		for (int i = 1; i < 4; i++) {

			result = stage3(p, i);

			if (result) {
				break;
			}
		}
		return result;
	}

	boolean stage1(Player p, int num) throws InterruptedException {

		result = false;

		switch (num) {
		case 1:

			m = makeMonsters(num);// 1 5 9
			break;
		case 2:

			m = makeMonsters(num);
			break;
		case 3:

			m = makeMonsters(num);
			break;
		}

		int win = b.choicePlayerMovement(m, p);

		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);

			System.out.println("	-----------------------------------------");
			System.out.println("	│	스테이지를 모두 클리어 하셨습니다.	│");
			System.out.println("	-----------------------------------------");
			bossStage(p, 1);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("	---------------------------------");
			System.out.println("	│	다음 스테이지로 이동합니다.	│");
			System.out.println("	---------------------------------");
		} else if (win == 1) {
			System.out.println("	 _______________________________");
			System.out.println("	/				\\");
			System.out.println("	│	전투에서 패배하였습니다.	│");
			System.out.println("	\\_______________________________/");
			result = e.takeDie(p);

		} else if (win == 2) {
			System.out.println("	========================= ");
			System.out.println("	│     마을로 돌아갑니다.	│");
			System.out.println("	=========================");
			result = true;
		}
		return result;
	}

	boolean stage2(Player p, int num) throws InterruptedException {
		result = false;

		switch (num) {
		case 1:

			m = makeMonsters(num + 4);// 1 5 9
			break;
		case 2:

			m = makeMonsters(num + 4);
			break;
		case 3:

			m = makeMonsters(num + 4);
			break;
		}

		int win = b.choicePlayerMovement(m, p);

		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);

			System.out.println("	-----------------------------------------");
			System.out.println("	│	스테이지를 모두 클리어 하셨습니다.	│");
			System.out.println("	-----------------------------------------");
			bossStage(p, 2);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("	---------------------------------");
			System.out.println("	│	다음 스테이지로 이동합니다.	│");
			System.out.println("	---------------------------------");
		} else if (win == 1) {
			result = e.takeDie(p);

		} else if (win == 2) {
			System.out.println("	========================= ");
			System.out.println("	│     마을로 돌아갑니다.	│");
			System.out.println("	=========================");
			result = true;
		}
		return result;
	}

	boolean stage3(Player p, int num) throws InterruptedException {
		result = false;
		switch (num) {
		case 1:

			m = makeMonsters(num + 8);// 1 5 9
			break;
		case 2:

			m = makeMonsters(num + 8);
			break;
		case 3:

			m = makeMonsters(num + 8);
			break;
		}

		int win = b.choicePlayerMovement(m, p);

		if (num == 3 && win == 0) {
			e.rewordsOfVictory(p, m);

			System.out.println("	-----------------------------------------");
			System.out.println("	│	스테이지를 모두 클리어 하셨습니다.	│");
			System.out.println("	-----------------------------------------");
			bossStage(p, 3);
			result = true;
		} else if (win == 0) {
			e.rewordsOfVictory(p, m);
			System.out.println("	---------------------------------");
			System.out.println("	│	다음 스테이지로 이동합니다.	│");
			System.out.println("	---------------------------------");
		} else if (win == 1) {
			result = e.takeDie(p);

		} else if (win == 2) {
			System.out.println("	========================= ");
			System.out.println("	│     마을로 돌아갑니다.	│");
			System.out.println("	=========================");
			result = true;
		}

		return result;
	}

	// 스테이지 선택
	int stageChoice() {
		System.out.println("\n\n\n\n\n\n\n");
		System.out.println("	=================================");
		System.out.println("	│	   던전을 선택해주세요		│");
		System.out.println("	│				│");
		System.out.println("	│   1. 초급 던전 (적정 레벨 1 ~ 9)	│");
		System.out.println("	│  2. 중급 던전 (적정 레벨  8 ~ 15)	│");
		System.out.println("	│  3. 상급 던전 (적정 레벨 14 ~ 30)	│");
		System.out.println("	=================================");
		System.out.println("\n\n\n\n");
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

		if (p.getStage2Count() == 0) {
			System.out.println("	+=======================================+");
			System.out.println("	│	           입장 권한이 없습니다.		│");
			System.out.println("	│	 ※ 입장 조건 : 초급 던전의 보스 클리어	│");
			System.out.println("	+=======================================+");
			result = true;
		}
		return result;
	}

	boolean stage3Check() {

		boolean result = false;

		if (p.getStage3Count() == 0) {
			System.out.println("	+=======================================+");
			System.out.println("	│	           입장 권한이 없습니다.		│");
			System.out.println("	│	 ※ 입장 조건 : 중급 던전의 보스 클리어	│");
			System.out.println("	+=======================================+");

			result = true;
		}
		return result;
	}

	boolean playBoss() throws InterruptedException {
		boolean result = false;
		System.out.println("\n\n\n\n");
		System.out.println("	+====================	C A U T I O N	========================+");
		System.out.println("	│								│");
		System.out.println("	│	         던전의 보스는 상당히 강력하며 귀환 시 패널티를 받습니다.		│");
		System.out.println("	│	     패배 시에도 일반적인 사망 패널티보다 더 많은 골드를 잃습니다.		│");
		System.out.println("	│	보스를 쓰러트렸을 경우에는 추가 경험치와 골드를 획득 할 수 있습니다.	│");
		System.out.println("	│								│");
		System.out.println("	+===============================================================+");
		System.out.println("\n\n\n\n");
		Thread.sleep(1000);
		System.out.println("	+===============================================================+");
		System.out.println("	│								│");
		System.out.println("	│		           보스에 도전하시겠습니까? y or n			│");
		System.out.println("	│								│");
		System.out.println("	+===============================================================+");
		String num = sc.nextLine();

		if (num.equals("y")) {

			System.out.println("	던전의 보스가 등장합니다. 행운을 빕니다.");
			Thread.sleep(1000);
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
		int randValue = rand.nextInt(20) + 10;
		for (int i = 0; i < numOfMonsters; i++) {// 이름, 능력치 다른 같은 종류의 여러마리의 몬스터 생성
			m = m.makeMonster(stage);
			if (m.title.equals("날쌘 ")) {// 종류가 '날쎈'일 경우에 evasion값 랜덤으로 증가시킴
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

		}

		randMonster = monsters.get(randIndex);
		System.out.println("\n" + "	▶ " + m.getName() + " 을(를) 만났습니다");
		System.out.println("\n");
		return randMonster;

	}

}