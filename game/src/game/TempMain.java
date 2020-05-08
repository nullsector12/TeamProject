package game;

import java.util.ArrayList;
import java.util.Random;

public class TempMain {
	Random rand = new Random();

	public static void main(String[] args) {

		Dungeon d = new Dungeon();
		
		System.out.println("----------------------------------");

		d.p.addName();

		d.stage(d.p);
		
		
	}

}