package myFirstJavaProject;

import java.awt.print.Printable;
import java.util.Scanner;

public class main {

	/* Starting point */
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

//		String name = "Junho";
//				
//		System.out.println(name);
//		System.out.println("Hello World");
//		
//		int number;
//		int num =203;
//		
//		double radius;
//		double area;
//		
//		radius = 20;
//		
//		area = radius * radius * 3.14159;
//		System.out.println("$" + area);
		
		System.out.println("Enter your name: ");
		String firstName = userInput.nextLine();
		String lastName = userInput.nextLine();
		System.out.println("My name is: " + firstName +" "+ lastName);
		
		//close scanner
		userInput.close();
	}

}
