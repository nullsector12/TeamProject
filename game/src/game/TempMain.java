package game;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Random;
import java.util.Scanner;

public class TempMain {
	Random rand = new Random();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Start s = new Start("a");
		int choice;
		//스레드 실행 후 메인 실행 안됨
		s.start();

//		if(sc.nextLine().trim().equals(""))//엔터 두 번 쳐야되는 오류 있음
//			s.stop();
		sc.nextLine();
		s.stop();
		try {
			s.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//System.out.println("스레드 종료");
		
		Town t = new Town();
		System.out.println("---------------------------");
		System.out.println("게임을 시작합니다.");//게임 이어서할건지
		//1새로 시작 2이어하기
			
		System.out.println("---------------------------");
		System.out.println("1.새로시작	2.이어하기");
		choice=sc.nextInt();
		if(choice==1) {//새로 시작
			t.d.p.addName();
			System.out.println("새로시작한다");

		}else if (choice==2){//게임 이어하기
			t.d.p.loadPlayer();
		}
		System.out.println("어서오세요." + t.d.p.getName() + "님, JAVA 마을에 오신 것을 환영합니다.");
		
		while (true) {
			t.town();
		}


	}

}