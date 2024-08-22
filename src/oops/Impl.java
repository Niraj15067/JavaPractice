package oops;

public class Impl implements I1, I2 {

	@Override
	public void display() {
		System.out.println("this is the implementation!");

	}

	public String getName() {
		return I1.name;
	}

	public static void main(String[] args) {

//		Impl i1 = new Impl();
//		i1.display();
//		System.out.println(i1.getName());
//
//		I1 i2 = new Impl();
//		i2.display();
		Animal a = new Bird();
		a.sleep();
		a.sound();
		//cant access the overloaded sleep method in bird because of the reference type 
		Bird b =new Bird();
		int h = 10;
		byte b1 = 10;
		short s1 = 10;
		long l1 = 100;
		Integer i1 = 90;
		b.sleep(h);
		b.sleep(b1);
		b.sleep(s1);
		b.sleep(l1);
		b.sleep();

		Animal a1 = new Dog();
		a1.eat();
		a1.sleep();

	}

}
