package Codes;

public class Main {

	public static void main(String[] args) {
		
		Cat cat = new Cat("Kaori","2","Milk");
		Dog dog = new Dog("Charlie", "4", "Meat");
		System.out.println(cat.age+" "+cat.name+" "+cat.favorite);
		System.out.println(dog.age+" "+dog.name+" "+dog.favorite);
	}

}
