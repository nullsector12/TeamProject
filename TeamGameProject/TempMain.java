package TeamGameProject;

import java.util.Random;

public class TempMain {
	Random rand = new Random();

	public static void main(String[] args) {

		Town t = new Town();
		System.out.println("----------------------------------");
		System.out.println("게임을 시작합니다.");
		t.d.p.addName();
		System.out.println("어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");

		while (true) {
			t.town();
		}
	}

}