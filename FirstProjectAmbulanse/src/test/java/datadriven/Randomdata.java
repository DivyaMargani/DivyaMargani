package datadriven;

import java.util.Random;

public class Randomdata {

	public static void main(String[] args) {

		Random rand=new Random();
		int randomnum=rand.nextInt(100)+1;
		System.out.println(randomnum);
		boolean randombool=rand.nextBoolean();
		System.out.println(randombool);
		
		
		
	}

}
