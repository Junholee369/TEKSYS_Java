package main;

public class coreJavaExcercisesVariables {

	public static void main(String[] args) {
		//1
		int a = 1;
		int b = 2;
		int sum = a + b;
		System.out.println(sum);
		
		//2
		double c = 1.5;
		double d = 2.5;
		int sum2 = a + b;
		System.out.println(sum2);
		
		//3
		int e = 1;
		double f = 1.5;
		double sum3 = e+f;
		System.out.println(sum3);
		//you need sum to be a double
		
		//4
		int g = 1;
		double h = 2.5; 
		double divide = h/g;
		System.out.println(divide);
		//you have to change the int into double since the result is going to be a decimal
		
		//5
		double i = 2.5;
		double j = 5.5;
		double divide2 = j/i;
		System.out.println((int)divide2);
		
		//6
		int x = 5;
		double y = 6.5;
		double q = y/x;
		System.out.println((int)q);
		
		//7
		final int CONSTANT = 8;
		System.out.println(CONSTANT + y);
		
		//8
		double Coffee = 1;
		double Latte = 2;
		double Espresso = 3.5;
		double subTotal = (Coffee*3) + (Latte*4) +(Espresso*2) ;
		final double SALES_TAX = .05;
		double totalSale = subTotal + .05;
		System.out.println(String.format("%.2f", totalSale));
		
	}

}
