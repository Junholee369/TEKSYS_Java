package Main;

public class Product {
	
	private String name;
	private double price;
	private String description;
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public double calculateProductTotal(int quantity, double price) {
		return calculateSubTotal(quantity,price) + calculateSalesTax(quantity,price);
	}
	
	public double calculateSalesTax(int quantity, double price) {
		return (quantity*price) * .0775;
	}
	
	public double calculateSubTotal(int quantity, double price){
		return quantity*price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}