package comprable_comparator;

public class OvDefualtMethod {
	public static void main(String[] args) {
		OverrideKro ov = new OverrideKro();
		ov.display();
	}
}

class OverrideKro implements dfd, Niraj {
	public void display() {
		dfd.super.display();
		Niraj.super.display();
	}
}

interface Niraj {
	public default void display() {
		System.out.println("Niraj");
	}
}

interface dfd {
	public default void display() {
		System.out.println("niraj");
	}
}
