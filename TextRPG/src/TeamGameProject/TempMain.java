package TeamGameProject;

import java.util.Random;
import java.util.Scanner;

public class TempMain {
	Random rand = new Random();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Start s=new Start("a");
		s.start();
		
		System.out.println("\n시작하려면 ENTER 를 눌러주세요\n");//깜박이게 스레드 넣어도 좋을듯
		if(sc.hasNextLine())//엔터 두 번 쳐야되는 오류 있음
			s.stop();
		try {
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Town t = new Town();
		System.out.println("----------------------------------");
		System.out.println("게임을 시작합니다.");
		t.d.p.addName();
		System.out.println("어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");
		
		
		while(true) {
		t.town();
		}
	}

}