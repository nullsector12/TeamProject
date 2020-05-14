package items;

import java.util.ArrayList;
import java.util.Scanner;

import TeamGameProject.Player;

public class Inven {

	int check = -1;
	public int equipPower = 0;
	public int equipHealth = 0;
	public int equipEvasion = 0;

	// 장비를 저장할 인벤토리의 리스트
	public ArrayList<Item> inven = new ArrayList<Item>(30);

	// Inventory에서 캐릭터에 장착된 장비 리스트
	public ArrayList<Item> equip = new ArrayList<Item>(5);

	Scanner sc = new Scanner(System.in);

	// 장비의 참조값을 불러서 리스트에 저장하는 메서드

	public void addEquipment(Item info) {

		inven.add(info);

	}

	// Iterator<Item> list = item.iterator();

	// 장비의 목록을 보여주는 메서드

	public void showInventory() {
		System.out.println("");

		System.out.println("==============인벤토리==============");

		for (int i = 0; i < inven.size(); i++) {
			System.out.println((i + 1) + "." + inven.get(i).toString());

			System.out.println(
					"=========================================================================================================");

		}

	}

	public void showEquip() {
		System.out.println("");

		System.out.println("==============장착한 장비 목록==============");
		if (equip.size() == 0) {
			System.out.println("장착한 장비가 없습니다.");
		}
		for (int i = 0; i < equip.size(); i++) {
			System.out.println((i + 1) + "." + equip.get(i).toString());

			System.out.println(
					"=========================================================================================================");

		}

	}
	public void equipItem(Player p) {

		System.out.println("	=======================================");
		System.out.println("	장착할 장비를 골라주세요.");
		System.out.println("	=======================================");

		System.out.println("	0. 마을로 돌아가기");

		int select = sc.nextInt();

		sc.nextLine();

		if (select == 0) {
			return;
		}

		checkType(inven.get((select - 1)).equipmentType); // 장비 타입 비교해서 중복된 타입일 시 장비 반환

		equip.add(inven.get((select - 1)));

		System.out.println(inven.get((select - 1)).equipmentName + "장착");

		inven.remove((select - 1));

		int dmg = p.getInvenMaxHealth() - p.getInvenCurrentHealth();

		p.calEquipStat();
		System.out.println("	+ 장비 공격력 : " + equipPower + ", " + "+ 장비 체력 : " + equipHealth + ", "
				+ "+ 장비 회피율 : " + equipEvasion);
		p.setInvenCurrentStrength(p.getCurrentStrength() + equipPower);
		p.setInvenMaxHealth(p.getMaxHealth() + equipHealth);
		p.setInvenCurrentHealth(p.getCurrentHealth() + equipHealth - dmg);
		p.setInvenCurrentEvasion(p.getEvasion() + equipEvasion);

		showInventory();
		showEquip();

	}


	// 장비타입을 비교해서 인벤토리로 장착하던 장비 반환
	public void checkType(int checkNum) {

		for (int i = 0; i < equip.size(); i++) {

			if (checkNum == equip.get(i).equipmentType) {

				// check = checkNum;
				inven.add(equip.get(i));
				equip.remove(i);
				break;
			}

		}

	}
	
	public void buyEquipment(Player p, int select) {
		switch (select) {
		case 1:

			if (p.getA1().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getA1().gold);
			addEquipment(p.getA1());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 2:

			if (p.getA2().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getA2().gold);
			addEquipment(p.getA2());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 3:
			if (p.getB1().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getB1().gold);
			addEquipment(p.getB1());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 4:
			if (p.getB2().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getB2().gold);
			addEquipment(p.getB2());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 5:
			if (p.getB3().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getB3().gold);
			addEquipment(p.getB3());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 6:
			if (p.getC1().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getC1().gold);
			addEquipment(p.getC1());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 7:
			if (p.getC2().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getC2().gold);
			addEquipment(p.getC2());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 8:
			if (p.getC3().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getC3().gold);
			addEquipment(p.getC3());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 9:
			if (p.getD1().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getD1().gold);
			addEquipment(p.getD1());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 10:
			if (p.getD2().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getD2().gold);
			addEquipment(p.getD2());
			System.out.println("장비를 구매하였습니다.");

			break;

		case 11:
			if (p.getD3().gold > p.getGold()) {
				System.out.println("골드가 부족하여 구매할 수 없습니다.");
				break;
			}
			p.setGold(p.getGold() - p.getD3().gold);
			addEquipment(p.getD3());
			System.out.println("장비를 구매하였습니다.");

			break;
		default:
			System.out.println("잘못 선택하셨습니다.");
			break;

		}

	}

	public void sellItem(Player p) {

		System.out.println("=======================================");
		System.out.println("판매할 장비를 골라주세요.");
		System.out.println("=======================================");

		System.out.println("0. 마을로 돌아가기");

		int select = sc.nextInt();

		sc.nextLine();

		if (select == 0) {
			return;
		}
		p.setGold(p.getGold() + inven.get(select - 1).gold);
		inven.remove(select - 1);

		System.out.println("판매 되었습니다.");

	}
	
	
	
	
	
	
	
	
	
	
	
	

}