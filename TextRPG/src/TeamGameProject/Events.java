package TeamGameProject;

public class Events {
	
	Battle result = new Battle();
	Monster m = new Monster(); 
	Player p = new Player();
	
	
	void rewordsOrPenalty(int result){
		
		// 0 = 패배 시, 1 = 승리 시 
		// 승리 시
		if(result == 1) {
			System.out.println("축하합니다. 전투에서 승리하였습니다!");
			
			if(p.getCurrentLevel() > (m.getWeakness()+3)) {
				System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
				p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth()/2));
				p.setGold(p.getGold() + (m.getGoldWorth()/2));
				System.out.println((m.getGoldWorth()/2) +" 골드와  \n경험치" + (m.getExpWorth()/2) +" 을(를) 획득했습니다.");
				p.checkLevelUp(p);
				
			}else if(p.getCurrentLevel() > (m.getWeakness()+4)) {
				System.out.println("적정 레벨범위를 넘은 몬스터를 사냥하면 획득 가능한 경험치와 골드가 줄어듭니다.");
				p.setCurrentExp(p.getCurrentExp() + (m.getExpWorth()/3));
				p.setGold(p.getGold() + (m.getGoldWorth()/3));
				System.out.println((m.getGoldWorth()/3) +" 골드와 \n경험치" +(m.getExpWorth()/3)+" 을(를) 획득했습니다.");
				p.checkLevelUp(p);
				
			}else if(p.getCurrentLevel() > (m.getWeakness()+5)) {
				System.out.println("약한 몬스터를 괴롭히지 맙시다.");
				p.setCurrentExp(p.getCurrentExp() + 0);
				p.setGold(p.getGold() + 0);
				System.out.println("경험치와 골드를 얻지 못했습니다.");
				p.checkLevelUp(p);
				
			}else {
				p.setGold(p.getGold()+m.getGoldWorth());
				p.setCurrentExp(p.getCurrentExp() + m.getExpWorth());
				System.out.println(m.getGoldWorth()+ " 골드와 \n 경험치" + m.getExpWorth() + " 을(를) 획득했습니다.");
				p.checkLevelUp(p);
				}
			
			// 패배 시
		}else if (result == 0) {
			System.out.println("플레이어의 체력이 0이 되어 쓰러졌습니다.");
			System.out.println("쓰러져있던 플레이어를 마을로 이송합니다. : 이송 비용 발생");
			
			// 패널티를 지불할 충분한 골드가 있을 시
			if((p.getGold() - (p.getCurrentLevel()*100)) > 0) {
			p.setGold(p.getGold() - (p.getCurrentLevel()*100));
			System.out.println("이송 비용으로 " +(p.getGold() - (p.getCurrentLevel()*100)) + " 이(가) 청구됩니다.");
			System.out.println("남은 골드 : " + p.getGold());
			
			// 패널티를 지불할 충분한 골드가 없을 시
			} else if ((p.getGold() - (p.getCurrentLevel()*100)) < 0) {
				System.out.println("이송 비용을 지불할 소지금이 부족합니다.");
			}
		} 

	}
}
