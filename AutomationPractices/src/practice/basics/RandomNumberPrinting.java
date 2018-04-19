package practice.basics;

import java.util.Date;
import java.util.Random;

public class RandomNumberPrinting {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date date = new Date();
		String array[]= date.toLocaleString().split(" ");
	    System.out.println(date.getDate()+""+array[0]);
		Random CheckBoxNumber = new Random();
		for(int Counter=0; Counter<10; Counter++) {
			int SpeOption = CheckBoxNumber.nextInt(8)+3;
			System.out.println("Printing the Random Value in the range(3-11) as "+SpeOption);
		}
	}

}
