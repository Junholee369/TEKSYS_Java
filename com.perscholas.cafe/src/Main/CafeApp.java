package Main;

import java.util.Scanner;

public class CafeApp extends Product {

	public static void main(String[] args) {
		Product coffee = new Product("Coffee", 2.50, "Medium Roast");
		Product espresso = new Product("Espresso", 1.75, "For those bitter days");
		Product cappuccino = new Product("Cappuccino", 3.25, "This will send you Cloud 9");

		Scanner scn = new Scanner(System.in);
		String prod;
		int quantity;

		try {
			System.out.println("What would you like to drink?");
			System.out.println("We have Coffee, Espresso, and Cappuccino.");
			prod = scn.nextLine();
			System.out.println("Enter quantity?");
			quantity = scn.nextInt();

		} finally {
			if (scn != null) {

				scn.close();
			}
		}

		String menuOption;
		int finalQuantity = 0;
		String description = null;
		double subTotal = 0;
		double salesTax = 0;
		double price = 0;
		double total = 0;

		switch (prod) {
		case "coffee":
			menuOption = coffee.getName();
			finalQuantity = quantity;
			description = coffee.getDescription();
			price = coffee.getPrice();
			subTotal = coffee.calculateSubTotal(finalQuantity, price);
			salesTax = coffee.calculateSalesTax(finalQuantity, price);
			total = coffee.calculateProductTotal(finalQuantity, price);
			break;
		case "espresso":
			menuOption = espresso.getName();
			finalQuantity = quantity;
			description = espresso.getDescription();
			price = espresso.getPrice();
			subTotal = espresso.calculateSubTotal(finalQuantity, price);
			salesTax = espresso.calculateSalesTax(finalQuantity, price);
			total = espresso.calculateProductTotal(finalQuantity, price);
			break;
		case "cappuccino":
			menuOption = cappuccino.getName();
			finalQuantity = quantity;
			description = cappuccino.getDescription();
			price = espresso.getPrice();
			subTotal = cappuccino.calculateSubTotal(finalQuantity, price);
			salesTax = cappuccino.calculateSalesTax(finalQuantity, price);
			total = cappuccino.calculateProductTotal(finalQuantity, price);
			break;
		default:
			menuOption = "Not a valid item";
			break;
		}

		if (finalQuantity != 0) {
			for (int i = 0; i <= finalQuantity; i++) {
				System.out.println(menuOption + "|" + description + "|" + "$" + subTotal);
			}
			System.out.println("$" + Math.round(subTotal));
			System.out.println("$" + Math.round(salesTax));
			System.out.println("$" + Math.round(total));
		} else {
			System.out.println("Wat?");
		}

	}

}
