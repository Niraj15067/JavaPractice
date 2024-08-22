package codesss;

import java.util.Objects;

public class TerminalModel{

	private double qty;
	private double price;
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(price, qty);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerminalModel other = (TerminalModel) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(qty) == Double.doubleToLongBits(other.qty);
	}
	@Override
	public String toString() {
		return "TerminalModel [qty=" + qty + ", price=" + price + "]";
	}
	public TerminalModel(double qty, double price) {
		super();
		this.qty = qty;
		this.price = price;
	}
	public TerminalModel() {
		super();
	}  
}
