package Codes;

public class Cat extends Animal {
	
	String favorite;
	
	Cat(String name, String age, String favorite){
		super(name,age);
		this.favorite = favorite;
	}

	public Cat() {
		
	}

	public void eat() {
		System.out.println("Cat eats fish");
	}
	public void makeSound() {
		System.out.println("Meow");
	}
}
