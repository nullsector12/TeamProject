package items;

import java.util.ArrayList;
import java.util.Scanner;

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


	
	// 장비 장착 메서드

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

}