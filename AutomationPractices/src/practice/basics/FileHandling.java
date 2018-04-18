package practice.basics;

import java.util.Scanner;

public class FileHandling {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //System.in is an input stream
		 
		System.out.print("Enter Your Name: ");
		String name = scan.nextLine();
		 
		System.out.print("Enter Your City: ");
		String city = scan.next();
		 
		System.out.print("Enter Age: ");
		int num = scan.nextInt();
		 
		System.out.print("Enter a Mobile Number: ");
		long num2 = scan.nextLong();
		  
		System.out.print("Enter your lucky number: ");
		double num3 = scan.nextDouble();
		 
		System.out.print("Enter your Initial: ");
		char a = scan.next().charAt(0);
		 
		System.out.print("Enter the Value as \"true\": ");
		boolean val = scan.nextBoolean();


		System.out.println("Welcome to Selenium");//Welcome to Selenium
		System.out.println("You are Name is "+name);
		System.out.println("Your City is "+ city);
		System.out.println("You entered the age as "+num);
		System.out.println("Your Mobile Number is "+num2);
		System.out.println("Your Random Number is "+num3);
		System.out.println("Your Initial is "+a);
		System.out.println("Agreed Terms & Conditions as "+val);

		scan.close();


	}

}
