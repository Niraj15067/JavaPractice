package codesss;

import java.util.Objects;

public class LotModel {

	private double qty;
	private double price;
	@Override
	public int hashCode() {
		return Objects.hash(price, qty);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LotModel other = (LotModel) obj;
		return price == other.price && Double.doubleToLongBits(qty) == Double.doubleToLongBits(other.qty);
	}
	public LotModel(double qty, double price) {
		super();
		this.qty = qty;
		this.price = price;
	}
	public LotModel() {
		// TODO Auto-generated constructor stub
	}
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
	public String toString() {
		return "LotModel [qty=" + qty + ", price=" + price + "]";
	}
	
}
