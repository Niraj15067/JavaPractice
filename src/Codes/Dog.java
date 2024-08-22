package Codes;

public class Dog extends Animal {

	String favorite;
	
	Dog(String name, String age, String favorite){
		super(name, age);
		this.favorite = favorite;
	}
	
	public void eat() {
		System.out.println("Dog eats bones");
	}
	public void makeSound() {
		System.out.println("Bark");
	}
	
}
