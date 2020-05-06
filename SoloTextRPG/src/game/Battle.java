package game;

import java.util.Scanner;

public class Battle {
	
	int damage;
	public boolean result;
	Scanner commands = new Scanner(System.in);
	String command;
	
	void battle (Player p, Monsters m) {
		
		System.out.println("야생의 " + m.rat(null) + "이(가) 나타났다!");
		m.showMonsterInfo();
		System.out.println("플레이어 =" + p.playerName + "= 의 턴");
		

		while(true) {
			
			System.out.println("커맨드를 입력해주세요. : 공격");
			command = commands.nextLine();
			
			switch(command) {
				case "공격":
					System.out.println( p.playerName +" 의 공격!");
					m.currentHealth = m.currentHealth - p.attackPower;
					System.out.println(m.monsterName +" 의 체력이 " + m.currentHealth + "남았습니다.");
					if(m.currentHealth > 0) {
						System.out.println(m.monsterName +" 의 반격!");
						p.currentHealth = p.currentHealth - m.attackPower;
						System.out.println(p.playerName + " 의 체력이 현재 " + p.currentHealth + " 남았습니다.");
					}
					break;
				}
			if (m.currentHealth <=0) {
				break;	
			}else if(p.currentHealth <=0) {
				break;
			}
			}
		}
	}

