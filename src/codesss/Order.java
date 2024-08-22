package codesss;

public class Order {

	private double price;
	private double qty;
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public Order(double price, double qty) {
		super();
		this.price = price;
		this.qty = qty;
	}
	
}
