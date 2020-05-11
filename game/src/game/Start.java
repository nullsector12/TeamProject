package game;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Start extends Thread{
	
	Scanner sc = new Scanner(System.in);
	int width = 150;
	int height = 30;
	String str;
	public Start(String str) {
		this.str = str;
	}
	@Override
	public void run() {

		System.out.println("==========================");
		System.out.println("	G A M E\n	S T A R T");
		System.out.println("==========================");
		System.out.print("\nLoading : ");
		for(int i = 0; i < 15; i++) {
			System.out.print("■");//입력 방지 예외처리 필요
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
//		for(int i = 0; i<50; i++) {
//			System.out.println("");
//		}
//		
		System.out.println("\n\n--------------------------");
		System.out.println("시작하려면 ENTER 를 눌러주세요");
		System.out.println("--------------------------");
//		sc.nextLine();
		
		
	}	
}