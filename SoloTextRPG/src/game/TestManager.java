package game;

import java.util.Scanner;

public class TestManager {
	
	Scanner input = new Scanner(System.in);
	Player hero = new Player();
	Monsters enemy = new Monsters();
	Dungeon cave = new Dungeon();
	Battle fight = new Battle();
	Events events = new Events();
	
	
	
	// 플레이어 생성 기능
	void createPlayer() {
		System.out.println("플레이어 이름 입력 :");
		hero.playerName = input.nextLine();
		hero.showPlayerInfo();
		System.out.println();
	}

	// 몬스터 생성 기능
	void createMonster() {
		enemy.rat(null);
		System.out.println();
	}
	
	// 입장 던전 보여주는 기능
	void printCave() {
		System.out.println(cave.cave1(null));
	}
	
	// 전투 기능
	void battle() {
		enemy.rat(null);
		fight.battle(hero, enemy);
		
		if(enemy.currentHealth <= 0) {
			System.out.println("전투 승리");
			System.out.println(enemy.getMonsterName() +" 이(가) 쓰러졌습니다.");
			
			// 일정 레벨이상 차이나면 획득하는 전리품 줄어듦
			if(hero.getLevel() > (enemy.level+3)) {
				System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
				hero.currentExp += (enemy.expWorth)/2;
				hero.gold += (enemy.goldWorth)/2;
				System.out.println((enemy.goldWorth)/2 +" 골드와 경험치" + (enemy.expWorth)/2 +" 을(를) 획득했습니다.");
				
			}else if(hero.getLevel() > (enemy.level+4)) {
				System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
				hero.currentExp += (enemy.expWorth)/3;
				hero.gold += (enemy.goldWorth)/3;
				System.out.println((enemy.goldWorth)/3 +" 골드와 경험치" + (enemy.expWorth)/3 +" 을(를) 획득했습니다.");
				
			}else if(hero.getLevel() > (enemy.level+5)) {
				System.out.println("자신의 레벨보다 5 이하의 몬스터를 사냥하면 경험치와 골드를 얻을 수 없습니다.");
				hero.currentExp += 0;
				hero.gold += 0;
				System.out.println("경험치와 골드를 얻지 못했습니다.");
				
			}else {
				System.out.println(enemy.goldWorth +" 골드와 경험치" + enemy.expWorth +" 을(를) 획득했습니다.");
				hero.currentExp = hero.currentExp + enemy.expWorth;
				hero.gold = hero.gold + enemy.goldWorth;
				hero.canLevelUp();
			}
		}else if(hero.currentHealth <= 0){
			System.out.println("죽었습니다.");
			// 현재 게임 종료 후에도 무한루프 돌아감, 후에 retry 여부 확인문 넣으면 될듯
			// 어떻게 끝내지...
			System.out.println("=== GAME OVER ===");
			System.exit(0);
		}
	
	}
	void showPlayerInfo() {
		System.out.println("플레이어 이름 : " + hero.playerName);
		System.out.println("레벨 : " + hero.level);
		System.out.println("체력 :" + hero.currentHealth +"/" + hero.maxHealth);
		System.out.println("공격력 : " + hero.attackPower);
		System.out.println("회피율 : " + hero.evasion);
		System.out.println("경험치 : " + hero.currentExp + "/" + hero.nextLevelExp);
		System.out.println("소유 골드 : " + hero.gold +" Gold");
	}
	void makeEvents() {
		events.makeQuest();
		
	}
}
