package TeamGameProject;

import java.util.Random;

public class TempMain {
	Random rand = new Random();

	public static void main(String[] args) throws InterruptedException {

		Town t = new Town();

		System.out.println("		    ADVENTURE OF JAVA");
		System.out.println("		-------------------------");
		System.out.println("		|	GAME START	|");
		System.out.println("		-------------------------");
		t.d.p.addName();
		System.out.println("\n\n");
		System.out.println("	어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");

		while (true) {
			t.town();
		}
	}

}