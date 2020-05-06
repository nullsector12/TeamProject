package game;

public class Battle {
	
	int damage;
	boolean result;
	String commands;
	
	void battle (Player p, Monsters m) {
		
		System.out.println("플레이어" + p.playerName + " 의 턴");
		
		while(true) {
			
			switch(commands) {
			case "attack":
				System.out.println("플레이어의 공격!");
				m.currentHealth = m.currentHealth-p.attackPower;
				System.out.println("몬스터의 체력이 " + m.currentHealth + "남았습니다.");
				break;
			}
			if(m.currentHealth <= 0) {
				System.out.println("몬스터가 쓰러졌습니다.");
				System.out.println(m.goldWorth +" 골드와 경험치" + m.expWorth +" 을(를) 획득했습니다.");
				p.currentExp = p.currentExp + m.expWorth;
				p.gold = p.gold + m.goldWorth;
			}
		}
		

		
		
		
	}


	
	
	

}
