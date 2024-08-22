package oops;

public class Car extends Vehicle {

	@Override
	void drive() {
		System.out.println("driving a car.");
	}

	public void transportingPeople(Vehicle v) {
		v.drive();
		String name = v.getClass().getName();
		String substring = name.substring(name.indexOf(".") + 1);
		System.out.println("transporting people via :" + substring);

	}

	public static void main(String[] args) {
		Car car = new Car();
		car.transportingPeople(car);
	}
}
