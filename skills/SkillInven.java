package skills;

import java.util.ArrayList;
import java.util.Scanner;

import TeamGameProject.Player;

public class SkillInven {

	public ArrayList<Skill> skill = new ArrayList<Skill>(3);
	Scanner sc = new Scanner(System.in);

	public void buySkill(Player p, Skill s) {

		
		if (s.gold>p.getGold()) {
			System.out.println("골드가 부족하여 구매할수없습니다.");
			return;
		}		
		
		
		for (int i = 0; i < skill.size(); i++) {

			if (s.skillName.equals(skill.get(i).skillName)) {
				System.out.println("이미 가지고 있는 스킬입니다.");
				return;
			}
		}
		skill.add(s);

		p.setGold(p.getGold() - s.gold);

	}

	public Skill useSkill(Player p, int select) {

		

		skill.set(select , new Skill(skill.get(select).skillName, skill.get(select).numOfChance - 1, skill.get(select).multiple, skill.get(select).gold));
		
		Skill s = skill.get(select);
		
		
		
		
		return  s;
		
		
		

	}



	public void showSkill() {
		for (int i = 0; i < skill.size(); i++) {

			System.out.println((i + 1) + ". " + skill.get(i).toString());

		}

	}

}
