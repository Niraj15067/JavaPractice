package oops;

public class Dog implements Animal{

	@Override
	public void eat() {
		System.out.println("Dog eats bones.");
		
	}

	@Override
	public void sleep() {
		System.out.println("Dog is now sleeping.");
		
	}

	@Override
	public void sound() {
		System.out.println("Dog barks!");
		
	}

}
