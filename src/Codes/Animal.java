package Codes;

public class Animal {

	String name;
	String age;
	
	Animal(){
		
	}
	Animal(String name, String age){
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("Animals eat anything");
	}
	public void makeSound() {
		System.out.println("Animals have different sounds.");
	}
	
	
}
