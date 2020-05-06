package game;

import java.util.Scanner;

public class Events {
	
	String choice;
	int numOfRequest = (int)((Math.random()*20)+1);
	Scanner input = new Scanner(System.in);
	Player p; 
	Monsters m; 
	Dungeon d;
	
	
	void makeQuest() {
		
		System.out.println("퀘스트가 도착했습니다. 확인하시겠습니까?");
		choice = input.nextLine();
		switch(choice) {
			case "ㅇ" :
				System.out.println(d.stage +" 에서" + m.monsterName +" 이(가) 대량으로 발생했습니다. 처리해주세요. ㅠㅠ");
				System.out.println("수락 하시겠습니까?");
				choice = input.nextLine();
				switch(choice) {
					case "ㅇ":
						p.acceptQuest(m.monsterName, d.stage, this.numOfRequest);
						System.out.println("퀘스트를 수락하였습니다. 퀘스트 내용 : " + d.stage +" 에서" + m.monsterName +" 을(를) " + numOfRequest +" 마리 잡아주세요.");
						break;
					case "ㅗ":
						System.out.println("나쁜놈 ㅠ");
						break;
					}
			case "ㅗ" :
				break;
		}
		
	}

	void QuestInfo(){
		System.out.println("잡아야하는 몬스터 : " );
		
		
	}
}
